package dev.stocky37.tierlists.api.base

import io.smallrye.mutiny.Uni
import javax.ws.rs.*


interface ResourceApi<Resource : Any> {
	@GET
	@Path("{id}")
	@Produces("application/json")
	fun get(id: String): Uni<Resource>

	@GET
	@Produces("application/json")
	fun list(): Uni<List<Resource>>

	@POST
	@Produces("application/json")
	fun create(resource: Resource): Uni<Resource>

	@DELETE
	@Path("{id}")
	@Produces("application/json")
	fun delete(id: String): Uni<Void>
}