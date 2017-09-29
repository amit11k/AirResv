package com.cg.ui;

public class Ouch {
static int ouch = 7;
public static void main(String[] args) {
new Ouch().go(ouch);
//System.out.print(" " + ouch);
}
void go(int ouch) {
ouch++;
for(ouch = 3; ouch < 6; ouch++)
;
System.out.println(ouch);
//System.out.print(" " + ouch);
}
}