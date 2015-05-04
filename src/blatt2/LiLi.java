package blatt2;

public class LiLi<A> implements Iterable<A> {
	private final A hd;
	private final LiLi<A> tl;

	public LiLi(A hd, LiLi<A> tl) {
		this.hd = hd;
		this.tl = tl;
	}

	public LiLi() {
		this.hd = null;
		this.tl = null;
	}

	public boolean isEmpty() {
		return tl == null && hd == null;
	}

	public A getHead() {
		return hd;
	}

	public LiLi<A> getTail() {
		return tl;
	}

	public java.util.Iterator<A> iterator() {
		return new It(this);
	}

	private class It implements java.util.Iterator<A> {
		LiLi<A> theList;

		It(LiLi<A> li) {
			theList = li;
		}

		public boolean hasNext() {
			return !theList.isEmpty();
		}

		public A next() {
			A result = theList.getHead();
			theList = theList.getTail();
			return result;
		}
	}

	public int length() {

		if (isEmpty())
			return 0;

		final int tailResult = getTail().length();

		final int result = 1 + tailResult;

		return result;
	}

	public boolean contains(A a) {

		if (isEmpty())
			return false;

		final boolean tailResult = getTail().contains(a);

		final boolean result = getHead().equals(a) || tailResult;

		return result;
	}

	public LiLi<A> append(LiLi<A> that) {

		if (isEmpty())
			return that;

		final LiLi<A> tailResult = getTail().append(that);

		final LiLi<A> result = new LiLi<A>(getHead(), tailResult);

		return result;
	}

	public String toString(){
		if(!isEmpty()) return (String)hd+getTail().toString();
		return "";
	}
	
	public A get(int index) throws Exception{
		if(index < 0 || index > length()-1) throw new IndexOutOfBoundsException();
		if(index == 0){
			return hd;
		}
		LiLi<A> result = this;
		for(int i = 0; i < index; i++){
			result = result.getTail();
		}
		return result.getHead();
	}
	
	public LiLi<A> drop(int i){
		if(i < 0) return this;
		if(i > length()) return new LiLi<A>();
		
		LiLi<A> result = this;
		for(int y = 0; y < i; y++){
			result = result.getTail();
		}
		return result;
	}
	
	public LiLi<A> take(int i){
		if(i < 0) return new LiLi<A>(null,null);
		if(i > length()) return this;
		if(i > 0) return new LiLi<A>(hd,tl.take(--i));
		return new LiLi<A>(null,null);
	}
	
	public LiLi<A> sublist(int start, int length){
		return drop(start).take(length);
	}
	
	public int indexOf(A el){
		int result = -1;
		LiLi<A> tmp = this;
		for(int i = 0; i < length(); i++){
			if(el == tmp.getHead()){
				result = i;
				break;
			}
			tmp = tmp.getTail();
		}
		return result;
	}
	
	public LiLi<A> add(A el){
		if(!isEmpty()) return new LiLi<A>(hd,tl.add(el));
		return new LiLi<A>(el, new LiLi<A>(null,null));
	}
	
	public LiLi<A> reverse() throws Exception{
		if(!isEmpty()) return new LiLi<A>(get(length()-1),take(length()-1).reverse());
		return this;
	}
	
	public void machtAlle(java.util.function.Consumer<A> c){
		if(!isEmpty()){
			c.accept(hd);
			tl.machtAlle(c);
		}
	}
	
	<B> LiLi<B> map(java.util.function.Function<A,B> f){
		if(!isEmpty()) return new LiLi<B>(f.apply(hd),tl.map(f));
		return new LiLi<B>(null,null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
