package com.nsbt.mrs.app.room

import com.nsbt.mrs.domain.service.room.RoomService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDate

@Controller
@RequestMapping("rooms")
class RoomsController(private val roomService: RoomService) {

    @GetMapping
    fun listRooms() = listRooms(LocalDate.now())

    @GetMapping("{date}")
    fun listRooms(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable date: LocalDate) =
        ModelAndView(
            "room/listRooms",
            mapOf(
                "date" to date,
                "rooms" to roomService.findReservableRooms(date)
            )
        )
}
