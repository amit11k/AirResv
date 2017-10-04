package com.cg.airline.beans;

import java.time.LocalDate;

public class EnquiryBean {
	private String from;
	private String to;
	private LocalDate dateOfJourney;
	private int passengers;
	private String className;
	private String foreign;
	public EnquiryBean() {
		
	}
	public EnquiryBean(String from, String to, LocalDate dateOfJourney,
			int passengers, String className, String foreign) {
		super();
		this.from = from;
		this.to = to;
		this.dateOfJourney = dateOfJourney;
		this.passengers = passengers;
		this.className = className;
		this.foreign = foreign;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getForeign() {
		return foreign;
	}
	public void setForeign(String foreign) {
		this.foreign = foreign;
	}
	@Override
	public String toString() {
		return "EnquiryBean [from=" + from + ", to=" + to + ", dateOfJourney="
				+ dateOfJourney + ", passengers=" + passengers + ", className="
				+ className + ", foreign=" + foreign + "]";
	}
}
