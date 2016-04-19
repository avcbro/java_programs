import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;


public class Pictures {
	static Image platform,ball;
	URL url;
	static Startingpoint sp;
	static AudioClip music,bounce;
	
	static int level=1;
	 
	public Pictures(Startingpoint sp) {
		// TODO Auto-generated constructor stub
		try{
			url=sp.getDocumentBase();
			
		}
		catch(Exception e){
			
		}
		this.sp=sp;

		platform=sp.getImage(url,"cool.jpg");
	
		bounce=sp.getAudioClip(url,"bounce.au");
		music=sp.getAudioClip(url,"music.au");
		
	}

}
