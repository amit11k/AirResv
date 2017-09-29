package com.cg.ui;

class SampleXY {
	private StringBuilder sb;

	public SampleXY() {
		sb = new StringBuilder("Amit");
	}
	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}
	void print(){
		System.out.println(sb);
	}
}
public class Sample{
	public static void main(String args[]){
		SampleXY ref = new SampleXY();
		
		StringBuilder s1 = ref.getSb();
		s1.append("Kalyan");
		ref.print();
	}
}
