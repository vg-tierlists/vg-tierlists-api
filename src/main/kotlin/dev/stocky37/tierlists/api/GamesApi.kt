package dev.stocky37.tierlists.api

import dev.stocky37.tierlists.api.base.MongoResourcesApi
import dev.stocky37.tierlists.api.json.Game
import javax.ws.rs.Path

@Path("/games")
class GamesApi : MongoResourcesApi<Game>() {}