package dev.stocky37.tierlists.api.base

import io.smallrye.mutiny.Uni
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON


interface ResourcesApi<Resource : Any> {
	@GET
	@Produces(APPLICATION_JSON)
	fun list(): Uni<List<Resource>>

	@POST
	@Produces(APPLICATION_JSON)
	@Consumes(APPLICATION_JSON)
	fun create(resource: Resource): Uni<Resource>

	@Path("{id}")
	fun get(): ResourceApi<Resource>
}
