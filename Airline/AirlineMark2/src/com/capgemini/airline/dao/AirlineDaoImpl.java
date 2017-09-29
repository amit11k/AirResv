package com.capgemini.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.airline.beans.EnquiryBean;
import com.capgemini.airline.beans.FlightTab;
import com.capgemini.airline.beans.NewUser;
import com.capgemini.airline.beans.Passenger;
import com.capgemini.airline.beans.PaymentBean;
import com.capgemini.airline.beans.Schedule;
import com.capgemini.airline.exception.AirlineException;
import com.capgemini.airline.util.DBUtil;


public class AirlineDaoImpl implements IAirlineDao {

	@Override
	public List<FlightTab> getFlightDetails(EnquiryBean enqry) throws AirlineException {
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet dayresultSet = null;
		Statement statement = null;
		Statement daystatement = null;
		FlightTab flightTab = new FlightTab();
		List<FlightTab> allFlights = new ArrayList<FlightTab>();
		int flightCount=0;
		int[] arrDays = new int[7];
		try{
			connection = DBUtil.getDatabaseConnection();
			statement = connection.createStatement();
			
			java.sql.Date sqlDate = java.sql.Date.valueOf(enqry.getDateOfJourney());
			if(enqry.getClassName().equals("F"))
			resultSet = statement.executeQuery(IQueryMapper.FLIGHT_RETRIEVEF_QRY+"'"+enqry.getFrom()+"'");
			else
			resultSet = statement.executeQuery(IQueryMapper.FLIGHT_RETRIEVEB_QRY+"'"+enqry.getFrom()+"'");
			while(resultSet.next()){
				flightTab.setCompany(resultSet.getString(1));
				flightTab.setDepartTime(hrTimeToLocalTime(resultSet.getInt(2)));
				flightTab.setArrivalTime(hrTimeToLocalTime(resultSet.getInt(3)));
				flightTab.setDuration(resultSet.getInt(4));
				flightTab.setStops(resultSet.getInt(5));
				flightTab.setPrice(resultSet.getInt(6));
				flightTab.setFlightId(resultSet.getString(7));
				
				dayresultSet = daystatement.executeQuery(IQueryMapper.DAY_RETRIEVE_QRY+flightTab.getFlightId());
				int dayDOJ = enqry.getDateOfJourney().getDayOfMonth();
				if(dayresultSet.getInt(dayDOJ)==1)
				allFlights.add(flightTab);
				flightCount++;
			}
		}catch(SQLException e){
			throw new AirlineException(e.getMessage());
		}
		if(flightCount!=0)
			return allFlights;
		else
			return null;
	}
	
	@Override
	public int addNewUser(NewUser user,int Priority) throws AirlineException {
		Connection connection=null;
			PreparedStatement preparedStatement = null;
			int queryResult=0;
			try{
			connection = DBUtil.getDatabaseConnection();
			
			preparedStatement = connection.prepareStatement(IQueryMapper.USER_INSERT_QRY);
			
			preparedStatement.setString(1,user.getUserName());
			preparedStatement.setString(2,user.getPassword());
			if(Priority==1)
			preparedStatement.setString(3,"User");
			else if(Priority==2)
			preparedStatement.setString(3,"Admin");
			else
			preparedStatement.setString(3,"AExec");	
			
			preparedStatement.setString(4,user.getContact());
			preparedStatement.setString(5, user.getEmailId());
			queryResult = preparedStatement.executeUpdate();
			if(queryResult==0){
				throw new AirlineException("Technical Problem. Check log file.");
			}
			}
			catch(SQLException e){
				throw new AirlineException(e.getMessage()+"Technical Problem. Check log file.");
			}
			finally{
				try{
					preparedStatement.close();
					connection.close();
				}
				catch(SQLException e){
					throw new AirlineException("Error in closing database connection");
				}
			}
		return queryResult;
	}

	public LocalTime hrTimeToLocalTime(int x){
		if(x>=1300)
			x-=1200;
		LocalTime lTime = LocalTime.of(x/100, x%100);
		return lTime;
	}

	@Override
	public int bookingAdd(NewUser user,EnquiryBean enqry,FlightTab flightTab, List<Passenger> passList,
			PaymentBean payCard, double netPayment) throws AirlineException {
		
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int queryResult=0;
		int bookingID = 0;
		try{
		connection = DBUtil.getDatabaseConnection();
		
		preparedStatement = connection.prepareStatement(IQueryMapper.BOOKING_INSERT_QRY);
		preparedStatement.setString(1,user.getEmailId());
		preparedStatement.setInt(2, passList.size());
		preparedStatement.setDouble(3, netPayment);
		preparedStatement.setInt(4, 25);
		preparedStatement.setString(5, payCard.getCardNumber());
		preparedStatement.setString(6, enqry.getFrom());
		preparedStatement.setString(7, enqry.getTo());
		
		preparedStatement.executeUpdate();
		
		statement = connection.createStatement();
		resultSet= statement.executeQuery(IQueryMapper.BOOKING_ID_QRY);
		if(resultSet.next())
			bookingID = resultSet.getInt(1);
		else
			bookingID = 0;
		
		preparedStatement = connection.prepareStatement(IQueryMapper.PAYMENT_INSERT_QRY);
		preparedStatement.setString(1, payCard.getCardNumber());
		preparedStatement.setInt(2, payCard.getCvv());
		preparedStatement.setInt(3, payCard.getExpMonth());
		preparedStatement.setInt(4, payCard.getExpYear());
		preparedStatement.setString(5, payCard.getName());
		preparedStatement.setString(6, payCard.getMobNo());
		preparedStatement.executeUpdate();
		
		for(int i=0;i<passList.size();i++){
		preparedStatement = connection.prepareStatement(IQueryMapper.PASS_INSERT_QRY);
		preparedStatement.setString(1, flightTab.getFlightId());
		preparedStatement.setDate(2, java.sql.Date.valueOf(enqry.getDateOfJourney()));
		preparedStatement.setString(3, passList.get(i).getFirstName());
		preparedStatement.setInt(4, passList.get(i).getAge());
		preparedStatement.setString(5,passList.get(i).getLastName());
		preparedStatement.setString(6, passList.get(i).getGender());
		preparedStatement.executeUpdate();
		}
	}catch(SQLException e){
		throw new AirlineException(e.getMessage());
	}
		return 0;
	}

	@Override
	public String retrieveUser(String userName,String role) throws AirlineException {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		NewUser user = new NewUser();
		try{
			connection = DBUtil.getDatabaseConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(IQueryMapper.USER_RETRIEVE_QRY+"'"+userName+"'"+"AND role='"+role+"'");
			if(resultSet.next()){
				return resultSet.getString(1);
			}
			else{
				return null;
			}
		}catch(SQLException e){
			throw new AirlineException(e.getMessage());
		}
	}

	@Override
	public Schedule scheduleCheck(String flightno) throws AirlineException {
		
		return null;
	}
}
