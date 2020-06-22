package com.inventory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

  @Id
  private Integer userId;
  private String userName;
  private String password;
  private String trueName;
  private String roles;
  private String remarks;

}
