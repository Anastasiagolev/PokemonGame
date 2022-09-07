import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*public class Charizard is a Pokemon. It has a predefined type, name, attacks, HP, and PP */

public class Charizard extends Pokemon {

	//ArrayList<String> called CharizardAttacks to hold Charizard's attacks
	private ArrayList<String> CharizardAttacks = new ArrayList<String>();
	
	
	//default constructor
	public Charizard() {
		super("Charizard", "Fire", 70, 50);
		//add Charizard's attacks
		CharizardAttacks.add("Dragon Breathe");
		CharizardAttacks.add("Overheat");
	} //end ctor

	//speak() method will print out Pokemon's name
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Charizard");
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
		System.out.println("Which attack would you like to use? \nType \"D\" for Dragon Breathe." 
		+ "\nType \"O\" for OverHeat.");
		while(!validInput) {
			try { //try catch statement to catch incorrect inputs
				String keyboard = input.next().toUpperCase(); 
				if (keyboard.compareTo("D") == 0) { 
					if (getPowerPoints() >= 5) { //player has enough powerpoints
						System.out.println("Charizard used Dragon Breathe! Super Effective!\nDouble Damage");
						setPowerPoints(getPowerPoints()-5*2);
						validInput = true;
					}
					else {//not enough powerpoints
						System.out.println("You dont have enough PowerPoints for Dragon Breathe.");
						System.out.println("Opponenet gets off easy this round!");
						validInput = true;
					}
				}else if (keyboard.compareTo("O") == 0) {//else attack is OverHeat
					if (getPowerPoints() >= 16) { //has enough powerpoints
						System.out.println("Charizard used Overheat! Super Effective!\nDouble Damage");
						setPowerPoints(getPowerPoints()-16*2);
						validInput = true;
					}else { //not enough powerpoints
						System.out.println("You dont have enough PowerPoints for Overheat.");
						System.out.println("Opponenet gets off easy this round!");
						validInput = true;
					}
				}else if (!keyboard.equals("D") && !keyboard.equals("O")) {
					throw new Exception("Input needs to be a \"D\" for Dragon Breathe or an \"O\" for OverHeat.");
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}//end attack() method

	//toString() Method
	public String toString() {
		String s = super.toString(); 
		s+="Attacks: ";
		s+=CharizardAttacks.get(1) + ", " + CharizardAttacks.get(0);
		return s;
	}//end toString() method
	
}
