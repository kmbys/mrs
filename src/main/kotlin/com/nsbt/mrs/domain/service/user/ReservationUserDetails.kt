package com.nsbt.mrs.domain.service.user

import com.nsbt.mrs.domain.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

data class ReservationUserDetails(
    val user: User
): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        AuthorityUtils.createAuthorityList("ROLE_" + user.roleName.name)

    override fun getPassword() =
        user.password

    override fun getUsername() =
        user.userId

    override fun isAccountNonExpired() =
        true

    override fun isAccountNonLocked() =
        true

    override fun isCredentialsNonExpired() =
        true

    override fun isEnabled() =
        true

}
