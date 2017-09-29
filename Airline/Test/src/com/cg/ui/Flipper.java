package com.cg.ui;

public class Flipper {
		public static void main(String[] args) {
		 // insert code here
			try { new Flipper().go(); }
			catch (Error e) { System.out.println("ouch"); }
		 }
		 void go() {
		 go();
		 }
		 }
