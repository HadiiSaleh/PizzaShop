package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import extra.Extra;

@Component
@Scope("prototype")
@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "dough")
	private int dough;

	@Column(name = "type")
	private int type;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;

	@Column(name = "total")
	private float total;

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	// ManyToMany relationship
	private List<Order> orders;

	// ManyToMany relationship
	private List<Extra> extras;

	public Pizza() {
		
	}
	
	public Pizza(int dough, int type, int quantity, float price) {
		super();
		this.dough = dough;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDough() {
		return dough;
	}

	public void setDough(int dough) {
		this.dough = dough;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public List<Extra> getExtras() {
		return extras;
	}

	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}

	public float calculateTotal() {
		this.total = this.price * this.quantity;
		return this.total;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", dough=" + dough + ", type=" + type + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}

}
