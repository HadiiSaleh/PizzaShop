package view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrdersView {

	private org.springframework.context.annotation.AnnotationConfigApplicationContext context;
	
	public OrdersView(AnnotationConfigApplicationContext context) {
		this.context=context;
	}

}
