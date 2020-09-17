package com.nsbt.mrs.domain.service.reservation

import com.nsbt.mrs.domain.model.*
import com.nsbt.mrs.domain.repository.reservation.ReservationRepository
import com.nsbt.mrs.domain.repository.room.ReservableRoomRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ReservationService(
    private val reservationRepository: ReservationRepository,
    private val reservableRoomRepository: ReservableRoomRepository
) {
    fun findReservations(reservableRoomId: ReservableRoomId) =
        reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId)

    fun reserve(reservation: Reservation) =
        if (reservableRoomRepository.findById(reservation.reservableRoom.reservableRoomId).isEmpty) {
            throw UnavailableReservationException("入力の日付・部屋の組み合わせは予約できません。")
        } else {
            reservationRepository.save(reservation)
        }

    fun cancel(reservationId: Int, requestUser: User) =
        reservationRepository.delete(reservationRepository.findById(reservationId).get())
}
