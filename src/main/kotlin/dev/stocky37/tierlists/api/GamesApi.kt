package dev.stocky37.tierlists.api

import dev.stocky37.tierlists.api.base.MongoResourcesApi
import dev.stocky37.tierlists.api.base.ResourceApi
import dev.stocky37.tierlists.api.json.Game
import io.smallrye.mutiny.Uni
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("/games")
class GamesApi : MongoResourcesApi<Game>() {

	@Inject
	private lateinit var gameResource: GameApi

	@GET
	@Produces(APPLICATION_JSON)
	override fun list(): Uni<List<Game>> {
		return super.list()
	}

	@POST
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	override fun create(resource: Game): Uni<Game> {
		return super.create(resource)
	}

	@Path("{gameId}")
	fun get(): ResourceApi<Game> {
		return gameResource
	}
}