package com.cg.airline.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.airline.beans.EnquiryBean;
import com.capgemini.airline.beans.FlightTab;
import com.capgemini.airline.beans.NewUser;
import com.capgemini.airline.exception.AirlineException;
import com.capgemini.airline.service.AirlineServiceImpl;
import com.capgemini.airline.service.IAirlineService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		RequestDispatcher rdSuccess = null;
		RequestDispatcher rdFailure = null;
		Scanner scanner = new Scanner(System.in);
		IAirlineService airService = new AirlineServiceImpl();
		ServletContext servletContext = request.getServletContext();
		if(action!=null){
			if(action.equals("enquiry")){
				EnquiryBean enqry = new EnquiryBean();
				enqry.setFrom(request.getParameter("txtFrom"));
				enqry.setTo(request.getParameter("txtTo"));
				enqry.setClassName(request.getParameter("txtClass"));
				String tempDate = request.getParameter("txtDate");
				
				LocalDate lcdate = null;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				lcdate = LocalDate.parse(tempDate,formatter);
				
				enqry.setDateOfJourney(lcdate);
				enqry.setForeign(request.getParameter(request.getParameter("txtForeign")));
				enqry.setPassengers(Integer.parseInt(request.getParameter("txtPass")));
				
				List<FlightTab> flightList;
				try {
					flightList = airService.getFlightDetails(enqry);

					servletContext.setAttribute("listFlight", flightList);
					servletContext.setAttribute("enqry", enqry);
					
				} catch (AirlineException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				rdSuccess = request.getRequestDispatcher("/pages/ListAll.jsp");
				rdSuccess.forward(request,response);
			}
			else if(action.equals("selectedFlight")){
				
				int selectedFlight = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("flightno", selectedFlight);
				rdSuccess = request.getRequestDispatcher("/pages/NewUser.jsp");
				rdSuccess.forward(request,response);
			}
			else if(action.equals("newUser")){
				int selectedFlight = Integer.parseInt((String) request.getAttribute("id"));
				NewUser user = new NewUser();
				user.setUserName(request.getParameter("txtUnm"));
				user.setEmailId(request.getParameter("txtEmail"));
				user.setPassword(request.getParameter("txtPwd"));
				user.setContact(request.getParameter("txtNum"));
				try {
					airService.addNewUser(user, 1);
				} catch (AirlineException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				HttpSession session = request.getSession();
				session.setAttribute("CustName", user.getUserName());
				EnquiryBean enqry = new EnquiryBean();
			
				
				enqry = (EnquiryBean) servletContext.getAttribute("enqry");
				request.setAttribute("NoOfPass",enqry.getPassengers());
				rdSuccess = request.getRequestDispatcher("/pages/Passenger.jsp");
				rdSuccess.forward(request,response);
			}
			else if(action.equals("")){
				
			}
		}
		
	}

}
