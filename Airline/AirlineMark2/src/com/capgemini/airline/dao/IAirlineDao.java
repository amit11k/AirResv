package com.capgemini.airline.dao;

import java.util.List;

import com.capgemini.airline.beans.EnquiryBean;
import com.capgemini.airline.beans.FlightTab;
import com.capgemini.airline.beans.NewUser;
import com.capgemini.airline.beans.Passenger;
import com.capgemini.airline.beans.PaymentBean;
import com.capgemini.airline.exception.AirlineException;

public interface IAirlineDao {

	List<FlightTab> getFlightDetails(EnquiryBean enqry) throws AirlineException;
	int addNewUser(NewUser user,int priority) throws AirlineException;
	int bookingAdd(NewUser user,EnquiryBean enqry,FlightTab flightTab,
			List<Passenger> passList,PaymentBean payCard,double netPayment) 
					throws AirlineException;
	public String retrieveUser(String userName,String role) throws AirlineException;
}
