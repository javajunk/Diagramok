package menutest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class asd {

	public static void main(String[] args) {
		final MenuPanel panel = new MenuPanel(new ImageIcon("argvarg.jpg").getImage());
		final MenuPanel panel2 = new MenuPanel(new ImageIcon("argvarg2.jpg").getImage());
		
		final JFrame frame = new JFrame();
		
		//változtatás aergbaerbaerhar
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		CustomButton button = new CustomButton(new ImageIcon("asd.png").getImage());
		button.setContentAreaFilled(false);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				frame.getContentPane().remove(panel);
				frame.getContentPane().add(panel2);
				panel2.setVisible(true);
				frame.pack();
			}
		});
		CustomButton button2 = new CustomButton(new ImageIcon("asd.png").getImage());
		button2.setContentAreaFilled(false);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.setVisible(false);
				frame.getContentPane().remove(panel2);
				frame.getContentPane().add(panel);
				panel.setVisible(true);
				frame.pack();
			}
		});
		panel.add(button);
		panel2.add(button2);
		
		frame.pack();
		frame.setVisible(true);

	}

}
