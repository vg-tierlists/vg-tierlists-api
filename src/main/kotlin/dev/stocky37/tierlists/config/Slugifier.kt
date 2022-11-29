package dev.stocky37.tierlists.config

import com.github.slugify.Slugify
import javax.enterprise.inject.Produces


class Slugifier {
	@Produces
	fun slugifier(): Slugify = Slugify.builder().build()
}