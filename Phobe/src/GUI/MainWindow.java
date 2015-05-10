package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
		try {
			contentPane = new ImageBackgroundJPanel("map/map.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
	
	private class ImageBackgroundJPanel extends JPanel
	{
		private BufferedImage img;
		
		public ImageBackgroundJPanel(String imgPath) throws IOException {
		    this.img = ImageIO.read(new File(imgPath));
		}
		
		public void paintComponent(Graphics g) {
		    g.drawImage(img, 0, 0, null);
		}
	}
	
}
