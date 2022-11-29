package dev.stocky37.tierlists.core.base

import io.smallrye.mutiny.Uni


interface ResourceService<Resource : Any> {
	fun get(id: String): Uni<Resource?>
	fun list(): Uni<List<Resource>>
	fun create(resource: Resource): Uni<Resource>
	fun delete(id: String): Uni<Void>
}