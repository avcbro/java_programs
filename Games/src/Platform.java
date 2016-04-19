import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;


public class Platform {

	int x,y,width,height;
    int dx;
    Image plat;
    URL url;
    
    float frame=0;
    
    public Platform(){
    	plat=Pictures.platform;

    	dx=5;
    	x=300;
    	y=300;
    	width=120;
    	height=40;
    
    	
    }
    
    
    public Platform(int i, int j) {
		// TODO Auto-generated constructor stub
    	
    	this.x=i;
    	this.y=j;
    	width=120;
    	height=40;
    	dx=5;
	}


	
	public void paint(Graphics g){
		Color customColor = new Color(210,73,88);
        
		g.setColor(customColor);
		g.fillRect(x, y, width, height);
		g.drawRect(x, y, width, height);
	
		
		g.drawImage(plat,x,y,x+width,y+height,0,40*(int)frame,120,40*(int)frame+40,Pictures.sp);
		
	   
	}
	
	public void update(Startingpoint sp,Ball b){
		x+=-(Pictures.level);
		
		checkforcollision(b);
		if(x <0-width){
			Random r =new Random();
			y=sp.getHeight()-80-r.nextInt(350);
			x=sp.getWidth()-50+r.nextInt(100);
			
		}
		
		int tester=(int)(frame+0.1);
		if(tester < 3)
			frame+=0.1;
		
		else
			frame=0;
		
	} 
	
	
	public void checkforcollision(Ball b){
	
		int ballx=b.getX();
		int bally=b.getY();
		
		int radius=b.getRadius();
        
		if(bally+radius > y && bally+radius < y+height){
			if(ballx > x&& ballx <x+width){
				double newdy=b.getgamedy();;
				b.setY(y-radius);
				b.setdy(newdy);
				Pictures.bounce.play();
				
			}
		}
	}
}
