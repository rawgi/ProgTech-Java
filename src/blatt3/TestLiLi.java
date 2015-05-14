package blatt3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import blatt2.LiLi;

public class TestLiLi {

	LiLi<String> lili;
	int e = 0;
	
	@Before
	public void setUp() {
		lili = new LiLi<String>("h",new LiLi<String>("a",new LiLi<String>("l",new LiLi<String>("l",new LiLi<String>("o",new LiLi<String>(null,null))))));
	}
	
	@Test
	public void test() throws Exception {
		assertEquals("[h,a,l,l,o]",lili.toString());
		assertEquals(5,lili.length());
		assertEquals("a",lili.get(1));
		assertEquals("[l,l,o]",lili.drop(2).toString());
		assertEquals("[h,a,l]",lili.take(3).toString());
		assertEquals("[a,l,l,o]",lili.sublist(1, 4).toString());
		assertEquals(4,lili.indexOf("o"));
		assertEquals("[h,a,l,l,o,!]",lili.add("!").toString());
		assertEquals("[o,l,l,a,h]",lili.reverse().toString());
		lili.machtAlle(c -> e++);
		assertEquals(lili.length(),e);
		assertEquals("[H,A,L,L,O]",lili.map(x -> x.toUpperCase()).toString());
	}
}