package blatt3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import blatt2.LiLi;

public class TestLiLi {
	
	@Before
	public void setUp () throws Exception {
		LiLi<String> lili = new LiLi<String>("h",new LiLi<String>("a",new LiLi<String>("l",new LiLi<String>("l",new LiLi<String>("o",new LiLi<String>(null,null))))));
		
	}
	
	@Test
	public void test() {
		assertEquals(lili,"hallo");
		assertEquals(5,lili.length());
		assertEquals("a",lili.get(1));
		assertEquals("llo",lili.drop(2));
		assertEquals("hall",lili.take(3));
		assertEquals("allo",lili.sublist(1, 4));
		assertEquals(4,lili.indexOf("o"));
		assertEquals("hallo!",lili.add("!"));
		assertEquals("ollah",lili.reverse());
	}

}
