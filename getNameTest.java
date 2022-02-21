import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class getNameTest 
{

	@Test
	void test() 
	{
		Players test = new Players("Nancy");
		test.setName("Nan");
		assertTrue(test.getName()== "Nan");
	}

