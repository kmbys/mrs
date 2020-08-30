package com.nsbt.mrs.domain.repository.reservation

import com.nsbt.mrs.domain.model.ReservableRoomId
import com.nsbt.mrs.domain.model.Reservation
import org.springframework.data.jpa.repository.JpaRepository

interface ReservationRepository: JpaRepository<Reservation, Int> {
    fun findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId: ReservableRoomId): List<Reservation>
}
