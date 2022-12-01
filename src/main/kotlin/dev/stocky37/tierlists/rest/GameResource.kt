package dev.stocky37.tierlists.rest

import dev.stocky37.tierlists.api.GameApi
import dev.stocky37.tierlists.core.GameService
import dev.stocky37.tierlists.model.Game
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject


@ApplicationScoped
class GameResource @Inject constructor(
	private val svc: GameService
) : GameApi {

	override fun get(id: String): Uni<Game?> = svc.get(id)

	override fun delete(id: String): Uni<Void> = svc.delete(id)
}