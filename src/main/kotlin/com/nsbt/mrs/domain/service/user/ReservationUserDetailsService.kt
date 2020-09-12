package com.nsbt.mrs.domain.service.user

import com.nsbt.mrs.domain.repository.user.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class ReservationUserDetailsService(private val userRepository: UserRepository): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findById(username!!)
        return if (user.isPresent)
            ReservationUserDetails(user.get())
        else
            throw UsernameNotFoundException("$username is not found.")
    }
}
