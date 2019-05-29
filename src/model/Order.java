package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import dough.Dough;

@Component
@Scope("prototype")
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "price")
	private float price;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "order_pizza", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizzas;

	@Transient
	private ArrayList<Dough> doughs;

	public Order() {
		this.pizzas = new ArrayList<Pizza>();
		this.doughs = new ArrayList<Dough>();
	}

	public Order(LocalDate date, float price) {
		super();
		this.date = date;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public void AddPizza(Pizza pizza) {
		if (pizzas == null)
			pizzas = new ArrayList<>();
		this.pizzas.add(pizza);
	}

	public ArrayList<Dough> getDoughs() {
		return doughs;
	}

	public void setDoughs(ArrayList<Dough> doughts) {
		this.doughs = doughts;
	}

	public void AddDough(Dough d) {
		this.doughs.add(d);
	}

	public float sum() {

		float price = 0;

		for (Pizza pizza : pizzas) {
			price += pizza.getTotal();
		}

		return price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", price=" + price + "]";
	}
}