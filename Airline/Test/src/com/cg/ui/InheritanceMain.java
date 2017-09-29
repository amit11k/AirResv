package com.cg.ui;

class Base{
	int a;
}
public class InheritanceMain extends Base{

	public static void main(String[] args){
		InheritanceMain ref1 = new InheritanceMain();
		InheritanceMain ref2 = new InheritanceMain();
		
		ref2 = ref1;
		
		if(ref1==ref2)
			System.out.println("A");
		if(ref1.equals(ref2))
			System.out.println("B");
	}
	void go(){
		System.out.println("ABC");
	}
}