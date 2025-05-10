package com.example.demo.transport;

public class TransportDTO {
  private int id;
  private String title;
  private String departure;
  private String arrival;
  private String dateTime;
  private double price;

  public TransportDTO() {}

  public TransportDTO(
      int id, String title, String departure, String arrival, String dateTime, double price) {
    this.id = id;
    this.title = title;
    this.departure = departure;
    this.arrival = arrival;
    this.dateTime = dateTime;
    this.price = price;
  }

  // Getters/Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDeparture() {
    return departure;
  }

  public void setDeparture(String departure) {
    this.departure = departure;
  }

  public String getArrival() {
    return arrival;
  }

  public void setArrival(String arrival) {
    this.arrival = arrival;
  }

  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
