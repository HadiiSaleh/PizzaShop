package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import dough.Dough;

@Component
@Scope("prototype")
@Entity
@Table(name = "order")
public class Order {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "price")
	private float price;

	// ManyToMany relationship
	private List<Pizza> pizzas;

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