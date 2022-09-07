//Anastasia Golev  Lab 4

/*ComputerPlayer is a Player subclass. ComputerPlayer has 2 private fields roboPokemon, which 
 * is of type Pokemon and roboItem which is of type Item. It has accessor and mutator methods 
 * for the private fields along with a method called void run(), void method use() and a 
 * void compAttack() method. */

public class ComputerPlayer extends Player{

	//fields
	private Pokemon roboPokemon;
	private Item roboItem;
	
	//mutator methods
	public void setPokemon(Pokemon p) {
		roboPokemon = p;
	}
	
	public void setItem( Item i ) {
		roboItem = i; //maybe put in a catch try error later
	}

	//accessor methods
	@Override
	public Pokemon getPokemon() {
		// TODO Auto-generated method stub
		return roboPokemon;
	}
	@Override
	public Item getItem() {
		// TODO Auto-generated method stub
		return roboItem;
	}

	//run() method will output a print statement saying that the computer has chosen to leave
	//battle. Ends program
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Player 2 has chosen to run! You win!");
		System.exit(0); //ends the program
	}

	/* void compAttack() method is created within the computerPlayer class since 
	 * the computer's actions are random. Depending on which Pokemon the computer
	 * player has, and depending on the randomly generated move, this will factor 
	 * into which attack the computer player uses.
	 */
	public void compAttack(){
		//flipping a coin, attacks will be randomly assigned based on randomInt2
		int one = 1;
		int two = 2;
		int randomInt2 = (int)(Math.random() * (two - one + 1 )+ one);
		//first (least effective) attack will be used
		if (randomInt2 == 1) {
			if (getPokemon().getName().compareTo("Charizard") == 0) { //computerPlayer has Charizard
				if (getPokemon().getPowerPoints() >= 5) { //player has enough powerpoints
					System.out.println("Charizard used Dragon Breathe! Super Effective! \nDouble damage!");
					getPokemon().setPowerPoints(getPokemon().getPowerPoints()-(6*2));
				}
				else {//not enough powerpoints
					System.out.println("You dont have enough PowerPoints for Dragon Breathe.");
					System.out.println("Opponenet gets off easy this round!");
			
				}
			}
			else if (getPokemon().getName().compareTo("Rhyperior") == 0) { //computerPlayer has Rhyperior
				if (getPokemon().getPowerPoints() >= 6) {
					System.out.println("Rhyperior used Rock Throw! Not very effective...\nHalf damage");
					getPokemon().setPowerPoints(getPokemon().getPowerPoints()-(6/2)); 
				}else { //not enough powerpoints 
					System.out.println("You dont have enough PowerPoints for Rock Throw.");
					System.out.println("Opponenet gets off easy this round!");
				}
			}
		}else { //randomInt2 = 2 and computerPlayer uses Pokemon's (more effective) second attack
			if (getPokemon().getName().compareTo("Charizard") == 0) {
				if (getPokemon().getPowerPoints() >= 16) { //has enough powerpoints
					System.out.println("Charizard used Overheat! Super Effective! \nDouble damage!");
					getPokemon().setPowerPoints(getPokemon().getPowerPoints()-(16*2));
				}else { //not enough powerpoints
					System.out.println("You dont have enough PowerPoints for Overheat.");
					System.out.println("Opponenet gets off easy this round!");
				}
			}
			else if (getPokemon().getName().compareTo("Rhyperior") == 0) {
				if (getPokemon().getPowerPoints() >= 16){//can use attack
					System.out.println("Rhyperior used Earthquake! Not very effective...\nHalf damage");
					getPokemon().setPowerPoints(getPokemon().getPowerPoints()-(16/2));
				}
				else {//not enough Powerpoints for attack
					System.out.println("You dont have enough PowerPoints for Earthquake.");
					System.out.println("Opponenet gets off easy this round!");
				}
			}
		}
	}//end attack() method
}
