package dev.stocky37.tierlists.api.base

import io.smallrye.mutiny.Uni
import org.jboss.resteasy.reactive.RestPath
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON


interface ResourceApi<Resource : Any> {
	@GET
	@Produces(APPLICATION_JSON)
	fun get(@RestPath id: String): Uni<Resource>

	@DELETE
	fun delete(@RestPath id: String): Uni<Void>
}