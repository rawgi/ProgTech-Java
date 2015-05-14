package blatt4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class TreeTest {
	int e = 0;
	Tree<String> george;
	Tree<String> elizabeth;
	Tree<String> charles;
	Tree<String> william;
	Tree<String> george2;
	Tree<String> charlotte;
	Tree<String> henry;
	Tree<String> anne;
	Tree<String> peter;
	Tree<String> savannah;
	Tree<String> isla;
	Tree<String> zara;
	Tree<String> mia;
	Tree<String> andrew;
	Tree<String> beatrice;
	Tree<String> eugenie;
	Tree<String> edward;
	Tree<String> louise;
	Tree<String> james;
	Tree<String> magaret;
	Tree<String> david;
	Tree<String> charles2;
	Tree<String> margarita;
	Tree<String> sarah;
	Tree<String> samuel;
	Tree<String> arthur;
	
	
	@Before
	public void init() {
		george = new TreeImpl<>("George");
		elizabeth = new TreeImpl<>("Elizabeth");
		george.addChild(elizabeth);
			charles = new TreeImpl<>("Charles");
			elizabeth.addChild(charles);
				william = new TreeImpl<>("William");
				charles.addChild(william);
					george2 = new TreeImpl<>("George");
					william.addChild(george2);
					charlotte = new TreeImpl<>("Charlotte");
					william.addChild(charlotte);
				henry = new TreeImpl<>("Henry");
				charles.addChild(henry);
				
			anne = new TreeImpl<>("Anne");
			elizabeth.addChild(anne);
				peter = new TreeImpl<>("Peter");
				anne.addChild(peter);
					savannah = new TreeImpl<>("Savannah");
					peter.addChild(savannah);
					isla = new TreeImpl<>("Isla");
					peter.addChild(isla);
				zara = new TreeImpl<>("Zara");
				anne.addChild(zara);
					mia = new TreeImpl<>("Mia");
					zara.addChild(mia);
					
			andrew = new TreeImpl<>("Andrew");
			elizabeth.addChild(andrew);
				beatrice = new TreeImpl<>("Beatrice");
				andrew.addChild(beatrice);
				eugenie = new TreeImpl<>("Eugenie");
				andrew.addChild(eugenie);
			
			edward = new TreeImpl<>("Edward");
			elizabeth.addChild(edward);
				louise = new TreeImpl<>("Louise");
				edward.addChild(louise);
				james = new TreeImpl<>("James");
				edward.addChild(james);
		
		
		magaret = new TreeImpl<>("Magaret");
		george.addChild(magaret);
			david = new TreeImpl<>("David");
			magaret.addChild(david);
 				charles2 = new TreeImpl<>("Charles");
 				david.addChild(charles2);
 				margarita = new TreeImpl<>("Margarita");
 				david.addChild(margarita);
			sarah = new TreeImpl<>("Sarah");
			magaret.addChild(sarah);
				samuel = new TreeImpl<>("Samuel");
				sarah.addChild(samuel);
				arthur = new TreeImpl<>("Arthur");
				sarah.addChild(arthur);
		
	}

	
	@Test
	public void testSize() {
		assertEquals(26, george.size());
		assertEquals(1, charlotte.size());
	}
	@Test
	public void testFringe() {
			List<String> result = new ArrayList<>();
			result.add(george2.getElement());
			result.add(charlotte.getElement());
			result.add(henry.getElement());
			result.add(savannah.getElement());
			result.add(isla.getElement());
			result.add(mia.getElement());
			result.add(beatrice.getElement());
			result.add(eugenie.getElement());
			result.add(louise.getElement());
			result.add(james.getElement());
			result.add(charles2.getElement());
			result.add(margarita.getElement());
			result.add(samuel.getElement());
			result.add(arthur.getElement());
			assertEquals(result, george.fringe());
	}
	@Test
	public void testPathTo() {
		List<String> result = new ArrayList<>();
		result.add(george.getElement());
		result.add(elizabeth.getElement());
		result.add(charles.getElement());
		result.add(william.getElement());
		result.add(charlotte.getElement());
		assertEquals(result, george.pathTo("Charlotte"));

	}	
	@Test
	public void testContains() {
		assertTrue(george.contains("William"));
		assertFalse(george.contains("Wilhelm"));
		assertTrue(zara.contains("Zara"));
		assertFalse(george.contains(x -> x.startsWith("WI")));
		assertTrue(george.contains(x -> x.startsWith("Wil")));

	}
	@Test
	public void testMapModify() {
		int size = george.size();
		List<String> fringe = george.fringe();
		int fringeSize = fringe.size();
		
		george.mapModify(s -> s.toUpperCase());
		assertEquals("WILLIAM",william.getElement());
		assertEquals("ELIZABETH",elizabeth.getElement());
		assertEquals("ZARA",zara.getElement());
		
		
		List<String> fringe2 = george.fringe();
		assertEquals(size, george.size());
		assertEquals(fringeSize, fringe2.size());

		assertEquals(fringe.stream().map(x->x.toUpperCase()).collect(Collectors.toList()), fringe2);
	}

	@Test
	public void testMapNew() {
		assertEquals(george, george.mapNew(x->x));
		assertEquals(george.size(), george.mapNew(x->x.length()).size());
		assertNotEquals(george, george.mapNew(x->x.length()));
		assertEquals(6, 0+george.mapNew(x->x.length()).getElement());
	}
	
	@Test
	public void testForEach(){
		george.forEach(c -> e++);
		assertEquals(26,e);
		e = 0;
		charlotte.forEach(c -> e++);
		assertEquals(1,e);
	}
}
