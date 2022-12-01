package dev.stocky37.tierlists.rest.util

import com.mongodb.ErrorCategory
import com.mongodb.MongoWriteException
import io.smallrye.mutiny.Uni
import org.jboss.resteasy.reactive.RestResponse
import org.jboss.resteasy.reactive.server.ServerExceptionMapper

class ExceptionMappers {

	@ServerExceptionMapper
	fun mapMongoExceptions(e: MongoWriteException): Uni<RestResponse<Any>> {
		return Uni.createFrom().item(
			if (e.error.category == ErrorCategory.DUPLICATE_KEY) {
				RestResponse.status(RestResponse.Status.CONFLICT, e.error)
			} else {
				RestResponse.serverError()
			}
		)
	}
}