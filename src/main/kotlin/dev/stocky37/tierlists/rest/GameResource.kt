package dev.stocky37.tierlists.rest

import dev.stocky37.tierlists.api.GameApi
import dev.stocky37.tierlists.core.GameService
import dev.stocky37.tierlists.model.Game
import io.smallrye.mutiny.Uni
import javax.enterprise.context.RequestScoped
import javax.inject.Inject


@RequestScoped
class GameResource : GameApi {

	@Inject
	private lateinit var svc: GameService

//	@Inject
//	private lateinit var chars: CharacterResource

	override fun get(id: String): Uni<Game?> = svc.get(id)

	override fun delete(id: String): Uni<Void> = svc.delete(id)

//	@Path("characters")
//	fun characters(): CharacterResource = chars
}