package com.altimetrik.cart.model.response;

import java.io.Serializable;

public class ProductItem implements Serializable {

  private String name;
  private Double price;
  private Double vat;
  private Double tax;
  private Integer qty;
  private Double importDuty;
  private Double totalPrice;
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getVat() {
    return vat;
  }

  public void setVat(Double vat) {
    this.vat = vat;
  }

  public Double getTax() {
    return tax;
  }

  public void setTax(Double tax) {
    this.tax = tax;
  }

  public Double getImportDuty() {
    return importDuty;
  }

  public void setImportDuty(Double importDuty) {
    this.importDuty = importDuty;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
