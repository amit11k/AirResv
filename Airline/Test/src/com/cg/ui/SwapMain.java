package com.cg.ui;

class Box{
	int i;
	
	public Box() {
		
	}
	public Box(int x){
		i = x;
	}
}

class BoxWrapper{
	Box b;
	public BoxWrapper(Box b) {
		this.b = b;
	}
}
public class SwapMain {

	public static void main(String[] args) {
		Box ref1 = new Box(2);
		Box ref2 = new Box(3);

		BoxWrapper ref3 = new BoxWrapper(ref1);
		BoxWrapper ref4 = new BoxWrapper(ref2);
		
		System.out.println(ref1.i);
		System.out.println(ref2.i);
		
		swap(ref3,ref4);
		
		System.out.println(ref3.b.i);
		System.out.println(ref4.b.i);
	}

	public static void swap(BoxWrapper b1,BoxWrapper b2){
		Box temp = b2.b;
		b2.b = b1.b;
		b1.b = temp;
	}
}