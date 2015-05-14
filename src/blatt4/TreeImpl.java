package blatt4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TreeImpl<E> implements Tree<E> {
	private E element;
	private List<Tree<E>> children = new ArrayList<>();

	public TreeImpl(E element) {
		this(element,new ArrayList<>());
	}
	public TreeImpl(E element,List<Tree<E>> children) {
		this.element = element;
		this.children = children;
	}

	@Override
	public E getElement() {
		return element;
	}

	@Override
	public void setElement(E element) {
		this.element = element;
	}

	@Override
	public List<Tree<E>> getChildNodes() {
		return children;
	}

	@Override
	public void addChild(E element) {
		addChild(new TreeImpl<E>(element));
	}
	
	@Override
	public int size() {
		if(element == null) return 0;
		int counter = 0;
		for(Tree<E> t: getChildNodes()){
			counter += t.size();
		}
		return 1+counter;
	}
	
	@Override
	public void fringe(List<E> result) {
		if(getChildNodes().size() == 0){
			result.add(element);
		} else {
			for(Tree<E> t: getChildNodes()){
				t.fringe(result);
			}
		}
	}
	
	@Override
	public List<E> pathTo(E elem) {
		List<E> result = new ArrayList<E>();
		if(element.equals(elem)){
			result.add(element);
			return result;
		}
		for(Tree<E> t: getChildNodes()){
			if(t.contains(elem)){
				result.add(element);
				result.addAll(t.pathTo(elem));
				return result;
			}
		}
		return result;
	}
	
	@Override
	public boolean contains(Predicate<E> pred) {
		if(pred.test(element)) return true;
		for(Tree<E> t:getChildNodes()){
			if(t.contains(pred)) return true;
		}
		return false;
	}
	
	@Override
	public void forEach(Consumer<Tree<E>> con) {
			con.accept(this);
			for(Tree<E> t: getChildNodes()){
				t.forEach(con);
			}
	}
	
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null) return false;
		if(getClass() != o.getClass()) return false;
		Tree<E> that = (Tree<E>)o;
		if(element != that.getElement()) return false;
		if(getChildNodes().size() != that.getChildNodes().size()) return false;
		for(int i = 0; i < getChildNodes().size(); i++){
			if(!getChildNodes().get(i).equals(that.getChildNodes().get(i))) return false;
		}
		return true;
	}
	
	@Override
	public <R> Tree<R> mapNew(Function<E, R> f) {
		if(element == null) return new TreeImpl<R>(null,null);
		List<Tree<R>> childs = new ArrayList<>();
		for(Tree<E> t: getChildNodes()){
			childs.add(t.mapNew(f));
		}
		return new TreeImpl<R>(f.apply(element),childs);
	}
	
//	@Override
//	public <R> Tree<R> mapNew(Function<E, R> f) {
//		if(element != null){
//			f.apply(element);
//		}
//		for(Tree<E> t:getChildNodes()){
//			t.mapNew(f);
//		}
//		return (Tree<R>) this;
//	}
	
	
	
	
	
	
	
}