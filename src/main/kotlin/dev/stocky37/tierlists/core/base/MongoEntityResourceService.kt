package dev.stocky37.tierlists.core.base

import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import org.bson.types.ObjectId


abstract class MongoEntityResourceService<Resource : Any, Entity : Any> : ResourceService<Resource>,
	PanacheMongoRepository<Entity> {

	override fun get(id: String): Resource? {
		val entity = findById(ObjectId(id))
		return if (entity == null) null else fromEntity(entity)
	}

	override fun list(): List<Resource> {
		return findAll().list().map { e -> fromEntity(e) }
	}

	override fun create(resource: Resource): Resource {
		val entity = toEntity(resource)
		persist(entity)
		return fromEntity(entity)
	}

	protected abstract fun toEntity(resource: Resource): Entity;
	protected abstract fun fromEntity(entity: Entity): Resource;

}