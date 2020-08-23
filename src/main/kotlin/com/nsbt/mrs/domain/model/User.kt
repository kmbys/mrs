package com.nsbt.mrs.domain.model

import java.io.Serializable

data class User(
    val userId: String,
    val password: String?,
    val firstName: String,
    val lastName: String,
    val roleName: RoleName
):Serializable
