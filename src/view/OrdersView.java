package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Order;
import presenter.ViewListener;

public class OrdersView {

	// A list of listeners subscribed to this view
	private final ArrayList<ViewListener> listeners;

	public OrdersView() {
		// frame options
		JFrame frame = new JFrame("Orders List");
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(249, 231, 159));
		frame.setBounds(0, 0, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		frame.setVisible(true);

		// back to home view button
		JButton Back = new JButton("Back");
		Back.setForeground(Color.WHITE);
		Back.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
		Back.setBackground(Color.BLACK);
		Back.setContentAreaFilled(false);
		Back.setOpaque(true);

		Back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(Back.getText(), "brain");
				frame.dispose();
			}
		});

		// title
		JTextPane txtpnOrderesList = new JTextPane();
		txtpnOrderesList.setToolTipText("");
		txtpnOrderesList.setText("Orders List:");
		txtpnOrderesList.setForeground(Color.WHITE);
		txtpnOrderesList.setFont(new Font("Microsoft JhengHei", Font.BOLD, 29));
		txtpnOrderesList.setEditable(false);
		txtpnOrderesList.setBackground(new Color(172, 74, 65));
		StyledDocument doc = txtpnOrderesList.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		// get orders from database
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(model.Order.class)
				.addAnnotatedClass(model.Pizza.class).addAnnotatedClass(model.Extra.class)
				.addAnnotatedClass(model.Type.class).addAnnotatedClass(model.Dough.class).buildSessionFactory();

		try {
			Session session = factory.openSession();

			@SuppressWarnings("unchecked")
			List<Order> orders = session.createQuery("from Order o").getResultList();

			session.close();

			// Table to show orders

			String[] column = { "id", "date", "price" };

			String[][] data = new String[orders.size()][3];

			for (int i = 0; i < orders.size(); i++) {
				data[i][0] = "" + orders.get(i).getId();
				data[i][1] = orders.get(i).getDate().toString();
				data[i][2] = orders.get(i).getPrice() + " $";
			}

			JTable Orders = new JTable(data, column) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				};
			};
			Orders.setForeground(Color.WHITE);
			Orders.setBackground(new Color(172, 74, 65));
			Orders.setBorder(UIManager.getBorder("Button.border"));
			Orders.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
			Orders.setRowHeight(30);
			Orders.getColumnModel().getColumn(0).setPreferredWidth(10);

			// show details button
			JButton Details = new JButton("Details");
			Details.setForeground(Color.WHITE);
			Details.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
			Details.setBackground(Color.BLACK);
			Details.setContentAreaFilled(false);
			Details.setOpaque(true);

			Details.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {

					int row = Orders.getSelectedRow();
					if (row >= 0) {
						String value = Orders.getModel().getValueAt(row, 0).toString();
						notifyListenersOnButtonClicked(Details.getText(), value);
						frame.dispose();
					}
				}
			});

			// Scroll pane
			JScrollPane scrollPane = new JScrollPane(Orders);
			scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 4));
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			this.listeners = new ArrayList<ViewListener>();

			// Layout
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Back, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE).addGap(275)
							.addComponent(Details, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE).addGap(400))
					.addGroup(groupLayout.createSequentialGroup().addGap(27)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE).addGap(30))
					.addGroup(groupLayout.createSequentialGroup().addGap(225)
							.addComponent(txtpnOrderesList, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
							.addGap(226)));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(txtpnOrderesList, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(18).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(Details,
									GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
							.addComponent(Back, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(20, Short.MAX_VALUE)));

			// add group layout to frame
			frame.getContentPane().setLayout(groupLayout);

		} finally {
			factory.close();
		}

	}

	// Iterate through the list, notifying each listener individual
	private void notifyListenersOnButtonClicked(String button, String id) {
		for (final ViewListener listener : listeners) {
			if (!id.equals("brain"))
				listener.getRowId(id);
			listener.onButtonClicked(button);
		}
	}

	// Subscribe a listener
	public void addListener(final ViewListener listener) {
		listeners.add(listener);
	}
}
