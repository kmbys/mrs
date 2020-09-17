package com.nsbt.mrs.app.reservation

import com.nsbt.mrs.domain.model.*
import com.nsbt.mrs.domain.service.reservation.ReservationService
import com.nsbt.mrs.domain.service.room.RoomService
import com.nsbt.mrs.domain.service.user.ReservationUserDetails
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDate
import java.time.LocalTime

@Controller
@RequestMapping("reservations/{date}/{roomId}")
class ReservationsController(
    private val roomService: RoomService,
    private val reservationService: ReservationService
) {

    @ModelAttribute
    fun setUpForm() =
        ReservationForm(
            LocalTime.of(9, 0),
            LocalTime.of(10, 0)
        )

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
                "timeList" to timeList()
            )
        )

    @PostMapping
    fun reserve(
        @Validated form: ReservationForm,
        bindingResult: BindingResult,
        @AuthenticationPrincipal reservationUserDetails: ReservationUserDetails,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable date: LocalDate,
        @PathVariable roomId: Int
    ): ModelAndView {

        if (bindingResult.hasErrors()) {
            return reserveForm(date, roomId)
        }

        val reservation = Reservation(
            null,
            form.startTime,
            form.endTime,
            ReservableRoom(
                ReservableRoomId(
                    roomId,
                    date
                ),
                roomService.findMeetingRoom(roomId)
            ),
            reservationUserDetails.user
        )
        reservationService.reserve(reservation)

        return ModelAndView("redirect:/reservations/{date}/{roomId}")
    }

    @PostMapping(params = ["cancel"])
    fun cancel(
        @AuthenticationPrincipal reservationUserDetails: ReservationUserDetails,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable date: LocalDate,
        @PathVariable roomId: Int,
        @RequestParam reservationId: Int
    ): ModelAndView {
        reservationService.cancel(reservationId, reservationUserDetails.user)
        return ModelAndView("redirect:/reservations/{date}/{roomId}")
    }

    private fun timeList() =
        (0 until 24 * 2).map { LocalTime.of(it / 2, it % 2 * 30) }

}
