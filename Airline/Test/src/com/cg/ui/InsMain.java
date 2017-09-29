package com.cg.ui;

class Ax{
	
	void doStuff(){
		System.out.println("BU");
	}
}
public class InsMain extends Ax{

	public static void main(String[] args) {
		Ax ref = new Ax();
		if(ref instanceof InsMain)
		((InsMain)ref).doStuff();
		
		Integer x =10;
		
		if(x instanceof Object)
				System.out.println("Yo");
	
		
	}
	void doStuff(){
		System.out.println("HU");
	}
}