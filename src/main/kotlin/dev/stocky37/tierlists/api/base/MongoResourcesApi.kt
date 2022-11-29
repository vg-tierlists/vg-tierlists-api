package dev.stocky37.tierlists.api.base

import com.mongodb.ErrorCategory
import com.mongodb.MongoWriteException
import dev.stocky37.tierlists.core.base.ResourceService
import io.smallrye.mutiny.Uni
import javax.inject.Inject
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response

abstract class MongoResourcesApi<Resource : Any> : ResourcesApi<Resource> {

	@Inject
	private lateinit var svc: ResourceService<Resource>

	override fun list(): Uni<List<Resource>> = svc.list()

	override fun create(resource: Resource): Uni<Resource> {
		try {
			return svc.create(resource)
		} catch (e: MongoWriteException) {
			throw if (e.error.category == ErrorCategory.DUPLICATE_KEY) {
				WebApplicationException(e.error.message, Response.Status.CONFLICT)
			} else {
				e
			}
		}
	}
}