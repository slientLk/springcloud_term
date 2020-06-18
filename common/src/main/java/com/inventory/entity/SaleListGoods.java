package com.inventory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_sale_list_goods")
public class SaleListGoods {

  @Id
  private Integer saleListGoodsId;
  private Integer goodsId;
  private String goodsCode;
  private String goodsName;
  private String goodsModel;
  private Integer goodsNum;
  private String goodsUnit;
  private double price;
  private double total;
  private Integer saleListId;
  private Integer goodsTypeId;

}
