package dev.stocky37.tierlists.core.base

import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntityBase
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import org.bson.types.ObjectId


abstract class MongoEntityResourceService<Resource : Any, Entity : PanacheMongoEntityBase>
	: ResourceService<Resource> {

	override fun get(id: String): Resource? {
		val entity = repo().findById(ObjectId(id))
		return if (entity == null) null else fromEntity(entity)
	}

	override fun list(): List<Resource> {
		return repo().findAll().list().map { e -> fromEntity(e) }
	}

	override fun create(resource: Resource): Resource {
		val entity = toEntity(resource)
		repo().persist(entity)
		return fromEntity(entity)
	}

	override fun delete(id: String): Resource? {
		val entity = repo().findById(ObjectId(id))
		if (entity == null) {
			return entity
		}
		repo().delete(entity)
		return fromEntity(entity)
	}

	protected abstract fun repo(): PanacheMongoRepository<Entity>

	protected abstract fun toEntity(resource: Resource): Entity
	protected abstract fun fromEntity(entity: Entity): Resource
}