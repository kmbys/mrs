package com.nsbt.mrs.app.room

import com.nsbt.mrs.domain.model.ReservableRoom
import com.nsbt.mrs.domain.model.ReservableRoomId
import com.nsbt.mrs.domain.model.MeetingRoom
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDate

@Controller
@RequestMapping("rooms")
class RoomsController {

    @GetMapping
    fun listRooms() =
        ModelAndView("room/listRooms",
            mapOf(
                "date" to LocalDate.now(),
                "rooms" to listOf(
                    ReservableRoom(
                        ReservableRoomId(1, LocalDate.now()),
                        MeetingRoom(1, "札幌")
                    ),
                    ReservableRoom(
                        ReservableRoomId(1, LocalDate.now()),
                        MeetingRoom(2, "小樽")
                    )
                )
            )
        )
}