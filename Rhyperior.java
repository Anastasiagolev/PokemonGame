import java.util.ArrayList;
import java.util.Scanner;

/*public class Rhyperior is a Pokemon. It has a predefined type, name, attacks, HP, and PP */
public class Rhyperior extends Pokemon {

	//ArrayList<String> called RhyperiorAttacks to hold Rhyperior's attacks
	public ArrayList<String> RhyperiorAttacks = new ArrayList<String>();
	
	//default constructor
	public Rhyperior() {
		super("Rhyperior", "Rock", 60, 30);
		//add attacks to RhyperiorAttacks
		RhyperiorAttacks.add("Rock Throw");
		RhyperiorAttacks.add("Earthquake");
	} 

	//speak() method will print out Pokemon's name
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Rhyperior");
	}//end speak() method

	/*attack() method will initiate Pokemon's attack. Allows user to choose
	  which attack to invoke.*/
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		//get attack from user scanner 
		Scanner input = new Scanner(System.in);
		
		//create boolean variable validInput to maintain loop for try catch blocks 
		boolean validInput = false; 
		
		//print statement to ask user which Attack they would like to use
		System.out.println("Which attack would you like to use? \nType \"R\" for Rock Throw." 
		+ "\nType \"E\" for Earthquake.");
		while(!validInput) {
			try {//try catch statement to catch incorrect inputs
				String keyboard = input.next().toUpperCase(); 
		
				//if attack 1 then 5 damage
				if (keyboard.compareTo("R")==0) { 
					if (getPowerPoints() >= 8) {
						System.out.println("Rhyperior used Rock Throw! Not very Effective...\nHalf Damage");
						setPowerPoints(getPowerPoints()-(8/2)); 
						validInput = true;
					}else { //not enough powerpoints 
						System.out.println("You dont have enough PowerPoints for Rock Throw.");
						System.out.println("Opponenet gets off easy this round!");
						validInput = true;
					}
					//if attack 2 then 16 damage
				}else if(keyboard.compareTo("E")==0) {//else attack is OverHeat
					if (getPowerPoints() >= 16){//can use attack
						System.out.println("Rhyperior used Earthquake! Not very Effective...\nHalf Damage");
						setPowerPoints(getPowerPoints()-(16/2));
						validInput = true;
					}
					else {//not enough Powerpoints for attack
						System.out.println("You dont have enough PowerPoints for Earthquake.");
						System.out.println("Opponenet gets off easy this round!");
						validInput = true;
					}	
				}else if (!keyboard.equals("R") && !keyboard.equals("E")){
					throw new Exception("Input needs to be a \"R\" for Rock Throw or \"E\" for Earthquake.");
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}//end attack() method


	//toString() method
	public String toString() {
		String s = super.toString(); 
		s+="Attacks: ";
		s+=RhyperiorAttacks.get(1) + ", " + RhyperiorAttacks.get(0);
		return s;
	}//end toString() method
	
}


