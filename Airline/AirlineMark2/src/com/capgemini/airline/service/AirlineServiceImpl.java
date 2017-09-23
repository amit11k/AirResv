package com.capgemini.airline.service;

import java.util.List;

import com.capgemini.airline.beans.EnquiryBean;
import com.capgemini.airline.beans.FlightBean;
import com.capgemini.airline.beans.FlightTab;
import com.capgemini.airline.beans.NewUser;
import com.capgemini.airline.beans.Passenger;
import com.capgemini.airline.beans.PaymentBean;
import com.capgemini.airline.dao.AdminAirlineDaoImpl;
import com.capgemini.airline.dao.AirlineDaoImpl;
import com.capgemini.airline.dao.IAdminAirlineDao;
import com.capgemini.airline.dao.IAirlineDao;
import com.capgemini.airline.exception.AirlineException;

public class AirlineServiceImpl implements IAirlineService {
	
	static IAirlineDao airDao = new AirlineDaoImpl();
	static IAdminAirlineDao airAdminDao = new AdminAirlineDaoImpl();
	@Override
	public List<FlightTab> getFlightDetails(EnquiryBean enqry)
			throws AirlineException {
		return airDao.getFlightDetails(enqry);
	}

	@Override
	public int addNewUser(NewUser user, int priority) 
			throws AirlineException {
		return airDao.addNewUser(user, priority);
	}
	
	@Override
	public double calculateFare(FlightTab flightSelect,int count){
		return count*flightSelect.getPrice();
	}

	@Override
	public int bookingAdd(NewUser user, EnquiryBean enqry, FlightTab flightTab,
			List<Passenger> passList, PaymentBean payCard, double netPayment)
			throws AirlineException {
		
		return airDao.bookingAdd(user, enqry, flightTab, passList, payCard, netPayment);
	}
	
	public boolean verifyUser(String userName,String passWord,String role) throws AirlineException{
		String passRet = airDao.retrieveUser(userName, role);
		if(passWord.equals(passRet))
			return true;
		return false;
	}

	@Override
	public int addFlight(FlightBean flight) throws AirlineException {
		return airAdminDao.addFlight(flight);
	}

	@Override
	public List<FlightBean> retrieveAllFlights() throws AirlineException {
		return airAdminDao.retrieveAllFlights();
	}
}
