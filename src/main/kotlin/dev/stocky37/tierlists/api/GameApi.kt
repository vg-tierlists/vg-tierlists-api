package dev.stocky37.tierlists.api

import dev.stocky37.tierlists.api.base.MongoResourceApi
import dev.stocky37.tierlists.api.json.Game
import javax.ws.rs.*

@Path("/games")
class GameApi : MongoResourceApi<Game>() {
}