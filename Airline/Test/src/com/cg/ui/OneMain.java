package com.cg.ui;

class Two{
	public Two() {
		System.out.println("Hi");
	}
	public Two(int i){
		System.out.println(i);
	}
}

public class OneMain extends Two{
	public OneMain() {
		this(2);
		
	}
	public OneMain(int j){
		System.out.println(j);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Two ref = new OneMain();
		
	}

}
