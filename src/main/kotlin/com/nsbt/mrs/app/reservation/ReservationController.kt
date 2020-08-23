package com.nsbt.mrs.app.reservation

import com.nsbt.mrs.domain.service.room.RoomService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("reservations/{date}/{roomId}")
class ReservationController(private val roomService: RoomService) {

    @GetMapping
    fun reserveForm() =
        ModelAndView(
            "reservation/reserveForm"
        )
}
