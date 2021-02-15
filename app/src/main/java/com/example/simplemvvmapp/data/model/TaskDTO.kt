package com.example.simplemvvmapp.data.model

import com.google.gson.annotations.SerializedName

data class TaskDTO(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("completed")
	val completed: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
