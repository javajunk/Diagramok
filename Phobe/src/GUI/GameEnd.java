package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.JButton;

import Game.Robot;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameEnd extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6789266855065000491L;
	
	private static GameEnd instance = new GameEnd();
	
	public static GameEnd getInstance()
	{
		return instance;
	}
	
	private JLabel winner_lb;
	/**
	 * Create the panel.
	 */
	private GameEnd() {
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
		gbl_container.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		container.setLayout(gbl_container);
		
		winner_lb = new JLabel("Hupilila játékos nyert");
		winner_lb.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_winner_lb = new GridBagConstraints();
		gbc_winner_lb.insets = new Insets(0, 0, 5, 0);
		gbc_winner_lb.gridx = 0;
		gbc_winner_lb.gridy = 0;
		container.add(winner_lb, gbc_winner_lb);
		
		JButton backToMainMenu_btn = new JButton("Főmenü");
		backToMainMenu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.getInstance().SwapTo("MainMenu");
			}
		});
		GridBagConstraints gbc_backToMainMenu_btn = new GridBagConstraints();
		gbc_backToMainMenu_btn.insets = new Insets(0, 0, 5, 0);
		gbc_backToMainMenu_btn.gridx = 0;
		gbc_backToMainMenu_btn.gridy = 3;
		container.add(backToMainMenu_btn, gbc_backToMainMenu_btn);
	}

	public void setWinner(Robot winnerBot)
	{
		if(winnerBot != null)
			winner_lb.setText("A " + winnerBot.getName() + " játékos nyert.");
		else
			winner_lb.setText("A játék döntetlen.");
	}
}
