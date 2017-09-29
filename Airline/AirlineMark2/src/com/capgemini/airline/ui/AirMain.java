package com.capgemini.airline.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.airline.beans.EnquiryBean;
import com.capgemini.airline.beans.FlightBean;
import com.capgemini.airline.beans.FlightTab;
import com.capgemini.airline.beans.NewUser;
import com.capgemini.airline.beans.Passenger;
import com.capgemini.airline.beans.PaymentBean;
import com.capgemini.airline.dao.IAdminAirlineDao;
import com.capgemini.airline.exception.AirlineException;
import com.capgemini.airline.service.AirlineServiceImpl;
import com.capgemini.airline.service.IAirlineService;

public class AirMain {
	static Scanner scanner = new Scanner(System.in);
	static IAirlineService airService = new AirlineServiceImpl();
	public static void main(String[] args) {
		int choice1;
		users();
		System.out.print("Please select your choice: ");
		choice1 = scanner.nextInt();
		switch(choice1){
		case 1:
			queryMenu();
			System.out.print("Please select your choice: ");
			int choice2=0;
			choice2= scanner.nextInt();
			switch(choice2){
			//New Enquiry
			case 1:
				EnquiryBean enqry = new EnquiryBean();
				enqry = getQuery();
				int selectedFlight=0;
				Character bool;
				try{
					List<FlightTab> flightList = airService.getFlightDetails(enqry);
					System.out.println("Flight ID\tDeparture\tArrival\tDuration\tStops\tPrice");
					int flightId = 1;
					for(FlightTab it:flightList){
						System.out.println(flightId+"\t"+it.getCompany()+"\t"+
								it.getDepartTime()+"\t"+it.getArrivalTime()+"\t"+
								it.getDuration()+"\t"+it.getStops()+"\t"+it.getPrice());
					}
					System.out.print("Do you want to continue? (Y/N): ");
					bool = scanner.next().charAt(0);
					if(bool.equals('Y')){
						System.out.print("Please enter the flight no: ");
						selectedFlight = scanner.nextInt();
						System.out.println("Thank you for selecting.");
						System.out.println("Are you an existing user? (Y/N)");
						Character userBool;
						userBool = scanner.next().charAt(0);
						NewUser user = new NewUser();
						if(userBool.equals('N')){
							user = userNew();
							airService.addNewUser(user, 1);
						}
						else{
							//User Verify and Validation
						}
						System.out.println("-------Booking-------");
						boolean boolAddRem;
						int intAddRem = 0;
						char charAddRem;
						List<Passenger> passengerList = new ArrayList<>();
						Passenger newPass = null;
						do{
							while(true){
								System.out.println("1.Add New Passanger");
								System.out.println("2.Remove Passenger");
								System.out.println("3.Continue");
								intAddRem = scanner.nextInt();
								if(intAddRem == 1){
									newPass = NewPassenger();
									passengerList.add(newPass);
								}
								else if(intAddRem == 2){
									//Validation
									passengerList.remove(passengerList.size()-1);
								}
								else{
									break;
								}
							}
							System.out.print("Do you want to continue?(Y/N):");
							charAddRem = scanner.next().charAt(0);
							if(charAddRem=='Y')
								boolAddRem = false;
							else
								boolAddRem = true;
						}while(boolAddRem);
						
						double netPayment = airService.calculateFare(flightList.get(flightId-1), passengerList.size());
						PrintBooking(passengerList, flightList.get(flightId-1), enqry, netPayment);
						//Print Booking details
						boolean payConfirm = false;
						char charPayConfirm;
						System.out.print("Do you want to continue?(Y/N):");
						charPayConfirm = scanner.next().charAt(0);
						if(charPayConfirm=='Y'){
							int payOption = paymentOptions();
							PaymentBean payCard = null;
							switch(payOption){
							case 1:
								payCard = payDebit();
								System.out.println("Payment Amount: "+netPayment);
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							}
							int bookingID=0;
							// Insertion in booking 
							bookingID = airService.bookingAdd(user,enqry,flightList.get(flightId-1),passengerList,payCard,netPayment);
							System.out.println("Congratulations!! Your flight has been booked.");
							// Print Ticket
						}
						else{
							System.exit(0);
							//Roll back to flight list
						}
					}
					else{
						// Not continue after enquiry
						System.exit(0);
					}
				}catch(AirlineException e){
					e.printStackTrace();
				}
			break;
			case 2:
				String flightno;
				System.out.println("Enter the flight number mentioned in your e-ticket");
				flightno = scanner.next();
				
				//Check flight status
			break;
			case 3:
				//View Schedule
			break;
			case 4:
				//Check booking status
			break;
			}
		break;
		case 2:
			//Admin
			String userName;
			String passWord;
			boolean flagAsk=true;
			do{
			System.out.print("Username: ");
			userName = scanner.next();
			System.out.print("Password: ");
			passWord = scanner.next();
			
			try {
				if(airService.verifyUser(userName, passWord, "Admin")){
					System.out.println("Welcome "+userName);
					adminMenu();
					int choice3=0;
					System.out.print("Please select your choice: ");
					choice3 = scanner.nextInt();
					switch(choice3){
					case 1:
						//Add Flight
						FlightBean flight = newFlight();
						int flightInCheck = airService.addFlight(flight);
						if(flightInCheck!=0)
							System.out.println("Flight Successfully added.");
						break;
					case 2:
						//View All Flights
						List<FlightBean> flightList = new ArrayList<FlightBean>();
						flightList = airService.retrieveAllFlights();
						for(FlightBean it:flightList){
							System.out.println(it);
						}
						break;
					case 3:
						//
						break;
					case 4:
						//View Bookings
						System.out.print("Enter the Flight ID: ");
						String flightId = scanner.next();
						List<Passenger> passList = new ArrayList<Passenger>();
						passList = airService.retrievePassengers(flightId);
						//Print Passengers
						printPassenger(passList,flightId);
						break;
					}
					flagAsk=false;
				}
				else{
					System.err.println("Sorry! Incorrect Username OR Password");
					System.out.print("Do you want to try again?(Y/N):");
					if(scanner.next().charAt(0)=='N')
						flagAsk=false;
				}
			} catch (AirlineException e) {
				e.printStackTrace();
			}
			}while(flagAsk);
		break;
		case 3:
			//Airline Executive
			String userNameExec;
			String passWordExec;
			boolean flagAskExec=true;
			do{
			System.out.print("Username: ");
			userNameExec = scanner.next();
			System.out.print("Password: ");
			passWordExec = scanner.next();
			
			try{
				if(airService.verifyUser(userNameExec, passWordExec, "AExec")){
					System.out.println("Welcome "+userNameExec);
					System.out.print("Enter the Flight No. ");
					String flightNo = scanner.next();
					List<Passenger> passList = new ArrayList<>();
					passList = airService.retrievePassengers(flightNo);
					
					System.out.print("Flight Occupancy: "+passList.size()+" out of 100 Seats");
				}
			}catch(AirlineException e){
				System.out.println(e.getMessage());
			}
			}while(flagAskExec);
		break;
		case 4:
			System.exit(0);
		break;
		}
	}
	
	
	public static EnquiryBean getQuery(){
		
		EnquiryBean enqry = new EnquiryBean();
		System.out.print("Domestic/International: ");
		enqry.setForeign(scanner.next());
		System.out.print("From: ");
		enqry.setFrom(scanner.next());
		System.out.print("To: ");
		enqry.setTo(scanner.next());           
		System.out.print("Date of Journey(DD/MM/YYYY): ");
		enqry.setDateOfJourney(convertDate(scanner.next()));
		System.out.print("Economic/Business: ");
		enqry.setClassName(scanner.next());
		return enqry;
	}
	public static void users(){
		System.out.println("*******************");
		System.out.println("Airline blah!! blah!!");
		System.out.println("1. Enquiry");
		System.out.println("2. Admin");
		System.out.println("3. Airline executive");
		System.out.println("4. Exit");
		System.out.println("********************");
	}
	public static void queryMenu(){
		System.out.println("********************");
		System.out.println("1. New Enquiry");
		System.out.println("2. Check Flight Status");
		System.out.println("3. View Schedule");
		System.out.println("4. Check Booking Status");
		System.out.println("*********************");
	}
	public static NewUser userNew(){
		System.out.println("*****New User Registration*****");
		NewUser user = new NewUser();
		System.out.print("Username: ");
		user.setUserName(scanner.next());
		System.out.print("Email ID: ");
		user.setEmailId(scanner.next());
		System.out.print("Password: ");
		user.setPassword(scanner.next());
		System.out.print("Mobile No: ");
		user.setContact(scanner.next());
		
		return user;
	}
	public static Passenger NewPassenger(){
		Passenger newPass = new Passenger();
		System.out.print("First Name: ");
		newPass.setFirstName(scanner.next());
		System.out.print("Last Name: ");
		newPass.setLastName(scanner.next());
		System.out.print("Age: ");
		newPass.setAge(scanner.nextInt());
		System.out.print("Gender: ");
		newPass.setGender(scanner.next());
		
		return newPass;
	}
	
