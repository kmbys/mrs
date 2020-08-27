package com.nsbt.mrs.app.reservation

import com.nsbt.mrs.domain.model.RoleName
import com.nsbt.mrs.domain.model.User
import com.nsbt.mrs.domain.service.room.RoomService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.time.LocalTime

@Controller
@RequestMapping("reservations/{date}/{roomId}")
class ReservationController(private val roomService: RoomService) {

    @GetMapping
    fun reserveForm() =
        ModelAndView(
            "reservation/reserveForm",
            mapOf(
                "timeList" to timeList(),
                "user" to dummyUser()
            )
        )

    private fun timeList(): List<LocalTime> {
        var timeList = ArrayList<LocalTime>()
        for (i in 0..24 - 1) {
            timeList.add(LocalTime.of(i, 0))
            timeList.add(LocalTime.of(i, 30))
        }
        return timeList
    }

    private fun dummyUser() =
        User(
            "taro-yamada",
            null,
            "太郎",
            "山田",
            RoleName.USER
        )
}
