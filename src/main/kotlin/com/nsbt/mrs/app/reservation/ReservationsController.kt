package com.nsbt.mrs.app.reservation

import com.nsbt.mrs.domain.model.*
import com.nsbt.mrs.domain.service.reservation.ReservationService
import com.nsbt.mrs.domain.service.room.RoomService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.View
import java.time.LocalDate
import java.time.LocalTime

@Controller
@RequestMapping("reservations/{date}/{roomId}")
class ReservationsController(
    private val roomService: RoomService,
    private val reservationService: ReservationService
) {

    @GetMapping
    fun reserveForm(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable date: LocalDate,
        @PathVariable roomId: Int
    ) =
        ModelAndView(
            "reservation/reserveForm",
            mapOf(
                "date" to date,
                "roomId" to roomId,
                "room" to roomService.findMeetingRoom(roomId),
                "reservations" to reservationService.findReservations(ReservableRoomId(roomId, date)),
                "timeList" to timeList(),
                "user" to dummyUser()
            )
        )

    @PostMapping
    fun reserve(
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable date: LocalDate,
        @PathVariable roomId: Int
    ) =
        ModelAndView("redirect:/reservations/{date}/{roomId}")

    private fun timeList() =
        (0 until 24 * 2).map { LocalTime.of(it / 2, it % 2 * 30) }

    private fun dummyUser() =
        User(
            "taro-yamada",
            null,
            "太郎",
            "山田",
            RoleName.USER
        )
}
