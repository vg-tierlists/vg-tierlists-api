package dev.stocky37.tierlists.rest.util

import org.jboss.resteasy.reactive.server.ServerResponseFilter
import javax.ws.rs.container.ContainerResponseContext
import javax.ws.rs.core.Response.Status.NOT_FOUND


class Filters {
	@NullToNotFound
	@ServerResponseFilter
	fun notFoundFilter(response: ContainerResponseContext) {
		if (response.entity == null) {
			response.statusInfo = NOT_FOUND
		}
	}
}
