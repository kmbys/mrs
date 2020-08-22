package com.nsbt.mrs.domain.repository.room

import com.nsbt.mrs.domain.model.ReservableRoom
import com.nsbt.mrs.domain.model.ReservableRoomId
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface ReservableRoomRepository: JpaRepository<ReservableRoom, ReservableRoomId> {
    fun findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(reservedDate: LocalDate): List<ReservableRoom>
}
