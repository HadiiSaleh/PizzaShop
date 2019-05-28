package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import model.Order;
import presenter.ViewListener;
import service.TableService;

public class FinalOrder {

	// A list of listeners subscribed to this view
	private final ArrayList<ViewListener> listeners;

	@SuppressWarnings("unused")
	private Order order;

	private TableService tableService;

	public FinalOrder(Order order, TableService tableService) {

		this.tableService = tableService;
		this.order = order;
		// frame options
		JFrame frame = new JFrame("Final Order");
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(249, 231, 159));
		frame.setBounds(0, 0, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		frame.setVisible(true);

		// Back to choose extra topics Button
		JButton BackToExtra = new JButton("Back");

		BackToExtra.setForeground(Color.WHITE);
		BackToExtra.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
		BackToExtra.setBackground(Color.BLACK);
		BackToExtra.setContentAreaFilled(false);
		BackToExtra.setOpaque(true);

		BackToExtra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(BackToExtra.getText());
				frame.dispose();
			}
		});

		// Finish Button
		JButton Finish = new JButton("Finish");

		Finish.setForeground(Color.WHITE);
		Finish.setFont(new Font("Microsoft JhengHei", Font.BOLD, 26));
		Finish.setBackground(new Color(172, 74, 65));
		Finish.setContentAreaFilled(false);
		Finish.setOpaque(true);

		Finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(Finish.getText());
				frame.dispose();
			}
		});

		// Add more pizza to order Button
		JButton MorePizza = new JButton("Add More Pizzas");

		MorePizza.setForeground(Color.WHITE);
		MorePizza.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		MorePizza.setBackground(Color.BLACK);
		MorePizza.setContentAreaFilled(false);
		MorePizza.setOpaque(true);

		MorePizza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(MorePizza.getText());
				frame.dispose();
			}
		});

		// Table to show ordered pizza
		String[] column = { "Num", "Dough", "Type", "ExtraCheese", "Mushrooms", "Sausage", "Pineapple", "Price",
				"Total" };
		String[][] data = this.tableService.PizzaToString(order);

		JTable Pizzas = new JTable(data, column) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		Pizzas.setForeground(Color.WHITE);
		Pizzas.setBackground(new Color(172, 74, 65));
		Pizzas.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
		Pizzas.setRowHeight(30);

		// Scroll pane
		JScrollPane scrollPane = new JScrollPane(Pizzas);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 4));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Title
		JTextPane txtpnPizzasOrdered = new JTextPane();
		txtpnPizzasOrdered.setEditable(false);
		txtpnPizzasOrdered.setToolTipText("");
		txtpnPizzasOrdered.setFont(new Font("Microsoft JhengHei", Font.BOLD, 29));
		txtpnPizzasOrdered.setForeground(Color.WHITE);
		txtpnPizzasOrdered.setBackground(new Color(172, 74, 65));
		txtpnPizzasOrdered.setText("Pizzas Ordered:");
		StyledDocument doc = txtpnPizzasOrdered.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		this.listeners = new ArrayList<ViewListener>();

		// Layout
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(209)
						.addComponent(txtpnPizzasOrdered, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE).addGap(242))
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(BackToExtra, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE).addGap(255)
						.addComponent(Finish, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE).addGap(107)
						.addComponent(MorePizza, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE).addGap(45))
				.addGroup(groupLayout.createSequentialGroup().addGap(35)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE).addGap(29)));

		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(txtpnPizzasOrdered, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Finish, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(MorePizza, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(BackToExtra, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));

		// add group layout to frame
		frame.getContentPane().setLayout(groupLayout);
	}

	// Iterate through the list, notifying each listener individual
	private void notifyListenersOnButtonClicked(String button) {
		for (final ViewListener listener : listeners) {
			listener.onButtonClicked(button);
		}
	}

	// Subscribe a listener
	public void addListener(final ViewListener listener) {
		listeners.add(listener);
	}

}
