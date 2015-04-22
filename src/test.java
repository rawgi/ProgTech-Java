import java.util.Iterator;

import blatt1.Countdown;
import blatt1.Squares;

public class test {
	
	public static void main(String[]args){
		Countdown countdown = new Countdown((long) 5);
		Iterator countIterator = countdown.iterator();
		while(countIterator.hasNext()){
			System.out.println(countIterator.next());
		}
		
		Squares squares = new Squares();
		Iterator squareIterator = squares.iterator();
		for(int x = 1; x <10; x++){
			System.out.println(squareIterator.next());
		}
		
	}
}
