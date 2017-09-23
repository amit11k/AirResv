package com.capgemini.airline.beans;

import java.time.LocalTime;

public class FlightTab {
	private String flightId;
	private LocalTime departTime;
	private LocalTime arrivalTime;
	private int duration;
	private int Stops;
	private int price;
	private String company;
	
	public FlightTab() {

	}

	public FlightTab(String flightId,LocalTime departTime, LocalTime arrivalTime,
			int duration, int stops, int price, String company) {
		super();
		this.flightId = flightId;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		Stops = stops;
		this.price = price;
		this.company = company;
	}

	public LocalTime getDepartTime() {
		return departTime;
	}

	public void setDepartTime(LocalTime departTime) {
		this.departTime = departTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getStops() {
		return Stops;
	}

	public void setStops(int stops) {
		Stops = stops;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "FlightTab [departTime=" + departTime + ", arrivalTime="
				+ arrivalTime + ", duration=" + duration + ", Stops=" + Stops
				+ ", price=" + price + ", company=" + company + "]";
	}
	
}
