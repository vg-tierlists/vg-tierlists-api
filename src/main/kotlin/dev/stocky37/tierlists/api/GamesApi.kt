package dev.stocky37.tierlists.api

import dev.stocky37.tierlists.core.GamesService
import dev.stocky37.tierlists.data.Game
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class GamesApi {

	@Inject
	lateinit var svc: GamesService;

	@POST
	fun add(game: Game): Game {
		return svc.addGame(game)
	}
}