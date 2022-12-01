package dev.stocky37.tierlists.api

import dev.stocky37.tierlists.model.Game
import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import org.jboss.resteasy.reactive.RestPath
import javax.ws.rs.DELETE
import javax.ws.rs.GET

@Tag(name = "Games")
interface GameApi {

	@GET
	fun get(@RestPath("gameId") id: String): Uni<Game?>

	@DELETE
	@APIResponse(
		description = "Delete a game",
	)
	fun delete(@RestPath("gameId") id: String): Uni<Void>
}