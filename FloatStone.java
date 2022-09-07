//Anastasia Golev  Lab4 

/* public class FloatStone implements the Item interface. Its purpose as an item
 * is to reduce the weight of a Pokemon when held. The method use() will print out
 * a generic statement when this item is used.
 */
public class FloatStone implements Item {


	//use() method will print a statement letting the Player know that their Pokemon now weighs lighter
	@Override
	public void use(Pokemon p) {
		// TODO Auto-generated method stub
		System.out.println("Pokemon weighs a little lighter with the help of FloatStone!");
	}//end use() method

	//toString() method
	public String toString() {
		String s = "";
		s += "FloatStone";
		return s;
	}//end toString() method
}
