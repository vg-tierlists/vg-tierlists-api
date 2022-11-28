package dev.stocky37.tierlists.data

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(alphabetic = true)
data class Game(
	val name: String,
	val image: String,

	// ignore fields on input
	@field:JsonProperty(access = JsonProperty.Access.READ_ONLY) val id: String?,
	@field:JsonProperty(access = JsonProperty.Access.READ_ONLY) val slug: String?,
) {}