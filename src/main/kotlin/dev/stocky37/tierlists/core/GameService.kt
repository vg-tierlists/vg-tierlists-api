package dev.stocky37.tierlists.core

import com.github.slugify.Slugify
import dev.stocky37.tierlists.api.json.Game
import dev.stocky37.tierlists.core.base.MongoEntityResourceService
import dev.stocky37.tierlists.db.GameEntity
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class GameService : MongoEntityResourceService<Game, GameEntity>(), PanacheMongoRepository<GameEntity> {

	@Inject
	private lateinit var slugifier: Slugify

	override fun get(id: String): Game? {
		return if (ObjectId.isValid(id)) {
			super.get(id)
		} else getBySlug(id)
	}

	fun getBySlug(slug: String): Game? {
		val entity = find("slug = ?1", slug).firstResult()
		return if (entity == null) null else fromEntity(entity)
	}

	override fun repo(): PanacheMongoRepository<GameEntity> {
		return this
	}

	override fun toEntity(resource: Game): GameEntity {
		return GameEntity(
			id = if (resource.id == null) null else ObjectId(resource.id),
			name = resource.name,
			slug = resource.slug ?: slugifier.slugify(resource.name),
			image = resource.image
		)
	}

	override fun fromEntity(entity: GameEntity): Game {
		return Game(
			id = entity.id?.toString(),
			name = entity.name,
			slug = entity.slug,
			image = entity.image
		)
	}

}