import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class Testing {
	@Test
	void test() {
		//ADDITION TESTING
		
		Calc test = new Calc();
		int test1 = test.add(10,10);		//ADDING TWO +VE
		assertEquals(20,test1);
		
		int test2 = test.add(5,-10);		//ADDING +VE AND -VE
		assertEquals(-5,test2);
		
		int test3 = test.add(-5,5);			//ADDING +VE AND -VE EQUAL VALES
		assertEquals(0,test3);
		
		int test4 = test.add(0,3);			//ADDING ZERO TO +VE NUM
		assertEquals(3,test4);
	}
	//DIVISION TESTING 
	@Test
	void Test2(){
		float Conv= (float)1e-7;         //Convergence constant
		
		Calc test = new Calc();
		
		float test5 = test.divide(5,5);			// DIVIDING 2 EQUAL NUMBERS (+VE,-VE)
		assertEquals(1,test5);
		float test6 = test.divide(-10,-10);
		assertEquals(1,test6);
		
		float test7 = test.divide(0,5);			//ZERO IS NUMERATOR
		assertEquals(0,test7);
		
		float test8 = test.divide(6,3);			//NORMAL DIVISION
		assertEquals(2,test8);
		
		float test9 = test.divide(5,2);			
		assertTrue(Math.abs(test9-2.5)<=Conv);
															//FRACTION RESULT OF DIVISION
		float test10 = test.divide(-10,20);			
		assertTrue(Math.abs(test10+0.5)<=Conv);
		
		assertThrows(ArithmeticException.class,()->test.divide(10,0));		// DIVISION BY ZERO
		assertThrows(ArithmeticException.class,()->test.divide(0,0));
		

	}
}	


	
	

