package com.nsbt.mrs.app.reservation

import com.nsbt.mrs.domain.model.RoleName
import com.nsbt.mrs.domain.model.User
import com.nsbt.mrs.domain.service.room.RoomService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.time.LocalTime

@Controller
@RequestMapping("reservations/{date}/{roomId}")
class ReservationsController(private val roomService: RoomService) {

    @GetMapping
    fun reserveForm(@PathVariable roomId: Int) =
        ModelAndView(
            "reservation/reserveForm",
            mapOf(
                "room" to roomService.findMeetingRoom(roomId),
                "timeList" to timeList(),
                "user" to dummyUser()
            )
        )

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
