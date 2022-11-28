package dev.stocky37.tierlists.core.base


interface ResourceService<Resource : Any> {
	fun get(id: String): Resource?
	fun list(): List<Resource>
	fun create(resource: Resource): Resource
}