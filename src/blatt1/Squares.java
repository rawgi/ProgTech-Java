package blatt1;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Squares implements Iterable<Long>{

	@Override
	public Iterator<Long> iterator() {
		return new SquareIterator();
	}
	
	private class SquareIterator implements Iterator<Long>{
		
		private long number = 1;
		private long out;
		@Override
		public Long next() {
			out = number;
			number ++;
			return out*out;
		}
		
		@Override
		public boolean hasNext() {
			return true;
		}
	}
}
