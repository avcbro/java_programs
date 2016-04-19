package multilevel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
class Mlevel  extends JFrame implements ActionListener
{
   JButton jb[] = new JButton[3];
   JTextField  jt1[],jt2[];
   JLabel  jl[],jl1,jl2,jl3;
   JPanel  jp,jp1,jp2;
   Container con;
   int  k,p;
   String str[] = {"SUBMIT","BACK","EXIT"};
   String str1[] = {"Job"," AT","BT","","TAT",""};
   
   
   public Mlevel()
        {
       super("Multilevel  scheduling algorithm");
           con = getContentPane();
           k= Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));
           jl1 = new JLabel("      Job");
           jl2 = new JLabel("Arrival time");
           jl3 = new JLabel("Burst Time");
           jl = new JLabel[k];
           jt1 = new JTextField[k];
           jt2 = new JTextField[k];
       for(int i=0;i<k;i++)
           {
                   jl[i] = new JLabel("      Job "+(i+1));
                   jt1[i]  = new JTextField(10);
                   jt2[i]  = new JTextField(10);
           }
          for(int i=0;i<3;i++)
          {
                  jb[i] = new JButton(str[i]);
          }
          con.setLayout(new  GridLayout(k+2,3));
          con.add(jl1);
          con.add(jl2);
          con.add(jl3);
          int l=0;
                for(int i=0;i<k;i++)
                {
                        con.add(jl[l]);
                        con.add(jt1[l]);
                        con.add(jt2[l]);
                        l++;
                }
          l=0;
                for(int i=0;i<3;i++)
                {
                  con.add(jb[l]);
                  jb[l].addActionListener(this);
                  l++;
                }
        }//end of constructor
   
        public void actionPerformed(ActionEvent ae)
        {
            JPanel main = new JPanel();
            main.setLayout(new BorderLayout());
            jp = new JPanel();
            jp1 = new JPanel();
            jp2 = new JPanel();
            jp.setLayout(new GridLayout(k+1,7));
            jp1.setLayout(new FlowLayout());
            jp2.setLayout(new FlowLayout());
           if(ae.getSource() == jb[2])
             {
                   System.exit(0);
             }
           else if(ae.getSource() == jb[0])
           	
           	
           {
        	   
         int bt[] =new int[20];
         int at[] =new int[20];
         int p[][] =new int[20][5];
       
         
         int wt[] =new int[20];
         int tat[] =new int[20];
         int i,j,n,total=0,pos,temp,avg_wt,avg_tat;

        	   n=k;
         for(i=0;i<n;i++)
         {
             
           at[i]=Integer.parseInt(jt1[i].getText());
           bt[i]=Integer.parseInt(jt2[i].getText());
           p[i][0]=i+1;
           p[i][1]=bt[i];
           p[i][2]=0;
          } 
       //  int delta=1;
         int flag=0;
         int time=0;
        while(true){
        	flag=0; 
        	for(i=0;i<k;i++){
             	flag=flag+p[i][1];
              }
        	 
        	 if(flag==0)
        		 break;
        	 
        	for(j=0;j<k;j++){
        		time++;
        		if(p[j][1]==0)
        			continue;
        		
        		if(p[j][2]==0){
        			p[j][1]=p[j][1]-1;
        			
        			if(p[j][1]==0){
        			p[j][3]=time;
        		  }
        			if(p[j][1]==1){
            			p[j][2]=0;
            		  }
        			else if(p[j][1]>1 && p[j][1] <=5){
        				p[j][2]=1;
        			}
        			
        			else if(p[j][1]>5){
        				p[j][2]=2;
        			}
        	 }
        		
        		
        		
        		
        		
        		
        		else if(p[j][2]==1){
        			p[j][1]=p[j][1]-2;
        			
        			if(p[j][1]==0){
        			p[j][3]=time;
        		  }
        			if(p[j][1]==1){
            			p[j][2]=0;
            		  }
        			else if(p[j][1]>1 && p[j][1] <=5){
        				p[j][2]=1;
        			}
        			
        			else if(p[j][1]>5){
        				p[j][2]=2;
        			}
        	 }
        		
        		else if(p[j][2]==2){
        			
        			p[j][1]=p[j][1]-3;
        			
        			if(p[j][1]==0){
        			p[j][3]=time;
        		  }
        			if(p[j][1]==1){
            			p[j][2]=0;
            		  }
        			else if(p[j][1]>1 && p[j][1] <=5){
        				p[j][2]=1;
        			}
        			
        			else if(p[j][1]>5){
        				p[j][2]=2;
        			}
        	 }
        		
        		
        		
        		System.out.println(p[j][1]);
        		
        		
        	}
        	
        	
        	
        }
         
         
       
        avg_tat=0;
  
         for(i=0;i<n;i++)
         {
            tat[i]=p[i][3]-at[i];
            wt[i]=tat[i]/bt[i];
            avg_tat=tat[i]+avg_tat;
         }
         avg_tat=avg_tat/k;
        
            for (int l=0;l<6;l++ )
            {
                          jp.add(new JLabel(str1[l]));
            }
            
                        for (int m=0;m<n;m++)
                        {
                        	
                        	
                        	        
                        	    
                          jp.add(new JLabel("P"+p[m][0]));
                          jp.add(new JLabel("   "+ at[m]));
                          jp.add(new JLabel(""+bt[m]));
                          jp.add(new JLabel(""));
                          jp.add(new JLabel(""+tat[m]));
                         
                          jp.add(new JLabel(""));

                         
                        
                        }
                       
                        avg_tat=total/n;     //average turn around time
               
                        String str3 = "Average Turn-Around Time is "+ avg_tat;
                         jp1.add(new JLabel(""));
                         jp2.add(new JLabel(str3));
                         main.add(jp,BorderLayout.NORTH);
                         main.add(jp1,BorderLayout.SOUTH);
                         main.add(jp2,BorderLayout.EAST);
                         JOptionPane.showMessageDialog(null,main,"Output",JOptionPane.PLAIN_MESSAGE
);
        }
                else if(ae.getSource() == jb[1])
                {
                        setVisible(false);
                        Mlevel  window = new Mlevel();
                        window.setSize(500,400);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
        }//END ACTION PERFORMED
        
        
        public static void main(String[] args)
        {
            Mlevel  window = new Mlevel();
                        window.setSize(400,300);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }//end main
}//end class