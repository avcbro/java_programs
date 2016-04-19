import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.Random;


public class Startingpoint extends Applet implements Runnable,KeyListener,MouseMotionListener,MouseListener{
	
	
	Ball b;
	Platform p[]=new Platform[7];
	Item item[]=new Item[3];
	int levelcheck=0;
	private Image i;
	private Graphics doubleG;
	int score;
	double cityx=0;
	double cityDx=0.3;
	URL url;
	Image city;
	boolean gameover=false;
	boolean mousein=false;
	public void init(){
	
		setSize(800,600);
	      addKeyListener(this); 
	      addMouseMotionListener(this);
	      addMouseListener(this);
	      try{
	    	  url=getDocumentBase();
	      }
	      catch(Exception e){
	    	  
	      }
	      
	      city=getImage(url,"image.jpg");
	     new Pictures(this);
	      Pictures.music.loop();
	      
	}
	
	public void start(){
		b=new Ball();
		score=0;
		for(int i=0;i<p.length;i++){
		  Random r=new Random();
		  
			p[i]=new Platform(i*120,300);
		}
		
		for(int i=0;i<item.length;i++){
			  Random r=new Random();

				switch(r.nextInt(5)){
				
				case 0:
					item[i]=new GraveUp(getWidth()+200*i);
					break;
					

				case 1:
					item[i]=new gravd(getWidth()+200*i);
					break;

				case 2:
					item[i]=new agilup(getWidth()+200*i);
					break;

				case 3:
					item[i]=new agildown(getWidth()+200*i);
					break;	
					
				case 4:
					item[i]=new Scoreplus(getWidth()+200*i,this);
					break;	
					
				}
				
			}

		
		Thread thread=new Thread(this);
		thread.start();
	}
	
	public void run(){
	
		while(true){
			
			if(levelcheck>1000){
				Pictures.level++;
				levelcheck=0;
				
			}
			gameover=b.getgameover();
			levelcheck++;
			if(!gameover){
				score++;
				
			}
			Random r=new Random();
			for(int i=0;i<item.length;i++){
				if(item[i].isCreateNew()){
					item[i]=null;
					
					switch(r.nextInt(5)){
					
					case 0:
						item[i]=new GraveUp(getWidth()+10*r.nextInt(500));
						break;
						

					case 1:
						item[i]=new gravd(getWidth()+10*r.nextInt(500));
						break;

					case 2:
						item[i]=new agilup(getWidth()+10*r.nextInt(500));
						break;

					case 3:
						item[i]=new agildown(getWidth()+10*r.nextInt(500));
						break;	
						
					case 4:
						item[i]=new Scoreplus(getWidth()+10*r.nextInt(500),this);
						break;	
						
					}
				}
				item[i].setCreatenew(false);
				
			}
			b.update(this);
			for(int i=0;i<p.length;i++){
				p[i].update(this,b);

			}
			
			for(int i=0;i<item.length;i++){
				item[i].update(this,b);

			}

			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
				e.getCause();
			}
			
		}
	}
//double buffering 
	public void update(Graphics g){
	
		if(i==null){
			i=createImage(this.getSize().width,this.getSize().height);
			doubleG=i.getGraphics();
			
	  }
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		doubleG.setColor(getForeground());
		paint(doubleG);
		g.drawImage(i, 0, 0, this);
		
	}
 

 public void paint(Graphics g){
	 g.setColor(new Color(15,77,147));
	 g.fillRect(0, 0,getWidth(), getHeight());
	 g.drawImage(city, (int) cityx, 0, 800,600, this);

	 //g.drawImage(city, , 0, this);
	b.paint(g);
	for(int i=0;i<p.length;i++){
		 p[i].paint(g);

	}
	
	for(int i=0;i<item.length;i++){
		 item[i].paint(g);

	}
	
	 Font font=new Font("Serif",Font.BOLD,32);
	 g.setFont(font);
	 String s=Integer.toString(score);
	 g.setColor(Color.BLACK);
	 g.drawString(s, getWidth()-150+2, 50+2);
	 g.setColor(new Color(198,226,255));
	 g.drawString(s, getWidth()-150, 50);
	 
	 if(gameover){
		 g.setColor(Color.WHITE);
		 g.drawString(" ", 100, 100);

		 g.setColor(Color.WHITE);
		 g.drawString("Game Over", 300, 300);
		 g.drawRect(280, 340, 180, 40);
		 
		 if(mousein){

			 g.setColor(Color.RED);
			 g.drawString("Play again?", 300, 370);
		 }
		 else{

			 g.setColor(Color.WHITE);
			 g.drawString("Play again?", 300, 370);
		 }
	 }
 }

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	switch(e.getKeyCode()){
	case KeyEvent.VK_LEFT:
		b.moveleft();
		break;
	case KeyEvent.VK_RIGHT:
		b.moveright();
		break;
	
	}
}

public int getScore() {
	return score;
}

public void setScore(int score) {
	this.score = score;
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	if(e.getX() > 280 && e.getX() < 460){
		if(e.getY() < 280 && e.getY() > 460){
			mousein=true;
		}
	}
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	if(gameover){
	if(e.getX() > 280 && e.getX() < 460){
		if(e.getY() > 320 && e.getY()  < 400){
			mousein=true;
		}
	}
	
	
	if(e.getX() < 280 || e.getX() > 460){
			mousein=false;
		
	}
	
		if(e.getY() < 320  && e.getY() > 400){
			mousein=false;
		}
	}
	
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if(mousein){
		b=null;
		b=new Ball();
		score=0;
		Pictures.level=1;
		for(int i=0;i<p.length;i++){
			  Random r=new Random();
			  
				p[i]=new Platform(i*120,300);
			}
			
			for(int i=0;i<item.length;i++){
				  Random r=new Random();

					switch(r.nextInt(5)){
					
					case 0:
						item[i]=new GraveUp(getWidth()+200*i);
						break;
						

					case 1:
						item[i]=new gravd(getWidth()+200*i);
						break;

					case 2:
						item[i]=new agilup(getWidth()+200*i);
						break;

					case 3:
						item[i]=new agildown(getWidth()+200*i);
						break;	
						
					case 4:
						item[i]=new Scoreplus(getWidth()+200*i,this);
						break;	
						
					}
					
				}

		mousein=false;
	}
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
