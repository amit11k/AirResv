package com.capgemini.airline.beans;

public class Schedule {

	private String flightno;
	private int oldDepTime;
	private int newDepTime;
	private int oldArrTime;
	private int newArrTime;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Schedule(String flightno, int oldDepTime, int newDepTime,
			int oldArrTime, int newArrTime) {
		super();
		this.flightno = flightno;
		this.oldDepTime = oldDepTime;
		this.newDepTime = newDepTime;
		this.oldArrTime = oldArrTime;
		this.newArrTime = newArrTime;
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public int getOldDepTime() {
		return oldDepTime;
	}

	public void setOldDepTime(int oldDepTime) {
		this.oldDepTime = oldDepTime;
	}

	public int getNewDepTime() {
		return newDepTime;
	}

	public void setNewDepTime(int newDepTime) {
		this.newDepTime = newDepTime;
	}

	public int getOldArrTime() {
		return oldArrTime;
	}

	public void setOldArrTime(int oldArrTime) {
		this.oldArrTime = oldArrTime;
	}

	public int getNewArrTime() {
		return newArrTime;
	}

	public void setNewArrTime(int newArrTime) {
		this.newArrTime = newArrTime;
	}

	@Override
	public String toString() {
		return "Schedule [flightno=" + flightno + ", oldDepTime=" + oldDepTime
				+ ", newDepTime=" + newDepTime + ", oldArrTime=" + oldArrTime
				+ ", newArrTime=" + newArrTime + "]";
	}
	
	
}
