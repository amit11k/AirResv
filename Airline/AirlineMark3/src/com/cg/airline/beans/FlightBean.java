package com.cg.airline.beans;

import java.time.LocalDate;

public class FlightBean {
	private String flightNo;  
	private String airline;
	private String depCity; 
	private String arrCity; 
	private LocalDate depDate;
	private LocalDate arrDate; 
	private int depTime; 
	private int arrTime; 
	private double duration;
	private int stop;
	private int stopDuration;
	private int FirstSeats; 
	private double FirstSeatFare;
	private int BussSeats; 
	private double BussSeatsFare;
	
	public FlightBean() {
		
	}

	public FlightBean(String flightNo, String airline, String depCity,
			String arrCity, LocalDate depDate, LocalDate arrDate, int depTime,
			int arrTime, double duration, int stop, int stopDuration,
			int firstSeats, double firstSeatFare, int bussSeats,
			double bussSeatsFare) {
		super();
		this.flightNo = flightNo;
		this.airline = airline;
		this.depCity = depCity;
		this.arrCity = arrCity;
		this.depDate = depDate;
		this.arrDate = arrDate;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.duration = duration;
		this.stop = stop;
		this.stopDuration = stopDuration;
		FirstSeats = firstSeats;
		FirstSeatFare = firstSeatFare;
		BussSeats = bussSeats;
		BussSeatsFare = bussSeatsFare;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public LocalDate getDepDate() {
		return depDate;
	}

	public void setDepDate(LocalDate depDate) {
		this.depDate = depDate;
	}

	public LocalDate getArrDate() {
		return arrDate;
	}

	public void setArrDate(LocalDate arrDate) {
		this.arrDate = arrDate;
	}

	public int getDepTime() {
		return depTime;
	}

	public void setDepTime(int depTime) {
		this.depTime = depTime;
	}

	public int getArrTime() {
		return arrTime;
	}

	public void setArrTime(int arrTime) {
		this.arrTime = arrTime;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getStop() {
		return stop;
	}

	public void setStop(int stop) {
		this.stop = stop;
	}

	public int getStopDuration() {
		return stopDuration;
	}

	public void setStopDuration(int stopDuration) {
		this.stopDuration = stopDuration;
	}

	public int getFirstSeats() {
		return FirstSeats;
	}

	public void setFirstSeats(int firstSeats) {
		FirstSeats = firstSeats;
	}

	public double getFirstSeatFare() {
		return FirstSeatFare;
	}

	public void setFirstSeatFare(double firstSeatFare) {
		FirstSeatFare = firstSeatFare;
	}

	public int getBussSeats() {
		return BussSeats;
	}

	public void setBussSeats(int bussSeats) {
		BussSeats = bussSeats;
	}

	public double getBussSeatsFare() {
		return BussSeatsFare;
	}

	public void setBussSeatsFare(double bussSeatsFare) {
		BussSeatsFare = bussSeatsFare;
	}

	@Override
	public String toString() {
		return "FlightBean [flightNo=" + flightNo + ", airline=" + airline
				+ ", depCity=" + depCity + ", arrCity=" + arrCity
				+ ", depDate=" + depDate + ", arrDate=" + arrDate
				+ ", depTime=" + depTime + ", arrTime=" + arrTime
				+ ", duration=" + duration + ", stop=" + stop
				+ ", stopDuration=" + stopDuration + ", FirstSeats="
				+ FirstSeats + ", FirstSeatFare=" + FirstSeatFare
				+ ", BussSeats=" + BussSeats + ", BussSeatsFare="
				+ BussSeatsFare + "]";
	}
	
}
