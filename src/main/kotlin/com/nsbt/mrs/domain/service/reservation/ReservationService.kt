package com.nsbt.mrs.domain.service.reservation

import com.nsbt.mrs.domain.model.*
import com.nsbt.mrs.domain.repository.reservation.ReservationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ReservationService(private val reservationRepository: ReservationRepository) {
    fun findReservations(reservableRoomId: ReservableRoomId) =
        reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId)

    fun reserve(reservation: Reservation) =
        reservationRepository.save(reservation)

    fun cancel(reservationId: Int, requestUser: User) =
        reservationRepository.delete(reservationRepository.findById(reservationId).get())
}
