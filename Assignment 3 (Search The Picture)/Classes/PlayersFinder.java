package eg.edu.alexu.csd.datastructure.iceHockey.cs70;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayersFinder implements  IPlayersFinder {
	
	String[] photo1=new String[50];
	int team1;
	int threshold1;
	int row,col;
	int Counter=0;
	int PlayerIND=0;
	int [][] bin=new int[1000][1000];
	ArrayList<Integer> Rows=new ArrayList<Integer>();
	ArrayList<Integer> Col=new ArrayList<Integer>();
	java.awt.Point[] Player=new java.awt.Point[1000];
	int minx=10000,miny=10000,maxx=0,maxy=0;
	@Override
	
	public java.awt.Point[] findPlayers  (String[] photo, int team, int threshold){
		
try {
		
		row=photo.length;
		col=photo[0].length();
		team1=team;
		threshold1=threshold;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(Character.getNumericValue(photo[i].charAt(j))==team) {
					bin[i][j]=team;										
					Rows.add(i);
					Col.add(j);
				}
			}
		}	
		for (int i=0;i<Rows.size();i++) {
				if(bin[Rows.get(i)][Col.get(i)]==team1) {
					
						setmaxx(Rows.get(i));
						setmaxy(Col.get(i));		
						setminx(Rows.get(i));		
						setminy(Col.get(i));
						Counter++;
						search(Rows.get(i),Col.get(i));
					if(checkarea(Counter)==true) {		
						Player[PlayerIND] = new java.awt.Point();
						Player[PlayerIND].x=maxy+miny+1;
						Player[PlayerIND].y=maxx+minx+1;
						PlayerIND++;
					}
					else {
						resetMaxMin();
					}
				}
			Counter=0;
			resetMaxMin();
		}
		
		
		int max=PlayerIND;
		java.awt.Point temp= new java.awt.Point();
		
		boolean swapflag=true;
		
	for(int i=0;i<max-1;i++) {
		swapflag=false;
		for(int j=0;j<max-i-1;j++) {
			
			if(Player[j].x>Player[j+1].x) { 
				 temp=Player[j+1];
				 Player[j+1]=Player[j];
				 Player[j]=temp;
				 swapflag=true;
			}
			else if (Player[j].x==Player[j+1].x && Player[j].y>Player[j+1].y) {
				 temp=Player[j+1];
				 Player[j+1]=Player[j];
				 Player[j]=temp;
				 swapflag=true;
			}
		}
		if(swapflag==false)
			break;
		
	}
		
		
		return Player;	
}
catch(Exception e) {
	System.out.println("The array is null");
	return null;
}
	}

	

void searchdown(int currx,int curry) {
	if(bin[currx+1][curry]==team1) {
		Counter++;
		bin[currx+1][curry]=0; 					//  searching down
		setmaxx(currx+1);
		search(currx+1,curry);
	}
}
void searchup(int currx,int curry) {
	if(bin[currx-1][curry]==team1) {
		Counter++;
		bin[currx-1][curry]=0;				 //  searching up
		setminx(currx-1);
		search(currx-1,curry);
	}
}
void searchright(int currx,int curry) {
	if(bin[currx][curry+1]==team1) {
		Counter++;
		bin[currx][curry+1]=0; 					//  searching Right
		setmaxy(curry+1);
		search(currx,curry+1);
	}
}
void searchleft(int currx,int curry) {
	if(bin[currx][curry-1]==team1) {
		Counter++;
		bin[currx][curry-1]=0; 					//  searching left
		setminy(curry-1);
		search(currx,curry-1);
	}
}
	
void search(int currx,int curry) {
	bin[currx][curry]=0;
	if(currx>=row || curry>=col)
		return ;
	if(currx==0&&curry==0) {
		//Search Down & Right
		searchdown(currx,curry);	
		searchright(currx,curry);

	}
	else if(currx==(bin.length)-1&&curry==(bin[0].length)-1) {
		//Search up && Left
		
		searchup(currx,curry);
		searchleft(currx,curry);	
	}
	else if(currx==0) {
		//search all except up
		searchdown(currx,curry);
		searchleft(currx,curry);
		searchright(currx,curry);
		
	}
	else if (currx==(bin.length)-1) {
		//search in all direction except down
		searchup(currx,curry);
		searchleft(currx,curry);
		searchright(currx,curry);
		
	}
	else if (curry==0) {
		//search in all except left
		searchup(currx,curry);
		searchdown(currx,curry);
		searchright(currx,curry);	}
	else if(curry==(bin[0].length)-1) {
		//search in all except right
		searchup(currx,curry);
		searchleft(currx,curry);
		searchdown(currx,curry);
	}
	else {
		// search all
		searchup(currx,curry);
		searchleft(currx,curry);
		searchright(currx,curry);
		searchdown(currx,curry);
	}
	
}

void setminx(int X) {
	if(X<minx) {
		minx=X;
	}
	
}
void setminy(int Y) {
	if(Y<miny) {
		miny=Y;
	}
	
}
void setmaxx(int X) {
	if(X>maxx) {
		maxx=X;
	}
}
void setmaxy(int Y) {
	if(Y>maxy) {
		maxy=Y;
	}
}

void resetMaxMin() {
 minx=1000;
 miny=1000;
 maxx=0;
 maxy=0;
}

boolean checkarea(int Coun) {
	 if (Coun*4>=threshold1)
		 return true;
	 else return false;
 }

 
}