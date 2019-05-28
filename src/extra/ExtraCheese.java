package extra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExtraCheese implements Extra {

	@Value("${extracheese.price}")
	private float price;

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Extra Cheese";
	}

}
