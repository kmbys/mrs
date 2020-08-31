package com.nsbt.mrs.domain.model

import java.io.Serializable
import java.time.LocalTime
import javax.persistence.*

@Entity
data class Reservation(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val reservationId: Int?,

    val startTime: LocalTime,

    val endTime: LocalTime,

    @ManyToOne
    @JoinColumns(
        JoinColumn(name = "reserved_date"),
        JoinColumn(name = "room_id")
    )
    val reservableRoom: ReservableRoom,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User

): Serializable
