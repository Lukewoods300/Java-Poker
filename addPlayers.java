import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class addPlayers 
{
	@Test
	void test() 
	{
		Players test = new Players("John");
		test.addPlayers();
		test.addPlayers();
		assertTrue(test.checkNumberOfPlayers()== 2);		
	}

}
