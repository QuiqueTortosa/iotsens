package com.iot.technicaltest.apirest.api;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PricesDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-11-14T23:49:51.699279900+01:00[Europe/Madrid]")

public class PricesDTO   {
  @JsonProperty("productId")
  private Long productId = null;

  @JsonProperty("brandId")
  private Long brandId = null;

  @JsonProperty("priceList")
  private Integer priceList = null;

  @JsonProperty("startDate")
  private LocalDateTime startDate = null;

  @JsonProperty("endDate")
  private LocalDateTime endDate = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("curr")
  private String curr = null;

  @JsonProperty("priority")
  private Long priority = null;

  public PricesDTO productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public PricesDTO brandId(Long brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * Get brandId
   * @return brandId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  public PricesDTO priceList(Integer priceList) {
    this.priceList = priceList;
    return this;
  }

  /**
   * Get priceList
   * @return priceList
  **/
  @ApiModelProperty(value = "")


  public Integer getPriceList() {
    return priceList;
  }

  public void setPriceList(Integer priceList) {
    this.priceList = priceList;
  }

  public PricesDTO startDate(LocalDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public PricesDTO endDate(LocalDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public PricesDTO price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public PricesDTO curr(String curr) {
    this.curr = curr;
    return this;
  }

  /**
   * Get curr
   * @return curr
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCurr() {
    return curr;
  }

  public void setCurr(String curr) {
    this.curr = curr;
  }

  public PricesDTO priority(Long priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Get priority
   * @return priority
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getPriority() {
    return priority;
  }

  public void setPriority(Long priority) {
    this.priority = priority;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricesDTO pricesDTO = (PricesDTO) o;
    return Objects.equals(this.productId, pricesDTO.productId) &&
        Objects.equals(this.brandId, pricesDTO.brandId) &&
        Objects.equals(this.priceList, pricesDTO.priceList) &&
        Objects.equals(this.startDate, pricesDTO.startDate) &&
        Objects.equals(this.endDate, pricesDTO.endDate) &&
        Objects.equals(this.price, pricesDTO.price) &&
        Objects.equals(this.curr, pricesDTO.curr) &&
        Objects.equals(this.priority, pricesDTO.priority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, priceList, startDate, endDate, price, curr, priority);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricesDTO {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    curr: ").append(toIndentedString(curr)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

