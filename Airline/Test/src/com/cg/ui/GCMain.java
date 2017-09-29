package com.cg.ui;

public class GCMain {

	public static void main(String[] args) throws InterruptedException {
		 String str = new String("GeeksForGeeks");
         
	        // making str eligible for gc
	        str = null; 
	             
	        // calling garbage collector
	        System.gc(); 
	             
	        // waiting for gc to complete
	        Thread.sleep(1000); 
	     
	        System.out.println("end of main");

	}
	
	/*@Override
    protected void finalize() 
    {
        System.out.println("finalize method called");
    }*/
}
