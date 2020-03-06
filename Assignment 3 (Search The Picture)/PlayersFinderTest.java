/**
 * 
 */
package eg.edu.alexu.csd.datastructure.iceHockey.cs70;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

/**
 * @author Dell5570
 *
 */
class PlayersFinderTest {

	@Test
	void test() {
		
		PlayersFinder Test=new PlayersFinder();
		String[] arr=new String[]{
				"33JUBU33",
				"3U3O4433",
				"O33P44NB",
				"PO3NSDP3",
				"VNDSD333",
				"OINFD33X"
				};
		
		java.awt.Point[] Tes1=Test.findPlayers(arr,3,16);
		
		assertEquals(4,Tes1[0].x);			
		assertEquals(5,Tes1[0].y);			//1st point

		assertEquals(13,Tes1[1].x);			
		assertEquals(9,Tes1[1].y);			//2st point

		assertEquals(14,Tes1[2].x);			
		assertEquals(2,Tes1[2].y);			//2st point
		
}

@Test
	void test1() {
		
		PlayersFinder Test=new PlayersFinder();
		String[] arr=new String[]{
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"
				};
		
		Point[] Tes1=Test.findPlayers(arr,4,16);
		Point[] tes2= new Point[1000];
		tes2[0]=new Point (3,8);
		tes2[1]=new Point (4,16);
		tes2[2]=new Point (5,4);
		tes2[3]=new Point (16,3);
		tes2[4]=new Point (16,17);
		tes2[5]=new Point (17,9);
		assertArrayEquals(tes2,Tes1);
		
		
}
@Test
void test2() {
		
		PlayersFinder Test=new PlayersFinder();
		String[] arr=new String[]{
				"8D88888J8L8E888",
				"88NKMG8N8E8JI88",
				"888NS8EU88HN8EO",
				"LUQ888A8TH8OIH8",
				"888QJ88R8SG88TY",
				"88ZQV88B88OUZ8O",
				"FQ88WF8Q8GG88B8",
				"8S888HGSB8FT8S8",
				"8MX88D88888T8K8",
				"8S8A88MGVDG8XK8",
				"M88S8B8I8M88J8N",
				"8W88X88ZT8KA8I8",
				"88SQGB8I8J88W88",
				"U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8"
				};
		java.awt.Point[] Tes1=Test.findPlayers(arr,8,9);
		Point[] tes2= new Point[1000];
		tes2[0]=new Point (1,17);
		tes2[1]=new Point (3,3);
		tes2[2]=new Point (3,10);
		tes2[3]=new Point (3,25);
		tes2[4]=new Point (5,21);
		tes2[5]=new Point (8,17);
		tes2[6]=new Point (9,2);
		tes2[7]=new Point (10,9);
		tes2[8]=new Point (12,23);
		tes2[9]=new Point (17,16);
		tes2[10]=new Point (18,3);
		tes2[11]=new Point (18,11);
		tes2[12]=new Point (18,28);
		tes2[13]=new Point (22,20);
		tes2[14]=new Point (23,26);
		tes2[15]=new Point (24,15);
		tes2[16]=new Point (27,2);
		tes2[17]=new Point (28,26);
		tes2[18]=new Point (29,16);
		
		assertArrayEquals(tes2,Tes1);

		
}
@Test
void test3() {
	
	PlayersFinder Test=new PlayersFinder();
	String[] arr=new String[]{
			"11111",
			"1AAA1",
			"1A1A1",
			"1AAA1",
			"11111"
			};
	
	java.awt.Point[] Tes1=Test.findPlayers(arr,1,3);

	assertEquals(5,Tes1[0].x);			
	assertEquals(5,Tes1[0].y);			//point #1

	assertEquals(5,Tes1[1].x);			
	assertEquals(5,Tes1[1].y);			//point #2
	

	
}

@Test
void test4() {
	
	PlayersFinder Test=new PlayersFinder();
	String[] arr=new String[]{
			"6666L",
			"FV6UL",
			"S6RM6",
			"666LU"
			};
	
	Point[] Tes1=Test.findPlayers(arr,6,8);
	assertEquals(3,Tes1[0].x);		
	assertEquals(6,Tes1[0].y);			//point #1

	assertEquals(4,Tes1[1].x);			
	assertEquals(2,Tes1[1].y);			//point #2
	
	
}

@Test

void test5() {
	
	PlayersFinder Test=new PlayersFinder();
	String[] arr=new String[]{null};
	java.awt.Point[] Tes1=Test.findPlayers(arr,1,3);
	
	assertArrayEquals(Tes1,null);
	 


	
}

}
