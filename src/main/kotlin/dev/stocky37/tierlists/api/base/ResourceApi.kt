package dev.stocky37.tierlists.api.base

import io.smallrye.mutiny.Uni


interface ResourceApi<Resource : Any> {
	fun get(id: String): Uni<Resource>
	fun delete(id: String): Uni<Void>
}