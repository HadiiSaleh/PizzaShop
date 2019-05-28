package type;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Chicken implements Type {

	@Value("${chicken.price}")
	private float price;

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Chicken";
	}

}
