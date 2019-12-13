package com.funtl.myshop.plus.business.dto;

import com.funtl.myshop.plus.provider.domain.UmsAdmin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-12-12 22:53
 * @Version 1.0
 **/
public class UmsAdminDetails implements UserDetails {
    private UmsAdmin umsAdmin;

    public UmsAdminDetails(UmsAdmin umsAdmin) {
        this.umsAdmin = umsAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus() == 1;
    }

    public UmsAdmin getUmsAdmin() {
        return umsAdmin;
    }
}
