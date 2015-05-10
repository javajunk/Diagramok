package GUI;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MainMenu extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 480716668726574016L;
	private static MainMenu instance = new MainMenu();

	private String defaultGameTime = "180";
	
	public static MainMenu getInstance()
	{
		return instance;
	}
	
	private JTextField gameTime_tf;

	/**
	 * Create the panel.
	 */
	protected MainMenu() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel container = new JPanel();
		GridBagConstraints gbc_container = new GridBagConstraints();
		gbc_container.gridx = 0;
		gbc_container.gridy = 0;
		add(container, gbc_container);
		GridBagLayout gbl_container = new GridBagLayout();
		gbl_container.columnWidths = new int[]{10, 0};
		gbl_container.rowHeights = new int[]{10, 0, 0, 0};
		gbl_container.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_container.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		container.setLayout(gbl_container);
		
		JButton newGame_btn = new JButton("Új játék");
		newGame_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.getInstance().StartGame(Integer.parseInt(gameTime_tf.getText()));
			}
		});
		
		GridBagConstraints gbc_newGame_btn = new GridBagConstraints();
		gbc_newGame_btn.insets = new Insets(0, 0, 5, 0);
		gbc_newGame_btn.fill = GridBagConstraints.BOTH;
		gbc_newGame_btn.gridx = 0;
		gbc_newGame_btn.gridy = 0;
		container.add(newGame_btn, gbc_newGame_btn);
		
		JPanel gameTime_pnl = new JPanel();
		GridBagConstraints gbc_gameTime_pnl = new GridBagConstraints();
		gbc_gameTime_pnl.insets = new Insets(0, 0, 5, 0);
		gbc_gameTime_pnl.fill = GridBagConstraints.BOTH;
		gbc_gameTime_pnl.gridx = 0;
		gbc_gameTime_pnl.gridy = 1;
		container.add(gameTime_pnl, gbc_gameTime_pnl);
		
		JLabel gameTime_lb = new JLabel("Játékidő:");
		gameTime_pnl.add(gameTime_lb);
		
		gameTime_tf = new JTextField(defaultGameTime);
		gameTime_tf.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				try
				{
					Integer.parseInt(gameTime_tf.getText());
				}
				catch(NumberFormatException e)
				{
					gameTime_tf.setText(defaultGameTime);
				}
			}
		});
		gameTime_pnl.add(gameTime_tf);
		gameTime_tf.setColumns(10);
		
		JButton exit_btn = new JButton("Kilépés");
		exit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.getInstance().Exit();
			}
		});
		GridBagConstraints gbc_exit_btn = new GridBagConstraints();
		gbc_exit_btn.fill = GridBagConstraints.HORIZONTAL;
		gbc_exit_btn.gridx = 0;
		gbc_exit_btn.gridy = 2;
		container.add(exit_btn, gbc_exit_btn);
	}

}
