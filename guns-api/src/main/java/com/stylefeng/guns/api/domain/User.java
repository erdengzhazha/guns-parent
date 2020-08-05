package com.stylefeng.guns.api.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

  private String userName;
  private String userPwd;
  //private String nickName;
  //private Integer userSex;
  //private String birthday;
  private String email;
  private String userPhone;
  private String address;
  //private String headUrl;
  //private String biography;
  //private Integer lifeState;
  //private Date beginTime;
  //private Date updateTime;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
