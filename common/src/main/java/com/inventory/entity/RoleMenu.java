package com.inventory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_role_menu")
public class RoleMenu {

  @Id
  private Integer roleMenuId;
  private Integer menuId;
  private Integer roleId;

}
