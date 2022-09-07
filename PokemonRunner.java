//Anastasia Golev  Lab 4

/* public class PokemonRunner will be a menu based Pokemon game in which the user will be Player 1
 * versing the computer, which will be the Player 2. The user is given the choice to choose their 
 * Pokemon and their Item. The computer will choose their Pokemon and Item randomly. The game will 
 * continue until one pokemon has fainted or until either Player decided to flee. 
 */

import java.util.*;

public class PokemonRunner {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//boolean variable continuePlaying initalized as true, will continue the game based on user input
		//at the end of the game
		boolean continuePlaying = true;
		
		//do{}while loop which will continue until the user indicates that they don't wish to play again
		do {	
	
			System.out.println("\n******** Welcome to the Pokemon Battlefield! *********\n");
			System.out.println("Player 1 choose your Pokemon: \nEnter \"C\" for Charizard or \"R\" for Rhyperior");
		
			
			//create instances of pokemons (Charizard c and Rhyperior r)
			Pokemon c = new Charizard();
			Pokemon r = new Rhyperior();
			
			//create instances of HumanPlayer named player1 and ComputerPlayer named player2
			HumanPlayer player1 = new HumanPlayer();
			ComputerPlayer player2 = new ComputerPlayer();
			
			//create instances of Items BerryJuice named item1 and AguavBerry named item2
			BerryJuice item1 = new BerryJuice();
			AguavBerry item2 = new AguavBerry();
			FloatStone item3 = new FloatStone();
			
			//create boolean variable validInput to maintain loop for try catch blocks 
			boolean validInput = false;
			
			//create user input with Scanner object
			Scanner input = new Scanner(System.in);
			
			while(!validInput) {
				try {
					String keyboard = input.next().toUpperCase();
					//if statement to assign pokemon to HumanPlayer and ComputerPlayer based on user input
					if (keyboard.compareTo("C")==0) {
						System.out.println("You have chosen CHARIZARD. Opponent will have RHYPERIOR.");
						player1.setPokemon(c);
						player2.setPokemon(r);
						validInput = true;
					}else if (keyboard.compareTo("R")==0){
						System.out.println("You have chosen RHYPERIOR. Opponent will have CHARIZARD.");
						player1.setPokemon(r);
						player2.setPokemon(c);
						validInput = true;
					}else if(!keyboard.equals("C") && !keyboard.equals("R")) {
						throw new Exception("Input needs to be a \"C\" or an \"R\"");
					}
				}catch (Exception e) {
					System.out.println(e.getMessage());
	
				}
			}
			
			//create print statement describing items later
			System.out.println("\nItems Available \n•Berry Juice restores the HP of your Pokemon by 20 points!"
					+ "\n•Aguav Berry restores your Pokemon's HP if it's low!\n•Float Stone reduces the weight of your Pokemon when held!");
			System.out.println("\nPlayer 1 choose your Item: \nEnter \"B\" for Berry Juice or \"A\" for Aguav Berry or \"F\" for Float Stone");
			
			//create boolean variable validInput2 to maintain loop for try catch blocks 
			boolean validInput2 = false;
			//create Scanner input to get user choice for items
			Scanner input1 = new Scanner(System.in);
			while(!validInput2) {
				try {
					String keyboard1 = input1.next().toUpperCase();
					
					//if statement to assign item to HumanPlayer based on user input 
					if (keyboard1.compareTo("B")==0) {
						System.out.println("\nYou have chosen BERRY JUICE. You may use this item 3 times.");
						player1.setItem(item1);
						validInput2=true;
					}else if (keyboard1.compareTo("A")==0){
						System.out.println("\nYou have chosen AGUAV BERRY. You may use this item 3 times.");
						player1.setItem(item2);
						validInput2=true;
					}else if ((keyboard1.compareTo("F")==0)){
						System.out.println("\nYou have chosen FLOAT STONE. You may use this item 3 times.");
						player1.setItem(item3);
						validInput2=true;
					}else if(!keyboard1.equals("A") && !keyboard1.equals("B") && !keyboard1.equals("F")) {
						throw new Exception("Input needs to be a \"B\", \"A\" or \"F\"");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			//create an integer variable called itemCount which will allow a maximum of 3 uses for User's item
			int itemCount = 3;
			
			//create an integer variable called compItemCount which will allow a max of 3 uses for computer's item
			int compItemCount = 3;
			
			//give BerryJuice, AguavBerry, and FloatStone numeric values, based on the random number generator
			//ComputerPlayer will hold that item
			
			//generate a value between 1 and 3
			int min = 1;
			int max = 3;
			int randomInt = (int) (Math.random() * (max - min + 1) + min);
			
			//if statement to assign item to ComputerPlayer
			if (randomInt == 1) { player2.setItem(item1); System.out.println("Opponent will have BERRYJUICE.");}
			else if (randomInt == 2){ player2.setItem(item2);System.out.println("Opponent will have AguavBerry.");}
			else { player2.setItem(item3);System.out.println("Opponent will have FLOATSTONE.");}
			
			//print statement will all pokemon stats
			System.out.println("\nPlayer 1's Pokemon: ");
			System.out.println(player1.getPokemon());
			
			System.out.println("\nPlayer 2's Pokemon: ");
			System.out.println(player2.getPokemon());
			
			//begin first round of battle now
			System.out.println("\n******** Let the Battle Begin! ********\n");
			
			//create boolean variable validInput3 to maintain loop for try catch blocks 
			boolean validInput3 = false;
			
			//only establishing the first round here
			//generate a random value and depending on that value, either ComputerPlayer or HumanPlayer will go first
			//(flip a coin)
			
			int one = 1;
			int two = 2;
			int randomInt2 = (int)(Math.random() * (two - one + 1 )+ one);
			
			//if randomly generated integer is 1, HumanPlayer will go first
			if (randomInt2 == 1) {
				System.out.println("Player 1 goes first...");
				System.out.println("Choose your move from the Menu options\nMenu: ");
				System.out.println("For Attack press \"A\" \nFor Use Item press \"I\" \nFor Flee press \"F\"");
				Scanner input2 = new Scanner(System.in);
				while(!validInput3) {
					try {
						String keyboard2 = input2.next().toUpperCase();
						//if user input A, then user Pokemon attacks computer Pokmeon
						if (keyboard2.equals("A")) {
							//integer variable before attack holds value of PP prior to attack
							int beforeAttack = player1.getPokemon().getPowerPoints();
							
							player1.getPokemon().attack(); //initiate attack
							
							//integer variable afterAttack hold value of PP after attack
							int afterAttack = player1.getPokemon().getPowerPoints(); 
					
							//create an integer variable called damage which measures the damage done on Player 2's HP based on P1's beforeAttack and afterAttack
							int damage = (beforeAttack - afterAttack);
							
							//subtract and save the damage done on Player 2's Pokemon HP
							player2.getPokemon().setHitPoints(player2.getPokemon().getHitPoints() - damage);
							System.out.println("You've inflicted " + damage + " on " + player2.getPokemon().getName());
							System.out.println("Player 2's hp: " + player2.getPokemon().getHitPoints());
							validInput3 = true;
						}
						//if user input I, then user Pokemon uses an item
						else if (keyboard2.equals("I")) {
							//check if has any more uses left
							if(itemCount > 0) {//if yes, then use
								player1.getItem().use(player1.getPokemon());
								itemCount--;//decrememnt counter
								System.out.println("You have "+ itemCount + " more uses of " + player1.getItem());
							}else {//else no more uses, print statement
								System.out.println("You ran out of items!");
							}
							validInput3 = true;
						}
						else if (keyboard2.equals("F")){ //player 1 has chosen to flee
							player1.run();
							validInput3 = true;
						}else if(!keyboard2.equals("A") && !keyboard2.equals("I") && !keyboard2.equals("F")) {
							throw new Exception("Input needs to be a \"A\", \"I\" or \"F\"");
						}
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}else { //computer player goes, everything will be chosen randomly
				System.out.println("Player 2 goes first...");
				randomInt = (int) (Math.random() * (max - min + 1) + min);
				if (randomInt == 1) {
					//Computer player attacks Human player
					System.out.println("Player 2 has chosen Attack!");
					int beforeAttack = player2.getPokemon().getPowerPoints();//integer variable beforeAttack holds value of PP prior to attack
					player2.compAttack();//initiate attack
					int afterAttack = player2.getPokemon().getPowerPoints(); //integer variable afterAttack hold value of PP after attack
			
					//create an integer variable called damage which measures the damage done on Player 1's HP based on P2's beforeAttack and afterAttack
					int damage = (beforeAttack - afterAttack);
					
					//subtract and save the damage done on Player 1's Pokemon HP
					player1.getPokemon().setHitPoints(player1.getPokemon().getHitPoints() - damage);
					System.out.println("Player 2 inflicted " + damage + " on " + player1.getPokemon().getName() + "!");
					System.out.println("Player 1's hp: " + player1.getPokemon().getHitPoints());
				}
				else if (randomInt == 2) { //computer player uses item
					//check if has any more uses left
					if(compItemCount > 0) {//if yes, then use
						player2.getItem().use(player2.getPokemon());
						compItemCount--;//decrememnt counter
						System.out.println("Player 2 has "+ compItemCount + " more uses of " + player2.getItem());
					}else {//else no more uses, print statement
						System.out.println("Player 2 ran out of items!");
					}
				}
				else { //computer player runs away
					player2.run();
				}
			}
			
			//create a integer variable counter to count the rounds
			int counter = 2; //begins at two since the first round has already happened
			
			//create boolean variable validInput4 to maintain loop for try catch blocks 
			boolean validInput4 = false; 
	
			//generate a value between 1 and 3
			int randomInt4 = (int) (Math.random() * (max - min + 1) + min);
			//do{}while loop to contiue the game until a Pokemon has fainted
			do {
				System.out.println("\n******* Round " + counter + " *******");
				
				System.out.println("\nPlayer 1's turn\n");
				System.out.println("Choose your move from the Menu options\nMenu: ");
				System.out.println("For Attack press \"A\" \nFor Use Item press \"I\" \nFor Flee press \"F\"");
				
				//cretae scanner variable to get user input
				Scanner input3 = new Scanner(System.in);
				while(!validInput4) {
					try {
						String keyboard3 = input3.next().toUpperCase();
						
						//if user input A, then user Pokemon attacks computer Pokemon
						if (keyboard3.equals("A")) {
							//integer variable before attack holds value of PP prior to attack
							int beforeAttack = player1.getPokemon().getPowerPoints();
							player1.getPokemon().attack(); //initiate attack
							int afterAttack = player1.getPokemon().getPowerPoints(); //integer variable afterAttack hold value of PP after attack
					
							//create an integer variable called damage which measures the damage done on Player 2's HP based on P1's beforeAttack and afterAttack
							int damage = (beforeAttack - afterAttack);
							
							//subtract and save the damage done on Player 2's Pokemon HP
							player2.getPokemon().setHitPoints(player2.getPokemon().getHitPoints() - damage);
							System.out.println("You've inflicted " + damage + " on " + player2.getPokemon().getName());
							System.out.println("Player 2's hp: " + player2.getPokemon().getHitPoints());
							validInput4 = true;
						}
						//if user input I, then user Pokemon uses an item
						else if (keyboard3.equals("I")) {
							 //check if has any more uses left
							if(itemCount > 0) {//if yes, then use
								player1.getItem().use(player1.getPokemon());
								itemCount--;//decrememnt counter
								System.out.println("You have "+ itemCount + " more uses of " + player1.getItem());
							}else {//else no more uses, print statement
								System.out.println("You ran out of items!");
							}
							validInput4 = true;
						}
						else if (keyboard3.equals("F")){ //player 1 has chosen to flee
							player1.run();
							validInput4 = true;
						}else if (!keyboard3.equals("A") && !keyboard3.equals("I") && !keyboard3.equals("F")) {
							throw new Exception("Input needs to be a \"A\", \"I\" or \"F\"");
						}
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				System.out.println("\nPlayer 2's turn\n");
				if (randomInt4 == 1 ) {
					//Computer player attacks Human player
					System.out.println("Player 2 has chosen Attack!");
					//integer variable beforeAttack holds value of PP prior to attack
					int beforeAttack = player2.getPokemon().getPowerPoints();
					player2.compAttack(); //initiate attack
					int afterAttack = player2.getPokemon().getPowerPoints(); //integer variable afterAttack hold value of PP after attack
			
					//create an integer variable called damage which measures the damage done on Player 1's HP based on P2's beforeAttack and afterAttack
					int damage = (beforeAttack - afterAttack);
					
					//subtract and save the damage done on Player 1's Pokemon HP
					player1.getPokemon().setHitPoints(player1.getPokemon().getHitPoints() - damage);
					System.out.println("Player 2 inflicted " + damage + " on " + player1.getPokemon().getName() + "!");
					System.out.println("Player 1's hp: " + player1.getPokemon().getHitPoints());
				}
				else if (randomInt4 == 2 ) { //computer player uses item
					 //check if has any more uses left
					if(compItemCount > 0) { //if yes, then use
						player2.getItem().use(player2.getPokemon());
						compItemCount--; //decrememnt counter
						System.out.println("Player 2 has "+ compItemCount + " more uses of " + player2.getItem());
					}else { //else no more uses, print statement
						System.out.println("Player 2 ran out of items!");
					}
				
				}
				else { //computer player runs away
					player2.run();
				}
				//increment counter
				counter+=1;
			
			}while(player1.getPokemon().getHitPoints() > 0 && player2.getPokemon().getHitPoints() > 0); //i.e. while neither one of pokemon have fainted
			
			if (player1.getPokemon().getHitPoints() < 0) {//user's pokemon has fainted, computer wins
				System.out.println("Oh no! " +player1.getPokemon().getName() + " has fainted...\nPlayer 2 wins...");
		
			}else if (player2.getPokemon().getHitPoints() < 0){//else computer's pokemon has fainted, user wins
				System.out.println("\nVictory! " +player2.getPokemon().getName() + " has fainted...\nPlayer 1 wins!");
			}
			
			//print statement to ask user if they would like to play again
			System.out.println("Would you like to play again?\nEnter \"Y\" for Yes, any other to quit game.");
	
			//scanner variable continueGame to take user input and continue the game after first battle
			Scanner continueGame = new Scanner(System.in);
			String continueKeyboard = continueGame.next().toUpperCase();
			
			if (continueKeyboard.compareTo("Y")==0) { continuePlaying = true; }
			else { 
				continuePlaying = false;
				System.out.println("Thanks for Playing!");
			}
			
		}while(continuePlaying);
		
	}//end main


}
