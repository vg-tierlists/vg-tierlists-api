package dev.stocky37.tierlists.core.base

import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntityBase
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.Uni
import org.bson.types.ObjectId


abstract class MongoEntityResourceService<Resource : Any, Entity : PanacheMongoEntityBase>
	: ResourceService<Resource> {

	override fun get(id: String): Uni<Resource?> {
		return findById(id).map(::fromEntityNullable)
	}

	override fun list(): Uni<List<Resource>> {
		return repo().findAll().list().map { list -> list.map(::fromEntity) }
	}

	override fun create(resource: Resource): Uni<Resource> {
		return repo().persist(toEntity(resource)).map(::fromEntity)
	}

	override fun delete(id: String): Uni<Void> {
		return findById(id).onItem().ifNotNull().transformToUni { e -> repo().delete(e!!) }
	}

	open fun findById(id: String): Uni<Entity?> {
		return repo().findById(ObjectId(id))
	}

	protected fun fromEntityNullable(entity: Entity?): Resource? {
		return if (entity == null) {
			null
		} else {
			fromEntity(entity)
		}
	}

	protected abstract fun repo(): ReactivePanacheMongoRepository<Entity>

	protected abstract fun toEntity(resource: Resource): Entity

	protected abstract fun fromEntity(entity: Entity): Resource


}