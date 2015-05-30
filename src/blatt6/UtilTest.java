package blatt6;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import static blatt6.Util.*;

public class UtilTest {
	Node windsor;
	int i = 0;
	
	@Before
	public void init() {
		try {
			windsor = DocumentBuilderFactory
					.newInstance()
					.newDocumentBuilder()
					.parse("src/blatt6/windsor.xml").getDocumentElement();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			throw new RuntimeException("cannot read test file", e);
		}

	}

	@Test
	public void testMaxDepth() {
		assertEquals(7,maxDepth(windsor));
		
	}
	@Test
	public void testFringe() {
		String expect = " George Elizabeth Charles William George Charlotte Henry Anne Peter Savannah Isla Zara Mia Andrew Beatrice Eugenie Edward Louise James Magaret David Charles Margarita Sarah Samuel Arthur";
		assertEquals(expect, fringe(windsor).stream()
				.reduce("", (res,n)->{
					String val = n.getNodeValue().trim(); 
					return val.isEmpty()?res:res+" "+val;		
				}, (r1,r2)->r1+" "+r2));
	}
	
	@Test
	public void testContains() {
		assertTrue(containsName(windsor, "element"));
		assertFalse(containsName(windsor, "Wilhelm"));
		assertTrue(containsValue(windsor, "Henry"));

	}

	@Test
	public void testSize() {
		assertEquals(129,size(windsor));
	}

	@Test
	public void testSelect() {
		assertEquals(26, select(windsor,n -> n.getNodeName().equals("element")).size());
	}
	
	@Test
	public void testForEach(){
		forEach(windsor, n -> i++);
		assertEquals(size(windsor),i);
	}
}
