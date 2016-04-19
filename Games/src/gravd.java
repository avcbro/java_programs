import java.awt.Color;
import java.awt.Graphics;


public class gravd extends Item {

	public gravd(int x){
		super(x);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		super.paint(g);
	}
	public void performaction(Ball b){
		if(b.getgravity() > 3){
		b.setgravity(b.getgravity()-3);
		if(b.getgravity()<3){
			b.setgravity(3);
		}
	}
	}
}
