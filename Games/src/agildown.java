import java.awt.Color;
import java.awt.Graphics;


public class agildown extends Item {

	public agildown(int x){
		super(x);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		super.paint(g);
	}
	public void performaction(Ball b){
		if(b.getAgility() >=2) {
		b.setAgility(b.getAgility()-1);
		}
	}
}
