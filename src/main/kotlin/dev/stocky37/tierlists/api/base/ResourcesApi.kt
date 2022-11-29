package dev.stocky37.tierlists.api.base

import io.smallrye.mutiny.Uni


interface ResourcesApi<Resource : Any> {
	fun list(): Uni<List<Resource>>
	fun create(resource: Resource): Uni<Resource>
}
