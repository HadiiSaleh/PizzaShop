package application;

import javax.swing.SwingUtilities;

import presenter.HomePresenter;
import view.HomeView;

public class Application {
	public Application() {

		final HomeView view = new HomeView();
		new HomePresenter(view);
	}

	public static void main(String[] args) {
		// read spring configuration java class
		org.springframework.context.annotation.AnnotationConfigApplicationContext context = new org.springframework.context.annotation.AnnotationConfigApplicationContext(
				PizzaConfig.class);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Application();
			}
		});
		// close the context
		context.close();

	}

}
