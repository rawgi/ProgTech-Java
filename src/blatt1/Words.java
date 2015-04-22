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
	public Iterator<String> iterator() {
		return new WordIterator();
	}
	
	private class WordIterator implements Iterator<String>{
		
		String words = string;
		
		@Override
		public boolean hasNext() {
			return words.length() > 0;
		}

		@Override
		public String next() {
			String word = "";
			char character = ' ';
			int index = 0;
			while(hasNext()){
				character = words.charAt(index);
				words = words.substring(1, words.length());
				if(character == ' '){
					index = 0;
					return word;
				}
				word = word+character;
			}
			index = 0;
			return word;
		}

	}
}