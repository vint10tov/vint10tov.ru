package ru.v10tov.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN, ROLE_MASTER, ROLE_CLIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
