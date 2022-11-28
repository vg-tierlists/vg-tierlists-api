package dev.stocky37.tierlists.core

import com.github.slugify.Slugify
import dev.stocky37.tierlists.data.Game
import dev.stocky37.tierlists.db.GameEntity
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class GamesService : PanacheMongoRepository<GameEntity> {

	@Inject
	lateinit var slugifier: Slugify;

	fun addGame(g: Game): Game {
		val entity = toEntity(g)
		persist(entity)
		return fromEntity(entity)
	}

	fun toEntity(g: Game): GameEntity {
		return GameEntity(
			id = if (g.id == null) null else ObjectId(g.id),
			name = g.name,
			slug = g.slug ?: slugifier.slugify(g.name),
			image = g.image
		)
	}

	fun fromEntity(g: GameEntity): Game {
		return Game(
			id = g.id?.toString(),
			name = g.name,
			slug = g.slug,
			image = g.image
		)
	}
}