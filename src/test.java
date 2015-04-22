import java.util.Iterator;

import blatt1.Countdown;
import blatt1.Squares;
import blatt1.Words;

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
		
		Words words = new Words("la le lu und schon zu");
		Iterator<String> wordsIt = words.iterator();
		while(wordsIt.hasNext()){
			System.out.println(wordsIt.next());
		}
	}
}
