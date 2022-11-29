package dev.stocky37.tierlists.api

import dev.stocky37.tierlists.api.base.MongoResourceApi
import dev.stocky37.tierlists.api.json.Game
import io.smallrye.mutiny.Uni
import org.jboss.resteasy.reactive.RestPath
import javax.enterprise.context.RequestScoped
import javax.ws.rs.DELETE
import javax.ws.rs.GET

@RequestScoped
class GameApi : MongoResourceApi<Game>() {

	@GET
	override fun get(@RestPath("gameId") id: String): Uni<Game> {
		return super.get(id)
	}

	@DELETE
	override fun delete(@RestPath("gameId") id: String): Uni<Void> {
		return super.delete(id)
	}
}