package com.inventory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_menu")
public class Menu {

  @Id
  private Integer menuId;
  private String menuIcon;
  private String menuName;
  private Integer pId;
  private Integer menuState;
  private String menuUrl;

}
