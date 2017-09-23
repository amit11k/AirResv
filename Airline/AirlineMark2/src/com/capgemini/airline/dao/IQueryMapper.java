package com.capgemini.airline.dao;

public class IQueryMapper {
	public static String FLIGHT_RETRIEVEF_QRY = "SELECT airline,dep_time,arr_time,duration,stop,FirstSeatFare,flightno FROM flightinformation WHERE dep_city=";
	public static String FLIGHT_RETRIEVEB_QRY = "SELECT airline,dep_time,arr_time,duration,stop,BussSeatsFare,flightno FROM flightinformation WHERE dep_city=";
	public static String USER_INSERT_QRY = "INSERT INTO Users VALUES(?,?,?,?,?)";
	public static String BOOKING_INSERT_QRY = "INSERT INTO BookingInformation VALUES(book_id_seq.NEXTVAL,?,?,?,?,?,?,?)";
	public static String PAYMENT_INSERT_QRY = "INSERT INTO card_details VALUES(book_id_seq.CURRVAL,?,?,?,?,?,?)";
	public static String BOOKING_ID_QRY = "SELECT book_id_seq.CURRVAL FROM DUAL";
	public static String USER_RETRIEVE_QRY = "SELECT password FROM Users WHERE username=";
	public static String PASS_INSERT_QRY = "INSERT INTO pass_list VALUES(?,?,?,?,?,?)";
	
	public static String FLIGHT_INSERT_QRY = "INSERT INTO FlightInformation VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String FLIGHT_ALL_QRY = "SELECT * FROM FlightInformation";
}