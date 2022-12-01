package dev.stocky37.tierlists.api

import dev.stocky37.tierlists.model.Game
import io.smallrye.mutiny.Uni
import org.jboss.resteasy.reactive.RestPath
import javax.ws.rs.DELETE
import javax.ws.rs.GET

interface GameApi {

	@GET
	fun get(@RestPath("gameId") id: String): Uni<Game?>

	@DELETE
	fun delete(@RestPath("gameId") id: String): Uni<Void>
}