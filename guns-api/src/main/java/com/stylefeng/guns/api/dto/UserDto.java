package com.stylefeng.guns.api.dto;

import java.util.Date;

public class UserDto {
  private String username;
  private String nickname;
  private String email;
  private String phone;
  private Integer sex;
  private String birthday;
  private String lifeState;
  private String biography;
  private String address;
  private String headAddress;
  private Long createTime;
  private Long updateTime;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getLifeState() {
    return lifeState;
  }

  public void setLifeState(String lifeState) {
    this.lifeState = lifeState;
  }

  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getHeadAddress() {
    return headAddress;
  }

  public void setHeadAddress(String headAddress) {
    this.headAddress = headAddress;
  }

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public Long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }
}
