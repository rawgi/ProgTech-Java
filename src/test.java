import java.util.Iterator;

import blatt1.Countdown;
import blatt1.Squares;
import blatt1.Words;
import blatt2.LiLi;

public class test {
	
	public static void main(String[]args) throws Exception{
		/* Blatt 1 */
//		Countdown countdown = new Countdown((long) 5);
//		Iterator countIterator = countdown.iterator();
//		while(countIterator.hasNext()){
//			System.out.println(countIterator.next());
//		}
//		
//		Squares squares = new Squares();
//		Iterator squareIterator = squares.iterator();
//		for(int x = 1; x <10; x++){
//			System.out.println(squareIterator.next());
//		}
//		
//		Words words = new Words("la le lu und schon zu");
//		Iterator<String> wordsIt = words.iterator();
//		while(wordsIt.hasNext()){
//			System.out.println(wordsIt.next());
//		}
		
		/* Blatt 2 */
		LiLi<String> lili = new LiLi<String>("h",new LiLi<String>("a",new LiLi<String>("l",new LiLi<String>("l",new LiLi<String>("o",new LiLi<String>(null,null))))));
		System.out.println(lili);
		System.out.println(lili.length());
		System.out.println(lili.get(2));
		System.out.println(lili.drop(2));
		System.out.println(lili.take(3));
		System.out.println(lili.sublist(1, 4));
		System.out.println(lili.indexOf("o"));
		System.out.println(lili.add("!"));
		System.out.println(lili.reverse());
	}
}
