import java.io.*;

 public abstract class Pizza implements Closeable
 {
	private String name = "";
	private float price;
	public Pizza(final String name, final float price)
	{
		this.name = name;
		this.price = price;
	}
	public void close()
	{
	}

	public float getPrice()
	{
		return price;
	}
	public String getName()
	{
		return name;
	}
	public abstract void bake();
 }

// CheesePizza is a type of Pizza
public class CheesePizza extends Pizza
{
	public CheesePizza()
	{
		super("Cheese", 100F);
	}
	public final void close()
	{
		super.close();
	}

	@Override
	public final void bake()
	{
		System.out.print("Baking ");
		System.out.print(getName());
		System.out.print(" Pizza.");
		System.out.print("\n");
	}
}

// MexicanPizza is a type of Pizza
public class MexicanPizza extends Pizza
{
	public MexicanPizza()
	{
		super("Mexican", 200F);
	}
	public final void close()
	{
		super.close();
	}

	@Override
	public final void bake()
	{
		System.out.print("Baking ");
		System.out.print(getName());
		System.out.print(" Pizza.");
		System.out.print("\n");
	}
}

// Below class is a decorator or wrapper for Pizza
public class PizzaToppings extends Pizza
{
	// Here we store the reference
	private Pizza pizza;
	// Constructor
	public PizzaToppings(final String toppingName, final float price, Pizza pizza)
	{
		super(toppingName, price);
		this.pizza = new Pizza(pizza);
	}
	public void close()
	{
		super.close();
	}

	// Call our wrapper object's functions
	@Override
	public float getPrice()
	{
		return pizza.getPrice();
	}
	@Override
	public String getName()
	{
		return pizza.getName();
	}
	@Override
	public void bake()
	{
		pizza.bake();
	}
}

public class ExtraCheeseTopping extends PizzaToppings
{
	private void addExtraCheeseToPizza()
	{
		System.out.print("Added extra cheese to the pizza: [");
		System.out.print(super.getName());
		System.out.print("].");
		System.out.print("\n");
	}
	public ExtraCheeseTopping(Pizza pizza)
	{
		super("ExtraCheeseTopping", 10F, pizza);
	}
	public final void close()
	{
		super.close();
	}

	@Override
	public float getPrice()
	{
		return super.getPrice() + super.getPrice();
	}
	@Override
	public String getName()
	{
		return super.getName();
	}

	// Call our wrapper object's function
	@Override
	public void bake()
	{
		addExtraCheeseToPizza();
		super.bake();
	}
}

public class BroccoliTopping extends PizzaToppings
{
	private void addBroccoliToPizza()
	{
		System.out.print("Added Broccoli to the pizza: [");
		System.out.print(super.getName());
		System.out.print("].");
		System.out.print("\n");
	}
	public BroccoliTopping(Pizza pizza)
	{
		super("BroccoliTopping", 15F, pizza);
	}
	public final void close()
	{
		super.close();
	}

	@Override
	public float getPrice()
	{
		return super.getPrice() + super.getPrice();
	}
	@Override
	public String getName()
	{
		return super.getName();
	}

	// Call our wrapper object's function
	@Override
	public void bake()
	{
		addBroccoliToPizza();
		super.bake();
	}
}

package <missing>;

public class GlobalMembers
{
	public static void main(String[] args)
	{
		// Create MexicanPizza
		Pizza pizza = new MexicanPizza();

		// Add ExtraCheeseTopping
		ExtraCheeseTopping mexicanPizzaWithExtraCheeseTopping = new ExtraCheeseTopping(pizza);

		// Now bake
		mexicanPizzaWithExtraCheeseTopping.bake();

		System.out.print("Total price: ");
		System.out.print(mexicanPizzaWithExtraCheeseTopping.getPrice());
		System.out.print("\n");

	}
}