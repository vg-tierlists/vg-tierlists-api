package dev.stocky37.tierlists.rest.util

import org.jboss.resteasy.reactive.server.ServerResponseFilter
import javax.ws.rs.container.ContainerResponseContext
import javax.ws.rs.core.Response.Status.NOT_FOUND


class Filters {
	@ServerResponseFilter
	fun notFoundFilter(responseContext: ContainerResponseContext) {
		if (responseContext.entity == null) {
			responseContext.statusInfo = NOT_FOUND
		}
	}
}