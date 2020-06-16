package com.inventory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_user")
public class User {

  @Id
  private Integer userId;
  private String userName;
  private String password;
  private String trueName;
  private String roles;
  private String remarks;

}
