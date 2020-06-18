package com.inventory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_sale_list")
public class SaleList {

  @Id
  private Integer saleListId;
  private String saleNumber;
  private double amountPaid;
  private double amountPayable;
  private String saleDate;
  private Integer state;
  private String remarks;
  private Integer customerId;
  private Integer userId;

//  private String customerName;
//  private String trueName;
//数据库中没有上面两个注释掉的字段
}
