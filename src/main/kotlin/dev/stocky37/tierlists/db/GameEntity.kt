package dev.stocky37.tierlists.db

import io.quarkus.mongodb.panache.common.MongoEntity
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntityBase
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId

@MongoEntity(database = "tierlists", collection = "games", clientName = "app")
data class GameEntity @BsonCreator constructor(
	@BsonId var id: ObjectId?,
	@BsonProperty("name") val name: String,
	@BsonProperty("slug") val slug: String,
	@BsonProperty("image") val image: String,
) : PanacheMongoEntityBase() {}