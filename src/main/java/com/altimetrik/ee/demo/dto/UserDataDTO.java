package com.altimetrik.ee.demo.dto;

import com.altimetrik.ee.demo.entity.Role;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserDataDTO {
  
  @ApiModelProperty(position = 0)
  private String username;
  @ApiModelProperty(position = 1)
  private String email;
  @ApiModelProperty(position = 2)
  private String password;
  @ApiModelProperty(position = 3)
  List<Role> roles;
  @ApiModelProperty(position = 4)
  private String city;
  @ApiModelProperty(position = 5)
  private String address;
  @ApiModelProperty(position = 6)
  private long regNo;
  @ApiModelProperty(position = 7)
  private long PropertyNo;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public String getCity() {return city;}

  public void setCity(String city) {this.city = city;}

  public String getAddress() {return address;}

  public void setAddress(String address) {this.address = address;}

  public long getRegNo() {return regNo;}

  public void setRegNo(long regNo) { this.regNo = regNo; }

  public long getPropertyNo() { return PropertyNo; }

  public void setPropertyNo(long propertyNo) {PropertyNo = propertyNo; }
}
