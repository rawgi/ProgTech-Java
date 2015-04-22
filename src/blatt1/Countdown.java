package blatt1;

import java.util.Iterator;

public class Countdown implements Iterable<Long>{
	
	Long x;
	
	public Countdown(Long x){
		this.x = x;
	}
	
	@Override
	public Iterator<Long> iterator() {
		return new CountdownIterator();
	}
	
	private class CountdownIterator implements Iterator<Long> {

		private Long number;
		
		CountdownIterator(){
			this.number = x;
		}
		
		@Override
		public boolean hasNext() {
			return number >= 0;
		}

		@Override
		public Long next() {
			if(hasNext()){
				return number--;
			}
			return null;
		}
	}
}
