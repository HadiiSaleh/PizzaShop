package extra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mushrooms implements Extra {

	@Value("${mushrooms.price}")
	private float price;

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Mushrooms";
	}

}
