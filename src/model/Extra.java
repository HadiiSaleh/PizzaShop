package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "extras")
public class Extra {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "extra")
	private String extra;

	@ManyToMany(targetEntity = Pizza.class, fetch = FetchType.LAZY)
	@JoinTable(name = "pizza_extra", joinColumns = @JoinColumn(name = "extra_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizzas;

	public Extra() {

	}

	public Extra(String extra) {
		this.extra = extra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
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
		this.pizzas.add(pizza);
	}

	@Override
	public String toString() {
		return "Extra [id=" + id + ", extra=" + extra + "]";
	}

}
