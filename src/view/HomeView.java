package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

import presenter.ViewListener;

public class HomeView {

	// A list of listeners subscribed to this view
	private final ArrayList<ViewListener> listeners;

	public HomeView() {

		// frame options
		JFrame frame = new JFrame("Pizza Shop");
		frame.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(249, 231, 159));
		frame.setBounds(0, 0, 900, 700);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		// Background image
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setVerticalAlignment(SwingConstants.TOP);
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setIcon(new ImageIcon(HomeView.class.getResource("/images/So-You-Want-To-Start-A-Pizza-Shop.jpg")));
		ImageLabel.setBounds(-252, 0, 1400, 480);

		// show orders history button
		JButton ShowOrdersButton = new JButton("Show Orders");
		ShowOrdersButton.setForeground(new Color(255, 255, 255));
		ShowOrdersButton.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		ShowOrdersButton.setBackground(new Color(172, 74, 65));
		ShowOrdersButton.setContentAreaFilled(false);
		ShowOrdersButton.setOpaque(true);
		ShowOrdersButton.setBounds(295, 521, 300, 60);

		ShowOrdersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(ShowOrdersButton.getText());
				frame.dispose();
				//close(frame);
			}
		});

		// create new order button
		JButton OrderButton = new JButton("Order Pizza");
		OrderButton.setForeground(new Color(255, 255, 255));
		OrderButton.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		OrderButton.setBackground(new Color(249, 231, 159));
		OrderButton.setContentAreaFilled(false);
		OrderButton.setOpaque(true);
		OrderButton.setBounds(295, 380, 300, 60);

		OrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				notifyListenersOnButtonClicked(OrderButton.getText());
				frame.dispose();
				//close(frame);
			}
		});

		// Layout
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(295)
						.addComponent(OrderButton, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE).addGap(287))
				.addGroup(groupLayout.createSequentialGroup().addGap(295)
						.addComponent(ShowOrdersButton, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE).addGap(287))
				.addComponent(ImageLabel, GroupLayout.PREFERRED_SIZE, 882, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(380)
						.addComponent(OrderButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(81)
						.addComponent(ShowOrdersButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
				.addComponent(ImageLabel, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE));

		// add group layout to frame
		frame.getContentPane().setLayout(groupLayout);

		this.listeners = new ArrayList<ViewListener>();

		frame.setVisible(true);
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

	public void close(JFrame frame) {
		WindowEvent winClosingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

}
