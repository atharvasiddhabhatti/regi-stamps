package com.altimetrik.ee.demo.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ROLE_ADMIN, ROLE_USER,ROLE_BUYER,ROLE_SELLER;

  public String getAuthority() {
    return name();
  }

}
