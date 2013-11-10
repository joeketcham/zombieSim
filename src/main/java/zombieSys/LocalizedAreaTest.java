package zombieSys;
import models.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocalizedAreaTest {
	LocalizedArea sim;
	Human human;
	
	@Before
	public void setUp() throws Exception {
		sim = new LocalizedArea();
		//fname, lname, capacity, weight, skill
		String args[] = {"Malcolm", "Gladwell", "10", "1", "2"};
		human = new Human(args);
	}

	@After
	public void tearDown() throws Exception {
		human = null;
		sim = null;
	}

	@Test
	public void testpickupItemSuccess() {
		//desc, bonus, skill, weight
		String args[] = {"knife", "1", "2", "3"};
		InanimateObject weapon = new Weapon(args);
		assertEquals("knife", weapon.getDescription());
		weapon = sim.pickupItem(human, weapon);
		assertNull(weapon);
	}
	@Test
	public void testpickupItemFailWeight(){
		//desc, bonus, skill, weight
		String args[] = {"knife", "1", "2", "30"};
		InanimateObject weapon = new Weapon(args);
		assertEquals("knife", weapon.getDescription());
		weapon = sim.pickupItem(human, weapon);
		assertNotNull(weapon);
	}
	@Test
	public void testpickupItemFailSkill(){
		//desc, bonus, skill, weight
		String args[] = {"knife", "1", "20", "3"};
		InanimateObject weapon = new Weapon(args);
		assertEquals("knife", weapon.getDescription());
		weapon = sim.pickupItem(human, weapon);
		assertNotNull(weapon);
	}
	@Test
	public void testEquipWeaponPass(){
		//desc, bonus, skill, weight
		String args[] = {"knife", "1", "2", "3"};
		InanimateObject weapon = new Weapon(args);
		assertEquals("knife", weapon.getDescription());
		weapon = sim.pickupItem(human, weapon);
		assertNull(weapon);		
		assertTrue(sim.equipWeapon(human, "knife"));	
		assertTrue(sim.unEquipWeapon(human));
	}
}
