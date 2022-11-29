package dev.stocky37.tierlists.api.base

import dev.stocky37.tierlists.core.base.ResourceService
import io.smallrye.mutiny.Uni
import javax.inject.Inject
import javax.ws.rs.NotFoundException

abstract class MongoResourceApi<Resource : Any> : ResourceApi<Resource> {
	@Inject
	private lateinit var svc: ResourceService<Resource>

	override fun get(id: String): Uni<Resource> =
		svc.get(id).onItem().ifNull().failWith(NotFoundException()).map { r -> r!! }


	override fun delete(id: String): Uni<Void> = svc.delete(id)
}