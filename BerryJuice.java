//Anastasia Golev Lab 4

/* public class BerryJuice has a method toString() and a method called use()
 * which takes a Pokemon p as parameter, and is meant to use the Berry Juice item
 * on the pokemon. Item Berry Juice restores the hitPoints of a Pokemon by 20 points.
 */

public class BerryJuice implements Item {

	//use() method will add 20 to a Pokemon's HP
	@Override
	public void use(Pokemon p) {
		//set HP to be getHitPoints + 20
		int newHitPoints = p.getHitPoints()+20;
		p.setHitPoints(newHitPoints);
		System.out.println(p.getName()+ " used Berry Juice. HP has increased to " + p.getHitPoints()); 
	}

	//toString() method
	public String toString() {
		String s = "";
		s += "Berry Juice";
		return s;
	}
}
