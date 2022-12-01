package dev.stocky37.tierlists.rest

import dev.stocky37.tierlists.api.GameApi
import dev.stocky37.tierlists.api.GamesApi
import dev.stocky37.tierlists.core.GameService
import dev.stocky37.tierlists.model.Game
import io.smallrye.mutiny.Uni
import javax.enterprise.context.RequestScoped
import javax.inject.Inject

@RequestScoped
class GamesResource : GamesApi {

	@Inject
	private lateinit var gameResource: GameApi

	@Inject
	private lateinit var svc: GameService

	override fun list(): Uni<List<Game>> = svc.list()

	override fun create(resource: Game): Uni<Game> = svc.create(resource)

	override fun get(): GameApi = gameResource
}