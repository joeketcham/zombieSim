package testing;

import models.*;
import zombieSys.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocalizedAreaTest {
        LocalizedArea sim;
        Human human;
        
        @Before
        public void setUp() throws Exception {
                sim = new LocalizedArea(000000.00);
                //fname, lname, capacity, weight, skill
                //String args[] = {"Malcolm", "Gladwell", "10", "1", "2"};
                human = new Human("Malcolm", 1, 10, 10, 2);
    			  		
        }

        @After
        public void tearDown() throws Exception
        {
        	
                human = null;
                sim = null;
        }

        @Test
        public void testpickupItemSuccess() {
                
                InanimateObject weapon = new Weapon("knife", "weapon", 1, 3, 2);
                assertEquals("weapon", weapon.getDescription());
                weapon = human.pickupItem(weapon);
                assertNull(weapon);
        }
        @Test
        public void testpickupItemFailWeight(){
              
                InanimateObject weapon = new Weapon("knife", "weapon", 1, 30, 2);
                assertEquals("weapon", weapon.getDescription());
                weapon = human.pickupItem(weapon);
                assertNotNull(weapon);
        }
        @Test
        public void testpickupItemFailSkill(){
                
                InanimateObject weapon = new Weapon("knife", "weapon", 1, 9, 3);
                assertEquals("weapon", weapon.getDescription());
                weapon = human.pickupItem(weapon);
                assertNotNull(weapon);
        }
        
        @Test         
        public void testEquipWeaponPass(){         
               
                InanimateObject weapon = new Weapon("knife", "weapon", 1, 3, 2);
                weapon = human.pickupItem(weapon);
                assertTrue(human.equipWeapon("knife"));
        }         
      
        @Test         
        //test case for non-weapon equipped         
        public void testEquipWeaponFail(){         
               
                InanimateObject armor = new Armor("jacket", "shoulders", 1, 3, 2);
                armor = human.pickupItem(armor);
                assertFalse(human.equipWeapon("jacket"));
        }         
         
        @Test         
        //test case for weapon with an already equipped weapon         
        public void testEquipWeaponFail2(){         
               
                InanimateObject gun = new Weapon(".45 with silencer", "weapon", 1, 3, 2);
                gun = human.pickupItem(gun);       
         
                //item to pickup; fail to equip with something already equipped
              
                InanimateObject gun2 = new Weapon("shotgun", "weapon", 1, 3, 2);
                gun2 = human.pickupItem(gun2);  
                 
                assertTrue(
                human.equipWeapon(".45 with silencer"));
                assertFalse(
                human.equipWeapon("shotgun"));
        }         
         
        @Test         
        //test case for non-weapon with an already equipped weapon         
        public void testEquipWeaponFail3(){         
        	        InanimateObject gun = new Weapon(".45 with silencer", "weapon", 1, 3, 2);
                    gun = human.pickupItem(gun);       
             
                  //desc, bonus, skill, weight
                  
                    InanimateObject armor = new Armor("jacket", "shoulders", 1, 3, 2);
                    armor = human.pickupItem(armor);  
                     
                    assertTrue(
                    human.equipWeapon(".45 with silencer"));
                    assertFalse(
                    human.equipWeapon("jacket"));
        }
        
         @Test         
        //test case for attempting to equip an item already equipped         
        public void testEquipWeaponFail4(){         
        	 InanimateObject gun = new Weapon(".45 with silencer", "weapon", 1, 3, 2);
             gun = human.pickupItem(gun);  
                assertTrue(
                human.equipWeapon(".45 with silencer"));
                assertFalse(
                human.equipWeapon(".45 with silencer"));
        }
         
         @Test         
                public void testEquipArmorPass(){         
                        //desc, bonus, skill, weight
                       
                        InanimateObject armor = new Armor("Bulletproof Plate", "shoulders", 1, 3, 2);
                        armor = human.pickupItem(armor); 
                        assertTrue(
                        human.equipArmor("Bulletproof Plate"));
                }         
              
                @Test         
                //test case for non-armor equipped         
                public void testEquipArmorFail()
                {         
                	InanimateObject gun = new Weapon("weaponTest", "weapon", 1, 3, 2);
                    gun = human.pickupItem(gun);  
                        assertFalse(
                        human.equipArmor("weaponTest"));
                }         
                 
                @Test         
                //test case for armor with an already equipped armor 
                public void testEquipArmorFail2()
                {
                    InanimateObject armor = new Armor("Bulletproof Plate", "shoulders", 1, 3, 2);
                    armor = human.pickupItem(armor);    
                 
                        //item to pickup; fail to equip with something already equipped
                     
                    InanimateObject armor1 = new Armor("Coat", "shoulders", 1, 3, 2);
                    armor1 = human.pickupItem(armor1); 
                         
                        assertTrue(
                        human.equipArmor("Bulletproof Plate"));
                        assertFalse(
                        human.equipArmor("Coat"));
                }         
                 
                @Test         
                //test case for non-weapon with an already equipped weapon         
                public void testEquipArmorFail3(){         
           
	                    InanimateObject armor = new Armor("Bulletproof Plate", "shoulders", 1, 3, 2);
	                    armor = human.pickupItem(armor);                  
	                 
	                    InanimateObject gun = new Weapon("gun", "weapon", 1, 3, 2);
	                    gun = human.pickupItem(gun); 
                         
                        assertTrue(
                        human.equipArmor("Bulletproof Plate"));
                        assertFalse(
                        human.equipArmor("gun"));
                }
                 
                 @Test         
                //test case for attempting to equip an item already equipped         
                public void testEquipArmorFail4(){         
                	 InanimateObject armor = new Armor("Bulletproof Plate", "shoulders", 1, 3, 2);
                     armor = human.pickupItem(armor); 
                        assertTrue(
                        human.equipArmor("Bulletproof Plate"));
                        assertFalse(
                        human.equipArmor("Bulletproof Plate"));
                }
}