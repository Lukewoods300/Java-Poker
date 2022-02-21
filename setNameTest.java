import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class setNameTest 
{

	@Test
	void test() 
	{
		Players test = new Players("John");
		test.setName("Jack");
		assertTrue(test.getName()== "Jack");
	}

}
