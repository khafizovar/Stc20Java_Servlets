package org.lesson.pojo;

public class Mobile {
  private Integer id;
  private String model;
  private Integer price;
  private String manufacturer;

  public Mobile() {
  }

  public Mobile(Integer id, String model, Integer price, String manufacturer) {
    this.id = id;
    this.model = model;
    this.price = price;
    this.manufacturer = manufacturer;
  }

  public String getModel() {
    return model;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  @Override
  public String toString() {
    return "Mobile{" +
        "id=" + id +
        ", model='" + model + '\'' +
        ", price=" + price +
        ", manufacturer=" + manufacturer +
        '}';
  }
}
