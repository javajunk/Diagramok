package Game;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.font.TextLayout;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class HUD {
	private Font timeFont;
	private Font infosFont;
	private Date remTime = new Date();
	private String remainingTime = "";
	private SimpleDateFormat dt = new SimpleDateFormat("mm:ss");
	private Vector2D remainingTimeCenter;
	private List<String> robotInfos = new ArrayList<String>();
	private List<Vector2D> robotInfosPos = new ArrayList<Vector2D>();
	DecimalFormat distanceFormat = new DecimalFormat("#0.00");     

	public HUD(Map m)
	{
		remainingTimeCenter = new Vector2D(m.getWidth()/2,36);
		infosFont = new Font("Monoscape",0,24);
		try {
			timeFont = Font.createFont(Font.TRUETYPE_FONT, new File("./other/ds-digi.ttf"));
			
			GraphicsEnvironment ge = 
			         GraphicsEnvironment.getLocalGraphicsEnvironment();
			     ge.registerFont(timeFont);
			     timeFont = new Font("DS-Digital",Font.PLAIN,36);
			     
			    
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		robotInfosPos.add(new Vector2D(5,36));
		robotInfosPos.add(new Vector2D(m.getWidth(),36));
	}
	
	public void Update(Game g)
	{		
		remTime.setTime(g.getRemainingTime()*Game.targetFrameTime);
		remainingTime = dt.format(remTime);
		
		robotInfos.clear();
		for(Robot r : g.getRobots())
		{
			StringBuilder sb = new StringBuilder();
			sb.append(r.getName()); sb.append(" Játékos");
			sb.append("\nOlaj: "); sb.append(r.getStoredOil());
			sb.append("\nRagacs: "); sb.append(r.getStoredGlue());
			sb.append("\nTáv: "); sb.append(distanceFormat.format(r.getDistance()));
			
			robotInfos.add(sb.toString());
		}		
	}
	
	private void DrawRobotInfo(Graphics2D g,String infos, Vector2D pos, boolean leftToRight)
	{	
		double line = 0;
		for(String info : infos.split("\n"))
		{
			
			TextLayout layout = new TextLayout(info, (leftToRight) ? g.getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT) : g.getFont(), g.getFontRenderContext());
			layout.draw(g, (float)(
					(leftToRight) ? pos.getX()-layout.getBounds().getWidth() : pos.getX()
					), 
					(float)(pos.getY() + line*g.getFontMetrics().getHeight()));
			line++;
		}
	}
	
	public void Draw(Graphics g)
	{
		Font fontTmp = g.getFont();
		g.setFont(timeFont);
		Graphics2D grap = (Graphics2D)g;
		
		TextLayout layout = new TextLayout(remainingTime, timeFont, grap.getFontRenderContext());
		layout.draw(grap, (float)(remainingTimeCenter.getX()-layout.getBounds().getWidth()/2), (float)remainingTimeCenter.getY());
		
		g.setFont(infosFont);
		
		DrawRobotInfo(grap,robotInfos.get(0),robotInfosPos.get(0),false);
		DrawRobotInfo(grap,robotInfos.get(1),robotInfosPos.get(1),true);
		
		g.setFont(fontTmp);
	}
}
