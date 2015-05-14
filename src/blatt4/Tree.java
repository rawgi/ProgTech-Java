package blatt4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Tree<E> {

	E getElement();

	void setElement(E element);

	List<Tree<E>> getChildNodes();

	void addChild(E element);

	default void addChild(Tree<E> child) {
		getChildNodes().add(child);
	};

	int size();

	void fringe(List<E> result);

	default List<E> fringe() {
		List<E> result = new ArrayList<>();
		fringe(result);
		return result;
	}

	List<E> pathTo(E elem);

	boolean contains(Predicate<E> pred);

	default boolean contains(E el) {
		return contains(e -> e.equals(el));
	}

	void forEach(Consumer<Tree<E>> con);

	default void mapModify(Function<E, E> f) {
		forEach(t -> t.setElement(f.apply(t.getElement())));
	}

	<R> Tree<R> mapNew(Function<E, R> f);
}
