package com.capgemini.airline.dao;

import java.util.List;

import com.capgemini.airline.beans.FlightBean;
import com.capgemini.airline.beans.Passenger;
import com.capgemini.airline.exception.AirlineException;

public interface IAdminAirlineDao {
	int addFlight(FlightBean flight) throws AirlineException;
	List<FlightBean> retrieveAllFlights() throws AirlineException;
	List<Passenger> retrievePassengers(String flightId) throws AirlineException;
}