	public static void PrintBooking(List<Passenger> passList,
			FlightTab flight,EnquiryBean enqry,double amount){
		System.out.println("************************************");
		System.out.println("Flight: "+flight.getCompany());
		System.out.println("From: "+enqry.getFrom()+"\t"+"To: "+enqry.getTo());
		System.out.println("Date of Journey: "+enqry.getDateOfJourney());
		System.out.println("Class: "+enqry.getClassName());
		System.out.println("------------------------------------");
		System.out.println("Passenger List:");
		for(int i=0;i<passList.size();i++){
			System.out.println(i+1+"\t"+passList.get(i).getFirstName()+"  "+passList.get(i).getLastName()+"  "
					+passList.get(i).getAge()+" "+passList.get(i).getGender());
		}
		System.out.println("Total Fare: "+amount);
	}
	
	public static int paymentOptions(){
		System.out.println("How would you like to Pay?");
		System.out.println("1.Debit Card");
		System.out.println("2.Credit Card");
		System.out.println("3.Wallet");
		System.out.println("4.Exit");
		int option=0;
		option = scanner.nextInt();
		return option;
	}
	public static PaymentBean payDebit(){
		PaymentBean payBean = new PaymentBean();
		System.out.print("Card Number: ");
		payBean.setCardNumber(scanner.next());
		System.out.print("Name: ");
		payBean.setName(scanner.next());
		System.out.print("CVV: ");
		payBean.setCvv(scanner.nextInt());
		System.out.print("Expiry Date(MM/YY): ");
		String date = scanner.next();
		payBean.setMobNo(null);
		payBean.setExpMonth(Integer.parseInt(date.substring(0, 1)));
		payBean.setExpYear(Integer.parseInt(date.substring(3, 4)));
		
		return payBean;
	}
	
