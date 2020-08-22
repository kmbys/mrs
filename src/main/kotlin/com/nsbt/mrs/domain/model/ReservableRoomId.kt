package com.nsbt.mrs.domain.model

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.Embeddable

@Embeddable
data class ReservableRoomId(

    val roomId: Int,

    val reservedDate: LocalDate

): Serializable
