package blatt6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Util {
	static int maxDepth(Node n) {
		NodeList nList = n.getChildNodes();
		int maxNodeDepth = 0;
		if (nList.getLength() == 0) return 1;
		for (int i = 0; i < nList.getLength(); i++) {
			int nodeDepth = maxDepth(nList.item(i));
			if (nodeDepth > maxNodeDepth) {
				maxNodeDepth = nodeDepth;
			}
		}
		return maxNodeDepth + 1;
	}

	static void fringe(Node n, List<Node> result) {
		NodeList nList = n.getChildNodes();
		if (nList.getLength() == 0) {
			result.add(n);
		} else {
			for (int i = 0; i < nList.getLength(); i++) {
				fringe(nList.item(i), result);
			}
		}
	}

	static List<Node> fringe(Node n) {
		ArrayList<Node> result = new ArrayList<Node>();
		fringe(n, result);
		return result;
	}

	static boolean contains(Node n, Predicate<Node> pred) {
		if (pred.test(n)) return true;
		NodeList nList = n.getChildNodes();
		if (nList.getLength() == 0) return false;
		for (int i = 0; i < nList.getLength(); i++) {
			if (contains(nList.item(i), pred)) return true;
		}
		return false;
	}

	static boolean containsName(Node n, String name) {
		return contains(n, (Node e) -> {return e.getNodeName().equals(name);});
	}

	static boolean containsValue(Node n, String name) {
		return contains(n, (Node e) -> {
			if(e.getNodeValue() != null) return e.getNodeValue().equals(name);
			return false;
		});
	}

	static void forEach(Node n, Consumer<Node> cons) {
		cons.accept(n);
		NodeList nList = n.getChildNodes();
		for (int i = 0; i < nList.getLength(); i++) {
			forEach(nList.item(i),cons);
		}
	}

	static int size(Node n) {
		class IntBox {
			int i = 0;
		}
		IntBox ib = new IntBox();
		forEach(n, (x) -> ib.i++);
		return ib.i;
	}

	static void select(Node n, Predicate<Node> pred, List<Node> result) {
//		if(pred.test(n)) result.add(n);
//		NodeList nList = n.getChildNodes();
//		if(nList.getLength() != 0){
//			for(int i = 0; i < nList.getLength(); i++){
//				select(nList.item(i),pred,result);
//			}
//		}
		
		forEach(n, (x) -> { if(pred.test(x)) result.add(x); });
	}

	static void select(Node n, String name, List<Node> result) {
		select(n, (x) -> x.getNodeName().equals(name), result);
	}

	static List<Node> select(Node n, String name) {
		return select(n, (x) -> x.getNodeName().equals(name));
	}

	static List<Node> select(Node n, Predicate<Node> pred) {
		ArrayList<Node> result = new ArrayList<Node>();
		select(n, pred, result);
		return result;
	}
}
