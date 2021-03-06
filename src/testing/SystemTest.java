package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import models.*;
import zombieSys.*;

public class SystemTest
{
	ZombieSim theGame;
	Human theHuman;
	Zombie theZombie;
	
	@Before
	public void setUp() throws Exception
	{
		ArrayList<Double> rList = new ArrayList<Double>();
		rList.add(010000.00);
		rList.add(000100.00);
		rList.add(000001.00);
		rList.add(010101.00);
		//Extremes
		rList.add(000000.00);
		rList.add(999999.00);
		rList.add(990000.00);
		rList.add(009900.00);
		rList.add(000099.00);
		rList.add(990099.00);
		rList.add(999900.00);
		rList.add(009999.00);
		rList.add(555555.00);
		rList.add(545555.00);
		theGame = new ZombieSim(rList);
		theZombie = new Zombie("Zombie", 1, 10);
		theHuman = new Human("Human", 1, 10, 10, 1);
	}

	@After
	public void tearDown() throws Exception
	{
	}
	
	@Test
	public void testNavigate()
	{
		theGame.placeObject(000000.00, theHuman);
		theHuman.navigate("s");
		assertNotNull(theGame.getObjectFromRoom(000000.00, theHuman.getName()));
		theHuman.navigate("n");
		assertNotNull(theGame.getObjectFromRoom(010000.00, theHuman.getName()));
		assertNull(theGame.getObjectFromRoom(000000.00, theHuman.getName()));
	}
	
	@Test
	public void testCombat()
	{
		theGame.placeObject(555555.00, theHuman);
		theGame.placeObject(555555.00, theZombie);
		theHuman.navigate("s");
		theZombie.navigate("s");
		theHuman.attack("Zombie");
		assertEquals(9, theZombie.getHealth());
		theZombie.attack("Human");
		assertEquals(9, theHuman.getHealth());
		theHuman.navigate("n");
		theZombie.navigate("n");
		theHuman.attack("Zombie");
		assertEquals(8, theZombie.getHealth());
		theZombie.attack("Human");
		assertEquals(8, theHuman.getHealth());
	}
}
