package dev.stocky37.tierlists.core

import com.github.slugify.Slugify
import dev.stocky37.tierlists.api.json.Game
import dev.stocky37.tierlists.core.base.MongoEntityResourceService
import dev.stocky37.tierlists.db.GameEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class GameService : MongoEntityResourceService<Game, GameEntity>(), ReactivePanacheMongoRepository<GameEntity> {

	@Inject
	internal lateinit var slugifier: Slugify

	override fun findById(idOrSlug: String): Uni<GameEntity?> {
		return if (ObjectId.isValid(idOrSlug)) {
			findById(ObjectId(idOrSlug))
		} else {
			findBySlug(idOrSlug)
		}
	}

	fun findBySlug(slug: String) = find("slug = ?1", slug).firstResult()

	override fun repo() = this

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