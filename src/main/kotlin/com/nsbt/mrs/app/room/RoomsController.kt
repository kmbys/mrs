package com.nsbt.mrs.app.room

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
                "room" to "会議室"
            )
        )
}