package com.nsbt.mrs.domain.model

import java.time.LocalDate

data class ReservableRoomId(
    val roomId: Int,
    val reservedDate: LocalDate
)