	public static void adminMenu(){
		System.out.println("***********************");
		System.out.println("1. Add Flight");
		System.out.println("2. View All Flights");
		System.out.println("3. Change flight status");
		System.out.println("4. View Bookings");
		System.out.println("***********************");
	}
	
	public static FlightBean newFlight(){
		System.out.println("****************************");
		FlightBean flight = new FlightBean();
		System.out.print("Flight Code: ");
		flight.setFlightNo(scanner.next());
		System.out.print("Airline Company: ");
		flight.setAirline(scanner.next());
		System.out.print("Source: ");
		flight.setDepCity(scanner.next());
		System.out.print("Destination: ");
		flight.setArrCity(scanner.next());
		System.out.print("Departure Date: ");
		flight.setDepDate(convertDate(scanner.next()));
		System.out.print("Arrival Date: ");
		flight.setArrDate(convertDate(scanner.next()));
		System.out.print("Departure Time(in Hrs): ");
		flight.setDepTime(scanner.nextInt());
		System.out.print("Arrival Time(in Hrs): ");
		flight.setArrTime(scanner.nextInt());
		System.out.print("Duration: ");
		flight.setDuration(scanner.nextInt());
		System.out.print("Number of Stops: ");
		flight.setStop(scanner.nextInt());
		System.out.print("Stop Duration: ");
		flight.setStopDuration(scanner.nextInt());
		System.out.print("First Class Seats: ");
		flight.setFirstSeats(scanner.nextInt());
		System.out.print("First Class Seat Fare: ");
		flight.setFirstSeatFare(scanner.nextDouble());
		System.out.print("Business Class Seats: ");
		flight.setBussSeats(scanner.nextInt());
		System.out.print("Business Class Seat Fare: ");
		flight.setBussSeatsFare(scanner.nextDouble());
		System.out.println("****************************");
		return flight;
	}
	public static void printPassenger(List<Passenger> passList,String flightId){
		
		System.out.println("************************");
		System.out.println("Passenger in Flight :" +flightId);
		Passenger pass = null;
		for(int i=0;i<passList.size();i++){
			pass = passList.get(i);
			System.out.println((i+1)+". "+pass.getFirstName()+"\t"+
			pass.getLastName()+"\t"+pass.getGender()+"\t"+pass.getAge());
		}
	}
	public static LocalDate convertDate(String tempDate){
		LocalDate lcdate = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		lcdate = LocalDate.parse(tempDate,formatter);
		return lcdate;
	}
}