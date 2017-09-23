package com.capgemini.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.airline.beans.FlightBean;
import com.capgemini.airline.exception.AirlineException;
import com.capgemini.airline.util.DBUtil;
public class AdminAirlineDaoImpl implements IAdminAirlineDao {

	@Override
	public int addFlight(FlightBean flight) throws AirlineException {
		Connection connection = DBUtil.getDatabaseConnection();
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		int queryResult=0;
		try
		{		
			preparedStatement=connection.prepareStatement(IQueryMapper.FLIGHT_INSERT_QRY);

			preparedStatement.setString(1,flight.getFlightNo());			
			preparedStatement.setString(2,flight.getAirline());
			preparedStatement.setString(3,flight.getDepCity());
			preparedStatement.setString(4,flight.getArrCity());
			preparedStatement.setDate(5,java.sql.Date.valueOf(flight.getDepDate()));
			preparedStatement.setDate(6,java.sql.Date.valueOf(flight.getArrDate()));
			preparedStatement.setInt(7,flight.getDepTime());
			preparedStatement.setInt(8,flight.getArrTime());
			preparedStatement.setDouble(9,flight.getDuration());
			preparedStatement.setInt(10,flight.getStop());
			preparedStatement.setInt(11,flight.getStopDuration());
			preparedStatement.setInt(12,flight.getFirstSeats());
			preparedStatement.setDouble(13, flight.getFirstSeatFare());
			preparedStatement.setInt(14,flight.getBussSeats());
			preparedStatement.setDouble(15, flight.getBussSeatsFare());
			
			
			queryResult=preparedStatement.executeUpdate();
	
			if(queryResult==0)
			{
				//logger.error("Insertion failed ");
				throw new AirlineException("Insertion flight failed");

			}
			/*else
			{
				//logger.info("Donor details added successfully:");
				return donorId;
			}*/

		}
		catch(SQLException sqlException)
		{
			//logger.error(sqlException.getMessage());
			throw new AirlineException(sqlException.getMessage());
		}

		finally
		{
			try 
			{
				//resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				//logger.error(sqlException.getMessage());
				throw new AirlineException("Error in closing db connection");
			}
		}
		
		return queryResult;
	}

	@Override
	public List<FlightBean> retrieveAllFlights() throws AirlineException {
		Connection con=DBUtil.getDatabaseConnection();
		int flightCount = 0;
		
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		
		List<FlightBean> flightList=new ArrayList<FlightBean>();
		try
		{
			preparedStatement=con.prepareStatement(IQueryMapper.FLIGHT_ALL_QRY);
			resultset=preparedStatement.executeQuery();
			
			while(resultset.next())
			{	
				FlightBean flight=new FlightBean();
				flight.setFlightNo(resultset.getString(1));
				flight.setAirline(resultset.getString(2));
				flight.setDepCity(resultset.getString(3));
				flight.setArrCity(resultset.getString(4));
				flight.setDepDate(resultset.getDate(5).toLocalDate());
				flight.setArrDate(resultset.getDate(6).toLocalDate());
				flight.setDepTime(resultset.getInt(7));
				flight.setArrTime(resultset.getInt(8));
				flight.setDuration(resultset.getDouble(9));
				flight.setStop(resultset.getInt(10));
				flight.setStopDuration(resultset.getInt(11));
				flight.setFirstSeats(resultset.getInt(12));
				flight.setFirstSeatFare(resultset.getDouble(13));
				flight.setBussSeats(resultset.getInt(14));
				flight.setBussSeatsFare(resultset.getDouble(15));
				
				flightList.add(flight);
				flightCount++;
			}			
			
		} catch (SQLException sqlException) {
			//logger.error(sqlException.getMessage());
			throw new AirlineException("Tehnical problem occured. Refer log");
		}
		
		finally
		{
			try 
			{
				resultset.close();
				preparedStatement.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				//logger.error(e.getMessage());
				throw new AirlineException("Error in closing db connection");

			}
		}
		
		if( flightCount == 0)
			return null;
		else
			return flightList;

	}
	
}
