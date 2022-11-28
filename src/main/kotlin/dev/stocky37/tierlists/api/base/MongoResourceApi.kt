package dev.stocky37.tierlists.api.base

import dev.stocky37.tierlists.core.base.ResourceService
import javax.inject.Inject
import javax.ws.rs.NotFoundException

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
		return svc.create(resource)
	}
}