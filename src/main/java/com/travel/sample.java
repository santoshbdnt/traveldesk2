package com.travel;

public class sample {

	public static void main(String[] args) {
		String a= "14:14pm";
		String b = a.substring(0,2);
		System.out.println(b);
		
		int time = Integer.parseInt(b);
		System.out.println(time+14);

	}

}
