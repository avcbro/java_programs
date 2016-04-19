import java.awt.Color;
import java.awt.Graphics;


public class agilup extends Item {

	public agilup(int x){
		super(x);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		super.paint(g);
	}
	public void performaction(Ball b){
		if(b.getAgility() < 8) {
		b.setAgility(b.getAgility()+1);
		}
	}
}
