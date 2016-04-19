import java.awt.Color;
import java.awt.Graphics;


public class GraveUp extends Item {

	public GraveUp(int x){
		super(x);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		super.paint(g);
	}
	public void performaction(Ball b){
		b.setgravity(b.getgravity()+3);
	}
}
