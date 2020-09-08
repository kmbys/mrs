package com.nsbt.mrs.domain.repository.user

import com.nsbt.mrs.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String>
