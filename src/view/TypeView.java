package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.FontUIResource;

import presenter.ViewListener;

public class TypeView {

	// A list of listeners subscribed to this view
	private final ArrayList<ViewListener> listeners;

	public TypeView() {
		/// frame options
		JFrame frame = new JFrame("Choose Type");
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(249, 231, 159));
		frame.setBounds(0, 0, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		frame.setVisible(true);

		// background image
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setVerticalAlignment(SwingConstants.TOP);
		ImageLabel.setIcon(new ImageIcon(TypeView.class.getResource("/images/So-You-Want-To-Start-A-Pizza-Shop.jpg")));

		// back to choose dough button
		JButton BackToDough = new JButton("Back");
		BackToDough.setForeground(Color.WHITE);
		BackToDough.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
		BackToDough.setBackground(Color.BLACK);
		BackToDough.setContentAreaFilled(false);
		BackToDough.setOpaque(true);

		BackToDough.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(BackToDough.getText());
				frame.dispose();

			}
		});

		// choose vegetarian pizza button
		JButton Vegetarian = new JButton("<html>Vegetarian<p style=\"text-align:center;\">8$</p></html>");
		Vegetarian.setForeground(Color.WHITE);
		Vegetarian.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		Vegetarian.setBackground(new Color(172, 74, 65));
		Vegetarian.setContentAreaFilled(false);
		Vegetarian.setOpaque(true);

		Vegetarian.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(Vegetarian.getText());
				frame.dispose();

			}
		});

		// choose pepperoni pizza button
		JButton Pepperoni = new JButton("<html>Pepperoni<p style=\"text-align:center;\">9$</p></html>");
		Pepperoni.setForeground(Color.WHITE);
		Pepperoni.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		Pepperoni.setBackground(new Color(172, 74, 65));
		Pepperoni.setContentAreaFilled(false);
		Pepperoni.setOpaque(true);

		Pepperoni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(Pepperoni.getText());
				frame.dispose();

			}
		});

		// choose chicken pizza button
		JButton Chicken = new JButton("<html>Chicken<p style=\"text-align:center;\">10$</p></html>");
		Chicken.setForeground(Color.WHITE);
		Chicken.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		Chicken.setBackground(new Color(172, 74, 65));
		Chicken.setContentAreaFilled(false);
		Chicken.setOpaque(true);

		Chicken.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(Chicken.getText());
				frame.dispose();

			}
		});

		// Layout
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(ImageLabel, GroupLayout.PREFERRED_SIZE, 882, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addGap(64)
						.addComponent(Vegetarian, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addGap(84)
						.addComponent(Pepperoni, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addGap(94)
						.addComponent(Chicken, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE).addGap(71))
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(BackToDough, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addComponent(ImageLabel)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Vegetarian, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(Pepperoni, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(Chicken, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGap(5).addComponent(BackToDough, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		// add group layout to frame
		frame.getContentPane().setLayout(groupLayout);

		this.listeners = new ArrayList<ViewListener>();

		// pop up
		JPanel panel = new JPanel();
		panel.setBackground(new Color(172, 74, 65));
		panel.setSize(new Dimension(400, 120));
		panel.setLayout(null);
		JLabel label = new JLabel("Please Choose the type You Want");
		label.setBounds(0, 0, 600, 120);
		label.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		UIManager.put("OptionPane.minimumSize", new Dimension(620, 200));
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft JhengHei UI", Font.BOLD, 25)));
		UIManager.put("Button.background", Color.white);
		JOptionPane.showMessageDialog(frame, panel, "Choose the Dough", JOptionPane.PLAIN_MESSAGE);
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
