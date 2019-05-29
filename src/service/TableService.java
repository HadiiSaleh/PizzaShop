package service;

import java.util.List;

import org.springframework.stereotype.Component;

import dough.Dough;
import extra.Extra;
import model.Order;
import model.Pizza;

@Component
public class TableService {

	public String[][] PizzaToString(Order order) {

		List<Pizza> pizzas = order.getPizzas();

		List<Dough> doughs = order.getDoughs();

		String[][] result = new String[pizzas.size() + 1][9];

		for (int i = 0; i < pizzas.size(); i++) {

			Pizza pizza = pizzas.get(i);

			Dough dough = doughs.get(i);

			List<Extra> extras = dough.getExtras();

			// quantity of pizza
			result[i][0] = "" + pizza.getQuantity();

			// dough
			result[i][1] = dough.toString();

			// type

			result[i][2] = dough.getType().toString();

			// initialize extras to 0
			result[i][3] = "" + 0;

			result[i][4] = "" + 0;

			result[i][5] = "" + 0;

			result[i][6] = "" + 0;

			// add extras
			for (int j = 0; j < extras.size(); j++) {
				if (extras.get(j).toString().equals("Extra Cheese"))
					result[i][3] = "" + 1;
				if (extras.get(j).toString().equals("Mushrooms"))
					result[i][4] = "" + 1;
				if (extras.get(j).toString().equals("Sausage"))
					result[i][5] = "" + 1;
				if (extras.get(j).toString().equals("Pineapple"))
					result[i][6] = "" + 1;
			}

			result[i][7] = pizza.getPrice() + "$";

			result[i][8] = pizza.getTotal() + "$";
		}

		// total price
		result[pizzas.size()][0] = "";
		result[pizzas.size()][1] = "";
		result[pizzas.size()][2] = "";
		result[pizzas.size()][3] = "";
		result[pizzas.size()][4] = "";
		result[pizzas.size()][5] = "";
		result[pizzas.size()][6] = "Total";
		result[pizzas.size()][7] = "";
		result[pizzas.size()][8] = order.sum() + "$";
		return result;

	}

	public String[][] OrderToString(Order order) {

		List<Pizza> pizzas = order.getPizzas();

		String[][] result = new String[pizzas.size() + 1][9];

		for (int i = 0; i < pizzas.size(); i++) {

			Pizza pizza = pizzas.get(i);

			List<model.Extra> extras = pizza.getExtra();

			// quantity of pizza
			result[i][0] = "" + pizza.getQuantity();

			// dough
			result[i][1] = "" + pizza.getDoughti().getDough();

			// type

			result[i][2] = "" + pizza.getTypeti().getType();

			// initialize extras to 0
			result[i][3] = "" + 0;

			result[i][4] = "" + 0;

			result[i][5] = "" + 0;

			result[i][6] = "" + 0;

			// add extras
			for (int j = 0; j < extras.size(); j++) {
				if (extras.get(j).getExtra().equals("Extra Cheese"))
					result[i][3] = "" + 1;
				if (extras.get(j).getExtra().equals("Mushrooms"))
					result[i][4] = "" + 1;
				if (extras.get(j).getExtra().equals("Sausage"))
					result[i][5] = "" + 1;
				if (extras.get(j).getExtra().equals("Pineapple"))
					result[i][6] = "" + 1;
			}

			result[i][7] = pizza.getPrice() + "$";

			result[i][8] = pizza.getTotal() + "$";
		}

		// total price
		result[pizzas.size()][0] = "";
		result[pizzas.size()][1] = "";
		result[pizzas.size()][2] = "";
		result[pizzas.size()][3] = "";
		result[pizzas.size()][4] = "";
		result[pizzas.size()][5] = "";
		result[pizzas.size()][6] = "Total";
		result[pizzas.size()][7] = "";
		result[pizzas.size()][8] = order.sum() + "$";
		return result;

	}

}
