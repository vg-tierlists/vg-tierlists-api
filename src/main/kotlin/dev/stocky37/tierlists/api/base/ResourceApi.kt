package dev.stocky37.tierlists.api.base

import org.jboss.resteasy.annotations.jaxrs.PathParam
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces


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
}