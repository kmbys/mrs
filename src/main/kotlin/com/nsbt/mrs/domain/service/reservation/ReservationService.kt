package com.nsbt.mrs.domain.service.reservation

import com.nsbt.mrs.domain.model.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.LocalTime

@Service
@Transactional
class ReservationService {
    fun findReservations(reservableRoomId: ReservableRoomId) =
        listOf(
            Reservation(
                1,
                LocalTime.of(13, 0),
                LocalTime.of(14, 0),
                ReservableRoom(
                    ReservableRoomId(
                        1,
                        LocalDate.now()
                    ),
                    MeetingRoom(
                        1,
                        "札幌"
                    )
                ),
                User(
                    "saburo-yamada",
                    null,
                    "三郎",
                    "山田",
                    RoleName.USER
                )
            ),
            Reservation(
                2,
                LocalTime.of(14, 0),
                LocalTime.of(15, 0),
                ReservableRoom(
                    ReservableRoomId(
                        1,
                        LocalDate.now()
                    ),
                    MeetingRoom(
                        1,
                        "札幌"
                    )
                ),
                User(
                    "taro-yamada",
                    null,
                    "太郎",
                    "山田",
                    RoleName.USER
                )
            )
        )
}
