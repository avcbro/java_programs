import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Scoreplus extends Item {
	private Startingpoint appletinfo;
	
	public Scoreplus(int x,Startingpoint appletinfo){
		super(x);
		this.appletinfo=appletinfo;
		
	}
	
	
	public void performaction(Ball b){
		Random r=new Random();
		appletinfo.setScore(appletinfo.getScore()+500+r.nextInt(2000));
		
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		
		super.paint(g);
		
	}

}
