package com.miscPrograms;

import org.testng.annotations.Test;

public class DemoTest {
	
	int a = 10;
	int b = 20;
	int c = 0 ;

	@Test
	public void sum() {

		System.out.println("Sum of num :" + (a + b));
		System.out.println(a);
		System.out.println(b);
		System.out.println("Hello Sum");
	}

	@Test
	public void subtarct()
	{
		c = b - a ;
		System.out.println("Subtract of 2 num : "+c);
	}
	
	@Test
	public void multiply()
	{
		c = a*b ;
		System.out.println("Multiply of 2 num : "+c);
	}
}
