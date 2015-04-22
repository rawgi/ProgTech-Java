package blatt1;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Words implements Iterable<String>{

	private String string;
	
	public Words(String s){
		string = s;
	}
	
	@Override
	public void forEach(Consumer<? super String> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<String> iterator() {
		return new WordIterator(string);
	}

	@Override
	public Spliterator<String> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class WordIterator<String> implements Iterator<String>{
		
		String words;
		
		WordIterator(String s){
			words = s;
		}
		
		@Override
		public void forEachRemaining(Consumer<? super String> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean hasNext() {
			return words.length() > 0;
		}

		@Override
		public String next() {
			String word = "";
			String character;
			while(hasNext()){
				
			}
			
			return word;
		}
		
		@Override
		public void remove(){
			
		}
	}
}