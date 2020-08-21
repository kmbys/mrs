package com.nsbt.mrs.app.room

import com.nsbt.mrs.domain.model.ReservableRoom
import com.nsbt.mrs.domain.model.ReservableRoomId
import com.nsbt.mrs.domain.model.MeetingRoom
import com.nsbt.mrs.domain.service.room.RoomService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDate

@Controller
@RequestMapping("rooms")
class RoomsController(private val roomService: RoomService) {

    @GetMapping
    fun listRooms() =
        ModelAndView(
            "room/listRooms",
            mapOf(
                "date" to LocalDate.now(),
                "rooms" to roomService.findReservableRooms(LocalDate.now())
            )
        )
}
