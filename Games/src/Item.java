import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Item {

	private int x,y,dx,radius;
	private Startingpoint sp;
	private boolean createnew=false;

	public Item(int x){
		this.x=x;
		Random r =new Random();
		y=r.nextInt(400)+radius;
		dx=-2;
		radius=10;
		
		
	}
	
	public int gety(){
		return y;
	}
	public void update(Startingpoint sp,Ball b){
		x+=dx;
		this.sp=sp;
		checkforcollision(b);
		if(x <0-radius){
			createnew=true;
			
			
		}
	}
	
	
	
	public void paint(Graphics g){
		//g.setColor(Color.MAGENTA);
g.fillOval(x-radius, y-radius, radius*2, radius*2);

	}
	
	
	public void checkforcollision(Ball b){
		
		int ballx=b.getX();
		int bally=b.getY();
		
		int ballR=b.getRadius();
       int a=x-ballx;
       int bb=y-bally;
       int collide=radius+ballR;
       double c=Math.sqrt((double) (a*a)+(double) (bb*bb));
       
       if(c <= collide){
    	   performaction(b);
    	   createnew=true;
       }
	}

	public boolean isCreateNew() {
		return createnew;
	}

	public void setCreatenew(boolean createnew) {
		this.createnew = createnew;
	}

	private void performaction(Ball b) {
		// TODO Auto-generated method stub
		
	}

}
