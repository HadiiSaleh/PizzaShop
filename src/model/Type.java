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
@Table(name = "types")
public class Type {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "type")
	private String type;

	@OneToMany(mappedBy = "type")
	private List<Pizza> pizzas;

	public Type() {

	}

	public Type(String type) {
		this.type = type;
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
		pizza.setTypeti(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "type [id=" + id + ", type=" + type + "]";
	}

}
