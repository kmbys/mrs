package com.nsbt.mrs.domain.repository.room

import com.nsbt.mrs.domain.model.MeetingRoom
import org.springframework.data.jpa.repository.JpaRepository

interface MeetingRoomRepository: JpaRepository<MeetingRoom, Int>
