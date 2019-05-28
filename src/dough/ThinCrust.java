package dough;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import extra.Extra;
import type.Type;

@Component
@Scope("prototype")
public class ThinCrust implements Dough {

	@Autowired
	@Qualifier("vegetarian")
	private Type vegetarian;

	@Autowired
	@Qualifier("chicken")
	private Type chicken;

	@Autowired
	@Qualifier("pepperoni")
	private Type pepperoni;

	@Autowired
	@Qualifier("extraCheese")
	private Extra extraCheese;

	@Autowired
	@Qualifier("mushrooms")
	private Extra mushrooms;

	@Autowired
	@Qualifier("pineapple")
	private Extra pineapple;

	@Autowired
	@Qualifier("sausage")
	private Extra sausage;

	private @Value("${thincrust.price}") float price;

	private Type type;

	private List<Extra> extras = new ArrayList<Extra>();

	@Override
	public float CalculatePrice() {

		float price = this.price;

		price += type.getPrice();

		for (Extra extra : extras) {
			price += extra.getPrice();
		}
		return price;
	}

	@Override
	public void setVegetarianType() {
		this.type = vegetarian;
	}

	@Override
	public void setChickenType() {
		this.type = chicken;
	}

	@Override
	public void setPepperoniType() {
		this.type = pepperoni;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public void addExtraCheese() {
		extras.add(extraCheese);

	}

	@Override
	public void addMushrooms() {
		extras.add(mushrooms);

	}

	@Override
	public void addPineapple() {
		extras.add(pineapple);

	}

	@Override
	public void addSausage() {
		extras.add(sausage);

	}

	@Override
	public List<Extra> getExtras() {
		return this.extras;
	}

	@Override
	public void ClearExtras() {
		this.extras.clear();
	}

	@Override
	public String toString() {
		return "Thin Crust";
	}

}
