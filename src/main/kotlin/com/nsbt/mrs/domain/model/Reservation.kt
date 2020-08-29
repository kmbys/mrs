package com.nsbt.mrs.domain.model

import java.time.LocalTime

data class Reservation(
    val reservationId: Int,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val reservableRoom: ReservableRoom,
    val user: User
)
