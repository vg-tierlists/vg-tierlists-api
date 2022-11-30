package dev.stocky37.tierlists.rest.api

import dev.stocky37.tierlists.api.GameApi
import dev.stocky37.tierlists.api.GamesApi
import dev.stocky37.tierlists.model.Game
import dev.stocky37.tierlists.rest.GameResourceImpl
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class GamesResource : GamesApi {

	@Inject
	private lateinit var gameResource: GameApi

	@Inject
	private lateinit var impl: GameResourceImpl


	override fun list(): Uni<List<Game>> = impl.list()

	override fun create(resource: Game): Uni<Game> = impl.create(resource)

	override fun get(): GameApi = gameResource
}