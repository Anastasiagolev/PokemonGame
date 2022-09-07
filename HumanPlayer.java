//Anastasia Golev  Lab 4

/*HumanPlayer is a Player subclass. HumanPlayer has 2 private fields myPokemon, which 
 * is of type Pokemon and myItem which is of type Item. It has accessor and mutator methods 
 * for the private fields along with a method called void run() and void method use() */

public class HumanPlayer extends Player{

	//private fields 
	private Pokemon myPokemon;
	private Item myItem;
	
	//mutator methods
	public void setPokemon (Pokemon p) {
		myPokemon = p;
	}
	
	public void setItem (Item i) {
		myItem = i;
	}
	
	//accessor methods
	@Override
	public Item getItem() {
		return myItem;
	}
	@Override
	public Pokemon getPokemon() {
		// TODO Auto-generated method stub
		return myPokemon;
	}

	//run() method will output a print statement saying that the user has chosen to leave
	//battle. Ends program
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Player 1 has chosen to run! Player 2 wins :(");
		System.exit(0); //ends the program

	}//end run() method
	
	

}
