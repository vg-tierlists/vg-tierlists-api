package dev.stocky37.tierlists.api

import dev.stocky37.tierlists.api.base.MongoResourceApi
import dev.stocky37.tierlists.api.json.Game
import javax.enterprise.context.RequestScoped

@RequestScoped
class GameApi : MongoResourceApi<Game>() {}