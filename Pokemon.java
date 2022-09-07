//Anastasia Golev  Lab 4 

/* public abstract Pokemon class will contain the data of a Pokemon, its name,
 * powerpoints, hitpoints, its type, and an Array list of its attacks. 
 * The class will also hold two methods which are also abstract.
 * The methods are public abstract void attack(), which will take another 
 * Pokemon object as its parameter, and public abstract void speak(), which will
 * reiterate the name of the pokemon. 
 */

import java.util.ArrayList;

public abstract class Pokemon {
	

	//hitPoints represents health of a pokemon, powerPoints represents available power for attacks
	private int hitPoints, powerPoints;
	
	//name is the name of Pokemon, type is the type of Pokemon (grass, air, fire, etc.)
	private String name, type;
	
	//attacks represents the attacks that a Pokemon is able to use. attacks are based on powerPoints available
	public ArrayList<String> attacks;
	
	//constructor
	public Pokemon( String n, String t, int hp, int pp) {
		name = n;
		type = t;
		hitPoints = hp;
		powerPoints = pp;
		
	}//end ctor
	
	//accessor/mutator methods
	public int getHitPoints() {
		return hitPoints;
	}
	public int getPowerPoints() {
		return powerPoints;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public ArrayList<String> getAttacks() {
		return attacks;
	}
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	public void setPowerPoints(int powerPoints) {
		this.powerPoints = powerPoints;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setAttacks(ArrayList<String> attacks) {
		this.attacks = attacks;
	}
	
	// abstract methods to be completed in subclasses
	public abstract void speak();
	public abstract void attack();
	
	//toString() method
	public String toString() {
		String s = "";
		s += "****** Pokemon Stats: ******";
		s += "\nName: " + name;
		s += "\nType: " + type;
		s += "\nHitPoints: " + hitPoints;
		s += "\nPowerPoints: " + powerPoints + "\n";
		return s;
	}//end toString() method
}
