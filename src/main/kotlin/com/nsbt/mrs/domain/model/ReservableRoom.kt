package com.nsbt.mrs.domain.model

import java.io.Serializable
import javax.persistence.*

@Entity
data class ReservableRoom(

    @EmbeddedId
    val reservableRoomId: ReservableRoomId,

    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    @MapsId("roomId")
    val meetingRoom: MeetingRoom

): Serializable
