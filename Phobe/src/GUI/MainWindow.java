package GUI;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.Game;
import Game.GameEndedListener;
import Game.Robot;

public class MainWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5298163134078997988L;
	private static MainWindow instance = new MainWindow();

	public static MainWindow getInstance()
	{
		return instance;
	}
	
	private HashMap<String,JComponent> menus = new HashMap<String,JComponent>();
	private JPanel contentPane;
	
	private Game game;
	private GameEnd gameEnd;
	/**
	 * Create the frame.
	 */
	private MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		menus.put("MainMenu", MainMenu.getInstance());
		
		game = new Game();
		menus.put("Game", game);
		
		game.addGameEndedListener(new GameEndedListener(){

			@Override
			public void GameEnded(Robot winnerBot) {
				gameEnd.setWinner(winnerBot);
				SwapTo("GameEnd");
			}
			
		});
		
		game.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					game.Pause();
					SwapTo("InGameMenu");
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}});
		
		menus.put("InGameMenu", InGameMenu.getInstance());
		gameEnd = GameEnd.getInstance();
		
		menus.put("GameEnd", gameEnd);
		
		contentPane.setPreferredSize(game.getPreferredSize());		
		this.setResizable(false);
		
		
		SwapTo("MainMenu");
	}
	
	public void SwapTo(String s)
	{
		this.contentPane.removeAll();
		
		this.contentPane.add(menus.get(s));
		this.pack();
		repaint();
	}

	public void StartGame(int gameTime)
	{
		game.setMaxGameTime(gameTime);
		game.Init();
		SwapTo("Game");
		game.Start();
	}

	public void ResumeGame() {
		SwapTo("Game");
		game.Start();
	}
	
	public void Exit()
	{
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
