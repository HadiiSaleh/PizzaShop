package dough;

import java.util.List;

import extra.Extra;
import type.Type;

public interface Dough {

	public float CalculatePrice();

	public Type getType();

	public void setVegetarianType();

	public void setChickenType();

	public void setPepperoniType();

	public void addExtraCheese();

	public void addMushrooms();

	public void addPineapple();

	public void addSausage();

	public List<Extra> getExtras();

	public void ClearExtras();

	public String toString();
}
