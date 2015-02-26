import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Drawer extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2071576479535098870L;
	int x = 0;
	int y = 0;
	
	int posX = 100;
	int posY = 100;
	
	double fps = 0;
	
	KeyboardState ks = new KeyboardState();
	
	public Drawer()
	{
		this.addKeyListener(ks);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		g.drawString(String.valueOf(fps), 20, 20);
		g.drawRect(posX, posY, 100, 100);
	}
	
	public void run()
	{
		while(true)
		{
			long time = System.currentTimeMillis();
			if(ks.isKeyDown(KeyEvent.VK_UP))
				posY -= 5;
			if(ks.isKeyDown(KeyEvent.VK_DOWN))
				posY += 5;
			if(ks.isKeyDown(KeyEvent.VK_LEFT))
				posX -= 5;
			if(ks.isKeyDown(KeyEvent.VK_RIGHT))
				posX += 5;
			this.repaint();
			
			try {
				Thread.sleep(17L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fps = 1000/(System.currentTimeMillis()-time);
		}
	}
}
