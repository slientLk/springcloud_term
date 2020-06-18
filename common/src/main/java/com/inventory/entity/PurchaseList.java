package com.inventory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_purchase_list")
public class PurchaseList {

  @Id
  private Integer purchaseListId;
  private String purchaseNumber;
  private double amountPaid;
  private double amountPayable;
  private String purchaseDate;
  private String remarks;
  private Integer state;
  private Integer supplierId;
  private Integer userId;

  private String supplierName;
  private String trueName;

}
