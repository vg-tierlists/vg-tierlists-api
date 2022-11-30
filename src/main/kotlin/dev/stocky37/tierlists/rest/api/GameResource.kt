package dev.stocky37.tierlists.rest.api

import dev.stocky37.tierlists.api.GameApi
import dev.stocky37.tierlists.model.Game
import dev.stocky37.tierlists.rest.GameResourceImpl
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject


@ApplicationScoped
class GameResource : GameApi {

	@Inject
	private lateinit var impl: GameResourceImpl

	override fun get(id: String): Uni<Game> = impl.get(id)

	override fun delete(id: String): Uni<Void> = impl.delete(id)
}