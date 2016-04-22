package com.learnakka;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestApp {
	
	@Test
	public void testThis(){
		assertEquals(2,new HelloWorld().add(1, 1));
	}

}
