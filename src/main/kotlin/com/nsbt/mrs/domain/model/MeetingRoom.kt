package com.nsbt.mrs.domain.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class MeetingRoom(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val roomId: Int,

    val roomName: String

): Serializable
