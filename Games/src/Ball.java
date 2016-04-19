import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	private int x=400;
	private int y=20;
	private int radius=20;
	private double dx=5;
	private double dy=0;
	private double gravity=15;
	private double energyloss=2;
	 private double dt=0.2;
	 private double xfriction=.9;
	private boolean gover=false;
	private double gamedy=-75;
	
	private int agility=3 ;
	private int maxspeed=10;
	
	// gRAVITY AND AGILITY PROBLEM
	public Ball() {
	// TODO Auto-generated constructor stub
	
	}
	
	public Ball(int i, int j) {
		// TODO Auto-generated constructor stub
		x=i;
		y=j;
	}
	
	public double getgamedy(){
		return gamedy;
	}
	
	
	public void  setgamedy(double x){
	  gamedy=x;	
	}
	
	public void update(Startingpoint sp){
		if(x+dx > sp.getWidth()-radius-1){
			x=sp.getWidth()-radius-1;
			dx=-dx;
		}
		else if(x+dx < 0 + radius){
			x=0+radius;
			dx=-dx;
		}
		else{
	     x +=dx;
		}
		
		if(y==sp.getHeight()-radius-1){
			dx*=xfriction;
			if(Math.abs(dx) < .8){
				dx=0;
			}
		}
		if(y-200 >sp.getHeight()-radius-1){
			gover=true;
		}
		
		else{
			
			dy+=gravity*dt;
			y+=dy*dt+.5*gravity*dt*dt;
			
		}
	 
	}
	
	public void moveright(){
		if(dx+agility < maxspeed){
			dx+=agility;
		}
	}
	
	
	
	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getMaxspeed() {
		return maxspeed-10;
	}

	public void setMaxspeed(int maxspeed) {
		this.maxspeed = maxspeed;
	}

	public void moveleft(){
		if(dx-agility > -maxspeed){
			dx-=agility;
		}
	}
	
	public int getRadius(){
		return radius;
	}
	public void paint(Graphics g){
		 g.setColor(Color.CYAN);
		 g.fillOval(x-radius, y-radius, radius*2, radius*2);
		 if(gover){
			
		 }
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public double getdx(){
		return dx;
	}
	
	public void setdx(double dx){
		this.dx=dx;
	}
	
	public double getdy(){
		return dy;
	}
	
	public void setdy(double dy){
		this.dy=dy;
	}

	public double getgravity() {
		// TODO Auto-generated method stub
		return gravity;
	}
	
	public void setgravity(double b){
		this.gravity=b;
	}

	public boolean getgameover() {
		// TODO Auto-generated method stub
		return gover;
	}
}

