package roundr;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
class RR  extends JFrame implements ActionListener
{
   JButton jb[] = new JButton[3];
   JTextField  jt1[],jt2[];
   JLabel  jl[],jl1,jl2,jl3;
   JPanel  jp,jp1,jp2;
   Container con;
   int  k,p;
   String str[] = {"SUBMIT","BACK","EXIT"};
   String str1[] = {"Job"," AT","BT","WT","TAT"," WTAT"};
   
   
   public RR()
        {
       super("Round robin scheduling algorithm");
           con = getContentPane();
           k= Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));
           jl1 = new JLabel("\t Job");
           jl2 = new JLabel("Priority");
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

        	   int count,j,n,time,remain,flag=0,time_quantum; 
        	   int wait_time=0,turnaround_time=0;
        	   int at[]=new int[10];
        	   int  bt[]=new int[10];
        	   int rt[]=new int [10]; 

        	   n=k;
        	   remain=n; 
        	   for(count=0;count<n;count++) 
        	   { 
        		   at[count]=Integer.parseInt(jt1[count].getText());
        		   bt[count]=Integer.parseInt(jt2[count].getText());
        	     
        	     rt[count]=bt[count]; 
        	   } 
        	   
      
        	   time_quantum=3;
        	   int y=0;
        	   int p[]=new int[10];
        	   int  tat[]=new int[10];
        	   int wt[]=new int [10]; 
        	   for(time=0,count=0;remain!=0;) 
        	   { 
        	     if(rt[count]<=time_quantum && rt[count]>0) 
        	     { 
        	       time+=rt[count]; 
        	       rt[count]=0; 
        	       flag=1; 
        	     } 
        	     else if(rt[count]>0) 
        	     { 
        	       rt[count]-=time_quantum; 
        	       time+=time_quantum; 
        	     } 
        	     if(rt[count]==0 && flag==1) 
        	     { 
        	       remain--; 
        	       p[y]=count+1;
        	       tat[y]=time-at[count];
        	       wt[y]=time-at[count]-bt[count];
        	       wait_time+=time-at[count]-bt[count]; 
        	       turnaround_time+=time-at[count]; 
        	       flag=0; 
        	       y=y+1;
        	     } 
        	     if(count==n-1) 
        	       count=0; 
        	     else if(at[count+1]<=time) 
        	       count++; 
        	     else 
        	       count=0; 
        	   } 

        
         
            for (int l=0;l<6;l++ )
            {
                          jp.add(new JLabel(str1[l]));
            }
            
                        for (int m=0;m<y;m++)
                        {
                        	
                        	    
                          jp.add(new JLabel("P"+p[m]));
                          jp.add(new JLabel("   "+at[p[m]-1] ));
                          jp.add(new JLabel(""+bt[p[m]-1]));
                          jp.add(new JLabel(""+tat[m]));
                          jp.add(new JLabel(""+wt[m]));
                         
                          jp.add(new JLabel(""+((float)tat[m]/bt[m])));

                         
                        
                        }
                       
                        String str2 = "Average Waiting Time is "+wait_time*1.0/n;
                        String str3 = "Average Turn-Around Time is "+turnaround_time*1.0/n;
                         jp1.add(new JLabel(str2));
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
                        RR  window = new RR();
                        window.setSize(500,400);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
        }//END ACTION PERFORMED
        
        
        public static void main(String[] args)
        {
            RR  window = new RR();
                        window.setSize(400,300);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }//end main
}//end class