package com.nsbt.mrs.domain.service.room

import com.nsbt.mrs.domain.model.MeetingRoom
import com.nsbt.mrs.domain.model.ReservableRoom
import com.nsbt.mrs.domain.model.ReservableRoomId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
@Transactional
class RoomService {
    fun findReservableRooms(date: LocalDate) =
        listOf(
            ReservableRoom(
                ReservableRoomId(1, date),
                MeetingRoom(1, "札幌")
            ),
            ReservableRoom(
                ReservableRoomId(1, date),
                MeetingRoom(2, "小樽")
            )
        )
}
