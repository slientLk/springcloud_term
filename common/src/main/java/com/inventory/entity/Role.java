package com.inventory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_role")
public class Role {

  @Id
  private Integer roleId;
  private String roleName;
  private String remarks;

}
