import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class checkNumberOfPlayers 
{

	@Test
	void test() 
	{	
		Players test = new Players("John");
		test.addPlayers();
		test.addPlayers();
		test.addPlayers();
		assertTrue(test.checkNumberOfPlayers()== 3);
	}

}
