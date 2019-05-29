package model;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name = "pizzas")
public class Pizza {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Transient
	private int dough_id;

	@ManyToOne
	@JoinColumn(name = "dough")
	private Dough dough;

	@ManyToOne
	@JoinColumn(name = "type")
	private Type type;

	@Transient
	private int type_id;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;

	@Column(name = "total")
	private float total;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "order_pizza", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Order> orders;

	@ManyToMany(targetEntity = model.Extra.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "pizza_extra", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "extra_id"))
	private List<model.Extra> extra;

	public Pizza() {

	}

	public Pizza(int dough_id, int type_id, int quantity, float price) {
		super();
		this.dough_id = dough_id;
		this.type_id = type_id;
		this.quantity = quantity;
		this.price = price;
	}

	public List<model.Extra> getExtra() {
		return extra;
	}

	public void setExtra(List<model.Extra> extra) {
		this.extra = extra;
	}

	public void addExtra(model.Extra extra) {
		if (this.extra == null)
			this.extra = new ArrayList<>();
		this.extra.add(extra);
	}

	public Dough getDoughti() {
		return dough;
	}

	public void setDoughti(Dough dough) {
		this.dough = dough;
	}

	public Type getTypeti() {
		return type;
	}

	public void setTypeti(Type type) {
		this.type = type;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDough() {
		return dough_id;
	}

	public void setDough(int dough_id) {
		this.dough_id = dough_id;
	}

	public int getType() {
		return type_id;
	}

	public void setType(int type_id) {
		this.type_id = type_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order order) {
		if (this.orders == null)
			orders = new ArrayList<>();
		orders.add(order);
	}

	public float calculateTotal() {
		this.total = this.price * this.quantity;
		return this.total;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", dough=" + dough.getId() + ", type=" + type.getId() + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

}
