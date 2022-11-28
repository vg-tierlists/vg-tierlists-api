package dev.stocky37.tierlists.api.base

import com.mongodb.ErrorCategory
import com.mongodb.MongoWriteException
import dev.stocky37.tierlists.core.base.ResourceService
import javax.inject.Inject
import javax.ws.rs.InternalServerErrorException
import javax.ws.rs.NotFoundException
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response

abstract class MongoResourceApi<Resource : Any> : ResourceApi<Resource> {
	@Inject
	lateinit var svc: ResourceService<Resource>

	override fun get(id: String): Resource {
		return svc.get(id) ?: throw NotFoundException()
	}

	override fun list(): Collection<Resource> {
		return svc.list()
	}

	override fun create(resource: Resource): Resource {
		try {
			return svc.create(resource)
		} catch (e: MongoWriteException) {
			throw if (e.error.category == ErrorCategory.DUPLICATE_KEY) {
				WebApplicationException(e.error.message, Response.Status.CONFLICT)
			} else {
				InternalServerErrorException(e)
			}
		}
	}
}