package com.cg.ui;

public class A extends IA{
int a=20;
	public A() {
		// TODO Auto-generated constructor stub
		System.out.println("In cons A");
		System.out.println(super.a);
	}
	public A(int a){
		System.out.println(a);
	}
}
