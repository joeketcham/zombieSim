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
		String args[] = {
		"knife", "1", "2", "3"};
		InanimateObject weapon =
		new Weapon(args);
		weapon =
		sim.pickupItem(human, weapon);
		assertTrue(
		human.equipWeapon("knife"));
	}
	 
	 
	@Test	 
	//test case for non-weapon equipped	 
	public void testEquipWeaponFail(){	 
		//desc, bonus, skill, weight
		String args[] = {
		"armorTest", "1", "2", "3"};
		InanimateObject armor =
		new Armor(args);
		armor =
		sim.pickupItem(human, armor);
		assertFalse(
		human.equipWeapon("armorTest"));
	}
	 
	 
	@Test	 
	//test case for weapon with an already equipped weapon	 
	public void testEquipWeaponFail2(){	 
		//desc, bonus, skill, weight		 
		//item to equip
		String args[] = {
		".45 with silencer", "1", "2", "3"};
		InanimateObject gun =
		new Weapon(args);
		gun =
		sim.pickupItem(human, gun);	 
	 
		//item to pickup; fail to equip with something already equipped
		String args2[] = {
		"shotgun", "1", "2", "3"};
		InanimateObject gun2 =
		new Weapon(args2);
		gun2 =
		sim.pickupItem(human, gun2);
		 
		assertTrue(
		human.equipWeapon(".45 with silencer"));
		assertFalse(
		human.equipWeapon("shotgun"));
	}
	 
	 
	@Test	 
	//test case for non-weapon with an already equipped weapon	 
	public void testEquipWeaponFail3(){	 
		//desc, bonus, skill, weight		 
		//item to equip
		String args[] = {
		".45 with silencer", "1", "2", "3"};
		InanimateObject gun =
		new Weapon(args);
		gun =
		sim.pickupItem(human, gun);		 
		 
		//item to fail to equip
		String args2[] = {
		"armorItem", "1", "2", "3"};
		InanimateObject armor =
		new Armor(args2);
		armor =
		sim.pickupItem(human, armor);
		 
		assertTrue(
		human.equipWeapon(".45 with silencer"));
		assertFalse(
		human.equipWeapon("armorTest"));
	}
	 
	 @Test	 
	//test case for attempting to equip an item already equipped	 
	public void testEquipWeaponFail4(){	 
		//desc, bonus, skill, weight
		String args[] = {
		".45 with silencer", "1", "2", "3"};
		InanimateObject gun =
		new Weapon(args);
		gun =
		sim.pickupItem(human, gun);
		assertTrue(
		human.equipWeapon(".45 with silencer"));
		assertFalse(
		human.equipWeapon(".45 with silencer"));
	}
}
