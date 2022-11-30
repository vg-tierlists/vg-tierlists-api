package dev.stocky37.tierlists.rest.base

import io.smallrye.mutiny.Uni


interface RestHelper<Resource : Any> {
	fun list(): Uni<List<Resource>>
	fun create(resource: Resource): Uni<Resource>
	fun get(id: String): Uni<Resource>
	fun delete(id: String): Uni<Void>
}