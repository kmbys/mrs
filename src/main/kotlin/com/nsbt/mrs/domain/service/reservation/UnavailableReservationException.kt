package com.nsbt.mrs.domain.service.reservation

import kotlin.RuntimeException

class UnavailableReservationException(override val message: String?): RuntimeException(message)
