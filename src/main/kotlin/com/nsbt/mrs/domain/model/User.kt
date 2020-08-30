package com.nsbt.mrs.domain.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "USR")
data class User(

    @Id
    val userId: String,

    val password: String?,

    val firstName: String,

    val lastName: String,

    @Enumerated(EnumType.STRING)
    val roleName: RoleName

):Serializable
