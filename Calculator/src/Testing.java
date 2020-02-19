import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class Testing {
	@Test
	void test() {
		//ADDITION TESTING
		
		Calc test = new Calc();
		int test1 = test.add(10,10);
		assertEquals(20,test1);
		int test2 = test.add(5,-10);
		assertEquals(-5,test2);
		int test3 = test.add(-5,5);
		assertEquals(0,test3);
		int test4 = test.add(-5,3);
		assertEquals(-2,test4);
	}
	//DIVISION TESTING 
	@Test
	void Test2(){
		Calc test = new Calc();
		float test5 = test.divide(5,5);
		assertEquals(1,test5);
		float test6 = test.divide(5,2);
		assertEquals(2.5,test6);
		float test7 = test.divide(5,4);
		assertEquals(1.25,test7);
		
		assertThrows(ArithmeticException.class,()->test.divide(10,0));
		assertThrows(ArithmeticException.class,()->test.divide(0,0));
	}
}	


	
	

