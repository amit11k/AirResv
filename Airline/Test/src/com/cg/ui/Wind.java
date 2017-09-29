package com.cg.ui;

public class Wind {
int id;
Wind(int i) { id = i; }
public static void main(String[] args) {
new Wind(3).go();
// commented line
}
void go() {
Wind w1 = new Wind(1);
Wind w2 = new Wind(2);
System.out.println(w1.id + " " + w2.id);
}
}