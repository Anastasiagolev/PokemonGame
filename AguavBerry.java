//Anastasia Golev Lab 4 

/* public class AguavBerry implements Item interface. The class has one default constructor 
 * and a method called use() which takes a Pokemon p as a parameter, the method is meant 
 * to be used on a Pokemon. Aguav Berry restores a pokemons hitpoints if its low. In addition
 * a statement will be printing that the pokemon has confusion, as this is a result of using 
 * an Aguav Berry on a Pokemon.
 */
public class AguavBerry implements Item {

	/*use() method will restore a Pokemon's HP is it is low. In this case
	 * low is less than 25. along with each use of this item, a statement will
	 * be printed that the pokemon is confused since this is a result of 
	 * using an Aguav Berry.
	 */
	@Override
	public void use(Pokemon p) {
		//if Pokemon's HP is less than 25
		if (p.getHitPoints() < 25) {
			//checks which pokemon the player has
			if (p.getName().compareTo("Charizard") == 0) {
				p.setHitPoints(100);//Restores a Pokemons HP
				System.out.println(p.getName() + " used Aguav Berry!");
				System.out.println(p.getName() +"'s HP has been restored.");
				System.out.println(p.getName()+ " has become a bit confused!");
			}else if (p.getName().compareTo("Rhyperior") == 0){
				//Pokemon is Rhyperior
				p.setHitPoints(112);//Restores a Pokemons HP
				System.out.println(p.getName() + " used Aguav Berry!");
				System.out.println(p.getName() +"'s HP has been restored.");
				System.out.println(p.getName()+ " has become a bit confused!");
			}
		}else {//else Pokemon's HP is still high, print statement to inform player that Aguav Berry is of no use
			System.out.println(p.getName() + " is still in good health. Aguav Berry is ineffective");
		}
	}//end use() method

	//toString() method
	public String toString() {
		String s = "";
		s += "Aguav Berry";
		return s;
	}//end toString() method
}
