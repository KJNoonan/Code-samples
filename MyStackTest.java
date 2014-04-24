import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MyStackTest {
	private MyStack<Integer> x;
	@Before
	public void setUp() throws Exception {
		x = new MyStack<Integer>(); 
	}
	
	@Test
	public void test1(){
		assertEquals(0,x.size());
	}
	
	@Test
	public void test2(){
		for (int i = 0; i < x.size(); i++){
			x.push(i);
			assertEquals(i, (int)x.peek());
		}
	}

}
