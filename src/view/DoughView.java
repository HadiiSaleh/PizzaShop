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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.FontUIResource;

import presenter.ViewListener;

public class DoughView {

	// A list of listeners subscribed to this view
	private final ArrayList<ViewListener> listeners;

	public DoughView() {

		// frame options
		JFrame frame = new JFrame("Choose Dough");
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(249, 231, 159));
		frame.setBounds(0, 0, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		frame.setVisible(true);

		// background image
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setVerticalAlignment(SwingConstants.TOP);
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setIcon(new ImageIcon(DoughView.class.getResource("/images/So-You-Want-To-Start-A-Pizza-Shop.jpg")));

		// text field to enter number of pizza to create from the same dough,type and
		// extra topics
		JTextField NumberOfPizza = new JTextField();
		NumberOfPizza.setFont(new Font("Microsoft JhengHei", Font.BOLD, 24));
		NumberOfPizza.setHorizontalAlignment(SwingConstants.CENTER);
		NumberOfPizza.setColumns(10);

		// create ThinCrust pizza button
		JButton ChooseThinCrust = new JButton("Thin Crust");
		ChooseThinCrust.setForeground(new Color(255, 255, 255));
		ChooseThinCrust.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		ChooseThinCrust.setBackground(new Color(172, 74, 65));
		ChooseThinCrust.setContentAreaFilled(false);
		ChooseThinCrust.setOpaque(true);

		ChooseThinCrust.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(ChooseThinCrust.getText(), NumberOfPizza.getText());
				frame.dispose();

			}
		});

		// create Flat Bread pizza button
		JButton ChooseFlatBread = new JButton("FlatBread");
		ChooseFlatBread.setForeground(new Color(255, 255, 255));
		ChooseFlatBread.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		ChooseFlatBread.setBackground(new Color(172, 74, 65));
		ChooseFlatBread.setContentAreaFilled(false);
		ChooseFlatBread.setOpaque(true);

		ChooseFlatBread.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(ChooseFlatBread.getText(), NumberOfPizza.getText());
				frame.dispose();

			}
		});

		// Back to home page button
		JButton BackToHome = new JButton("Back");
		BackToHome.setForeground(new Color(255, 255, 255));
		BackToHome.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
		BackToHome.setBackground(Color.BLACK);
		BackToHome.setContentAreaFilled(false);
		BackToHome.setOpaque(true);

		BackToHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(BackToHome.getText(), NumberOfPizza.getText());
				frame.dispose();

			}
		});

		// text pane for the text field
		JTextPane txtNumberOfPizzas = new JTextPane();
		txtNumberOfPizzas.setEditable(false);
		txtNumberOfPizzas.setBackground(new Color(249, 231, 159));
		txtNumberOfPizzas.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
		txtNumberOfPizzas.setText("Number\r\nOf Pizzas");

		// Layout
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(ImageLabel, GroupLayout.PREFERRED_SIZE, 882, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(txtNumberOfPizzas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(NumberOfPizza, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(ChooseThinCrust, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE).addGap(193)
						.addComponent(ChooseFlatBread, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE).addGap(168))
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(BackToHome, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGap(789)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addComponent(ImageLabel)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(16)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(ChooseThinCrust, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(ChooseFlatBread, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(35)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(NumberOfPizza, Alignment.LEADING)
										.addComponent(txtNumberOfPizzas, Alignment.LEADING))))
				.addGap(2).addComponent(BackToHome, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		// add group layout to frame
		frame.getContentPane().setLayout(groupLayout);

		this.listeners = new ArrayList<ViewListener>();

		// pop up
		JPanel panel = new JPanel();
		panel.setBackground(new Color(172, 74, 65));
		panel.setSize(new Dimension(400, 120));
		panel.setLayout(null);
		JLabel label = new JLabel(
				"<html>Please Choose the Dough You Want<p style=\"text-align:center;\">Number Of Pizzas You Want Having:</p><p style=\"text-align:center;\">Same Dough,Type & Extras</p></html>");
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
	private void notifyListenersOnButtonClicked(String button, String text) {
		for (final ViewListener listener : listeners) {
			listener.getTextFieldValue(text);
			listener.onButtonClicked(button);
		}
	}

	// Subscribe a listener
	public void addListener(final ViewListener listener) {
		listeners.add(listener);
	}

}
