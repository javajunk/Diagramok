package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InGameMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -175434647769140204L;
	private static InGameMenu instance = new InGameMenu();
	public static InGameMenu getInstance()
	{
		return instance;
	}
	/**
	 * Create the panel.
	 */
	private InGameMenu() {
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
		gbl_container.rowHeights = new int[]{10, 0, 0, 0, 0, 0};
		gbl_container.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_container.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		container.setLayout(gbl_container);
		
		JLabel title_lbl = new JLabel("Szünet");
		title_lbl.setFont(new Font("Tahoma", Font.PLAIN, 36));
		GridBagConstraints gbc_title_lbl = new GridBagConstraints();
		gbc_title_lbl.insets = new Insets(0, 0, 5, 0);
		gbc_title_lbl.gridx = 0;
		gbc_title_lbl.gridy = 0;
		container.add(title_lbl, gbc_title_lbl);
		
		JButton backToGame_btn = new JButton("Folytatás");
		backToGame_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.getInstance().ResumeGame();
			}
		});
		GridBagConstraints gbc_backToGame_btn = new GridBagConstraints();
		gbc_backToGame_btn.fill = GridBagConstraints.HORIZONTAL;
		gbc_backToGame_btn.insets = new Insets(0, 0, 5, 0);
		gbc_backToGame_btn.gridx = 0;
		gbc_backToGame_btn.gridy = 3;
		container.add(backToGame_btn, gbc_backToGame_btn);
		
		JButton backToMainMenu_btn = new JButton("Főmenü");
		backToMainMenu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.getInstance().SwapTo("MainMenu");
			}
		});
		GridBagConstraints gbc_backToMainMenu_btn = new GridBagConstraints();
		gbc_backToMainMenu_btn.fill = GridBagConstraints.HORIZONTAL;
		gbc_backToMainMenu_btn.gridx = 0;
		gbc_backToMainMenu_btn.gridy = 4;
		container.add(backToMainMenu_btn, gbc_backToMainMenu_btn);
	}

}
