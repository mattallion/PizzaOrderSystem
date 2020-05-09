import java.io.Serializable;
/**
 * This class constructs Pizza objects, calculates their costs, and can return a string type of the order.
 * This class can also test for equality of attributes between Pizza objects and clone/recreate a Pizza.
 * 
 * @author Matthew
 * @see IllegalPizza
 */
public final class Pizza implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	
	private final String size;
	private final String cheese;
	private final String pineapple;
	private final String greenPepper;
	private final String ham;
	/**
	 * This constructor takes parameters and makes a Pizza object.
	 * If the parameters used result in the construction of an illegal Pizza object,
	 * the IllegalPizza exception is thrown.
	 * 
	 * @param sizeIn The size of the Pizza object in String type.
	 * @param cheeseIn The amount of cheese on the Pizza object in String type.
	 * @param pineappleIn Whether or not there is pineapple on the Pizza object in String type.
	 * @param greenPepperIn Whether or not there are green peppers on the Pizza object in String type.
	 * @param hamIn Whether or not there is ham on the Pizza object in String type.
	 * @throws IllegalPizza If an illegal Pizza object is made according to the rules outlined in the assignment.
	 * @see IllegalPizza
	 */
	public Pizza(final String sizeIn, final String cheeseIn, final String pineappleIn, final String greenPepperIn, final String hamIn) throws IllegalPizza {
		this.size = sizeIn;
		this.cheese = cheeseIn;
		this.pineapple = pineappleIn;
		this.greenPepper = greenPepperIn;
		this.ham = hamIn;
		
		int sCount = 0;
		int cCount = 0;
		int pCount = 0;
		int gCount = 0;
		int hCount = 0;
		int prefCount = 0;
		
		if (this.size != "small")
			sCount ++;
		if (this.size != "medium")
			sCount ++;
		if (this.size != "large")
			sCount ++;
		if (sCount == 3)
			throw new IllegalPizza();
		
		if (this.cheese != "single")
			cCount ++;
		if (this.cheese != "double")
			cCount ++;
		if (this.cheese != "triple")
			cCount ++;
		if (cCount == 3)
			throw new IllegalPizza();
		
		if (this.pineapple != "none")
			pCount ++;
		if (this.pineapple != "single")
			pCount ++;
		if (pCount == 2)
			throw new IllegalPizza();
		
		if (this.greenPepper != "none")
			gCount ++;
		if (this.greenPepper != "single")
			gCount ++;
		if (gCount == 2)
			throw new IllegalPizza();
		
		if (this.ham != "none")
			hCount ++;
		if (this.ham != "single")
			hCount ++;
		if (hCount == 2)
			throw new IllegalPizza();
		
		if (this.pineapple == "single")
			prefCount ++;
		if (this.greenPepper == "single")
			prefCount ++;
		if (prefCount > 0 && ham != "single")
			throw new IllegalPizza();
	}
	/**
	 * Constructs a default small, single cheese Pizza object with ham.
	 */
	public Pizza() {
		this.size = "small";
		this.cheese = "single";
		this.pineapple = "none";
		this.greenPepper = "none";
		this.ham = "single";
	}
	/**
	 * Finds the float unit cost of the Pizza object identified.
	 * This method uses if statements and increment operators
	 * to tabulate the cost of the order based on the assignment instructions.
	 * @return The float unit cost of the Pizza object.
	 */
	public float getCost() {
		float unitCost = 0.00f;
		if (this.size == "small")
			unitCost += 7.00f;
		if (this.size == "medium")
			unitCost += 9.00f;
		if (this.size == "large")
			unitCost += 11.00f;
		if (this.cheese == "double")
			unitCost += 1.50f;
		if (this.cheese == "triple")
			unitCost += 3.00f;
		if (this.pineapple == "single")
			unitCost += 1.50f;
		if (this.greenPepper == "single")
			unitCost += 1.50f;
		if (this.ham == "single")
			unitCost += 1.50f;
		return unitCost;		
	}
	/**
	 * Generates a string type of the pizza order.
	 * Finds the cost from getCost() method.
	 * This method generates a string that combines the Pizza object's attributes and its unit cost.
	 * @return The string type of the pizza order.
	 * @see #getCost() getCost
	 */
	public String toString() {
		final float unitCost = getCost();
		String pizzaString = null;
		String pineappleString = null;
		String greenPepperString = null;
		String hamString = null;
		if(this.pineapple == "single")
			pineappleString = ", pineapple";
		else
			pineappleString = "";
		if(this.greenPepper == "single")
			greenPepperString = ", green pepper";
		else
			greenPepperString = "";
		if(this.ham == "single")
			hamString = ", ham";
		else
			hamString = "";
		pizzaString = this.size+" pizza, "+this.cheese+" cheese"+pineappleString+greenPepperString+hamString+"."+" Cost: "+unitCost+" each.";
		return pizzaString;
	}
	/**
	 * Tests the equality of two Pizza objects and returns the result.
	 * Uses if statements to test the equality of each attribute within the Pizza objects being tested.
	 * @param pizza2 One of the Pizza objects that is tested for equality.
	 * @return If the Pizza objects are equal, true. If the Pizza objects are not equal, false.
	 */
	public boolean equals(final Pizza pizza2) {
		int truthCount = 0;
		if (this.size == pizza2.size)
			truthCount ++;
		if (this.cheese == pizza2.cheese)
			truthCount ++;
		if (this.pineapple == pizza2.pineapple)
			truthCount ++;
		if (this.greenPepper == pizza2.greenPepper)
			truthCount ++;
		if (this.ham == pizza2.ham)
			truthCount ++;
		if (truthCount == 5)
			return true;
		else 
			return false;
	}
	/**
	 * Generates a clone version of the Pizza object.
	 * Uses Pizza() to construct an identical Pizza object.
	 * If the Pizza object constructed is an illegal Pizza object, the IllegalPizza exception is caught in this method.
	 * @return Returns the clone Pizza object.
	 * @see #Pizza() Pizza
	 * @see IllegalPizza
	 */
	public Pizza clone() {
		Pizza pizza1 = null;
		try {
			pizza1 = new Pizza(size, cheese, pineapple, greenPepper, ham);
		} catch (final IllegalPizza e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pizza1;
	}

}