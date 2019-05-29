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

public class ExtraView {

	// A list of listeners subscribed to this view
	private final ArrayList<ViewListener> listeners;

	public ExtraView() {
		JFrame frame = new JFrame("Choose Extras");
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
		ImageLabel.setIcon(new ImageIcon(ExtraView.class.getResource("/images/So-You-Want-To-Start-A-Pizza-Shop.jpg")));

		// back to choose type button
		JButton BackToType = new JButton("Back");
		BackToType.setForeground(Color.WHITE);
		BackToType.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
		BackToType.setBackground(Color.BLACK);
		BackToType.setContentAreaFilled(false);
		BackToType.setOpaque(true);

		BackToType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(BackToType.getText());
				frame.dispose();
			}
		});

		// add extra cheese button
		JButton ExtraCheese = new JButton("<html>ExtraCheese<p style=\"text-align:center;\">2$</p></html>");
		ExtraCheese.setForeground(Color.WHITE);
		ExtraCheese.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 26));
		ExtraCheese.setBackground(new Color(172, 74, 65));
		ExtraCheese.setContentAreaFilled(false);
		ExtraCheese.setOpaque(true);

		ExtraCheese.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				JButton source = (JButton) e.getSource();
				source.setEnabled(false);
				notifyListenersOnButtonClicked(ExtraCheese.getText());
			}
		});

		// add mushrooms button
		JButton Mushrooms = new JButton("<html>Mushrooms<p style=\"text-align:center;\">1$</p></html>");
		Mushrooms.setForeground(Color.WHITE);
		Mushrooms.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 26));
		Mushrooms.setBackground(new Color(172, 74, 65));
		Mushrooms.setContentAreaFilled(false);
		Mushrooms.setOpaque(true);

		Mushrooms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				JButton source = (JButton) e.getSource();
				source.setEnabled(false);
				notifyListenersOnButtonClicked(Mushrooms.getText());
			}
		});
		// add sausage button
		JButton Sausage = new JButton("<html>Sausage<p style=\"text-align:center;\">2$</p></html>");
		Sausage.setForeground(Color.WHITE);
		Sausage.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 26));
		Sausage.setBackground(new Color(172, 74, 65));
		Sausage.setContentAreaFilled(false);
		Sausage.setOpaque(true);

		Sausage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				JButton source = (JButton) e.getSource();
				source.setEnabled(false);
				notifyListenersOnButtonClicked(Sausage.getText());
			}
		});

		// add pineapple button
		JButton Pineapple = new JButton("<html>Pineapple<p style=\"text-align:center;\">2$</p></html>");
		Pineapple.setForeground(Color.WHITE);
		Pineapple.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 26));
		Pineapple.setBackground(new Color(172, 74, 65));
		Pineapple.setContentAreaFilled(false);
		Pineapple.setOpaque(true);

		Pineapple.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				JButton source = (JButton) e.getSource();
				source.setEnabled(false);
				notifyListenersOnButtonClicked(Pineapple.getText());
			}
		});

		// view the current order button
		JButton FinalOrder = new JButton("View Order");
		FinalOrder.setForeground(Color.WHITE);
		FinalOrder.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
		FinalOrder.setBackground(Color.DARK_GRAY);
		FinalOrder.setContentAreaFilled(false);
		FinalOrder.setOpaque(true);

		FinalOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(FinalOrder.getText());
				frame.dispose();

			}
		});

		// Layout
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(ImageLabel, GroupLayout.PREFERRED_SIZE, 914, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addGap(36)
								.addComponent(ExtraCheese, GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE).addGap(18)
								.addComponent(Mushrooms, GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE).addGap(18)
								.addComponent(Sausage, GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE).addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(BackToType, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE).addGap(275)
								.addComponent(FinalOrder, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE).addGap(145)))
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(Pineapple, GroupLayout.PREFERRED_SIZE, 190,
														Short.MAX_VALUE)
												.addGap(64))
										.addGroup(groupLayout.createSequentialGroup().addGap(10)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addComponent(ImageLabel).addGap(13)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Mushrooms, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(Sausage, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(ExtraCheese, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(Pineapple, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(FinalOrder,
										GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
								.addComponent(BackToType, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(20, Short.MAX_VALUE)));

		// add group layout to frame
		frame.getContentPane().setLayout(groupLayout);

		this.listeners = new ArrayList<ViewListener>();

		// pop up
		JPanel panel = new JPanel();
		panel.setBackground(new Color(172, 74, 65));
		panel.setSize(new Dimension(400, 120));
		panel.setLayout(null);
		JLabel label = new JLabel(
				"<html>Please Choose Extra Toppings You Want<br><p style=\"text-align:center;\">You Can Add More Than One Extra</p><p style=\"text-align:center;\">Each Extra One Time</p></html>");
		label.setBounds(0, 0, 600, 130);
		label.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		UIManager.put("OptionPane.minimumSize", new Dimension(620, 200));
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Microsoft JhengHei UI", Font.BOLD, 25)));
		UIManager.put("Button.background", Color.white);
		JOptionPane.showMessageDialog(frame, panel, "Choose extra topics", JOptionPane.PLAIN_MESSAGE);
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
