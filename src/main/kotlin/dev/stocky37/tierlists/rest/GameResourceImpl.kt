package dev.stocky37.tierlists.rest

import dev.stocky37.tierlists.model.Game
import dev.stocky37.tierlists.rest.base.MongoRestHelper
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GameResourceImpl : MongoRestHelper<Game>() {
}