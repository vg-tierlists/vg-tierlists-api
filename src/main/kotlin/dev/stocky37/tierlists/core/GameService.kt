package dev.stocky37.tierlists.core

import com.github.slugify.Slugify
import dev.stocky37.tierlists.core.base.MongoResourceService
import dev.stocky37.tierlists.db.GameEntity
import dev.stocky37.tierlists.model.Game
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class GameService @Inject constructor(
	private val slugifier: Slugify
) : MongoResourceService<Game, GameEntity>() {

	override fun findById(id: String): Uni<GameEntity?> {
		return if (ObjectId.isValid(id)) {
			super.findById(id)
		} else {
			findBySlug(id)
		}
	}

	fun findBySlug(slug: String) = find("slug = ?1", slug).firstResult()

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