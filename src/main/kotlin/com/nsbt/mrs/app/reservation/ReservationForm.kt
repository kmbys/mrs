package com.nsbt.mrs.app.reservation

import org.jetbrains.annotations.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.time.LocalTime

data class ReservationForm(

    @NotNull("必須です")
    @DateTimeFormat(pattern = "HH:mm")
    var startTime: LocalTime,

    @NotNull("必須です")
    @DateTimeFormat(pattern = "HH:mm")
    var endTime: LocalTime

): Serializable
