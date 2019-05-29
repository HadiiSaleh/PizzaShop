package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doughs")
public class Dough {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "dough")
	private String dough;

	@OneToMany(mappedBy = "dough")
	private List<Pizza> pizzas;

	public Dough() {

	}

	public Dough(String dough) {
		this.dough = dough;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public void addPizza(Pizza pizza) {
		if (pizzas == null)
			pizzas = new ArrayList<>();
		pizzas.add(pizza);
		pizza.setDoughti(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDough() {
		return dough;
	}

	public void setDough(String dough) {
		this.dough = dough;
	}

	@Override
	public String toString() {
		return "dough [id=" + id + ", dough=" + dough + "]";
	}

}
