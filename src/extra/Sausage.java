package extra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sausage implements Extra {

	@Value("${sausage.price}")
	private float price;

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Sausage";
	}
}
