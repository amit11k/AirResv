package com.cg.airline.service;

import java.util.List;

import com.capgemini.airline.beans.EnquiryBean;
import com.capgemini.airline.beans.FlightBean;
import com.capgemini.airline.beans.FlightTab;
import com.capgemini.airline.beans.NewUser;
import com.capgemini.airline.beans.Passenger;
import com.capgemini.airline.beans.PaymentBean;
import com.capgemini.airline.beans.Schedule;
import com.capgemini.airline.exception.AirlineException;

public interface IAirlineService {
	
	List<FlightTab> getFlightDetails(EnquiryBean enqry) throws AirlineException;
	int addNewUser(NewUser user,int priority) throws AirlineException;
	public double calculateFare(FlightTab flightSelect,int count);
	int bookingAdd(NewUser user,EnquiryBean enqry,FlightTab flightTab,
			List<Passenger> passList,PaymentBean payCard,double netPayment) 
					throws AirlineException;
	public boolean verifyUser(String userName,String passWord,String role) throws AirlineException;
	int addFlight(FlightBean flight) throws AirlineException;
	List<FlightBean> retrieveAllFlights() throws AirlineException;
	List<Passenger> retrievePassengers(String flightId) throws AirlineException;
	
	Schedule scheduleCheck(String flightno) throws AirlineException;
}
