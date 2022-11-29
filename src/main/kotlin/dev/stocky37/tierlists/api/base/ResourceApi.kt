package dev.stocky37.tierlists.api.base

import org.jboss.resteasy.annotations.jaxrs.PathParam
import javax.ws.rs.*


interface ResourceApi<Resource : Any> {
	@GET
	@Path("{id}")
	@Produces("application/json")
	fun get(@PathParam id: String): Resource

	@GET
	@Produces("application/json")
	fun list(): Collection<Resource>

	@POST
	@Produces("application/json")
	fun create(resource: Resource): Resource

	@DELETE
	@Path("{id}")
	@Produces("application/json")
	fun delete(@PathParam id: String): Resource
}