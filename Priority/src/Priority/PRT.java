package Priority;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
class PRT  extends JFrame implements ActionListener
{
   JButton jb[] = new JButton[3];
   JTextField  jt1[],jt2[];
   JLabel  jl[],jl1,jl2,jl3;
   JPanel  jp,jp1,jp2;
   Container con;
   int  k,p;
   String str[] = {"SUBMIT","BACK","EXIT"};
   String str1[] = {"Job"," p","BT","","TAT"," WTAT"};
   
   
   public PRT()
        {
       super("Priority scheduling algorithm");
           con = getContentPane();
           k= Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));
           jl1 = new JLabel("     Job");
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
        	   
         int bt[] =new int[20];
         int pt[] =new int[20];
         int p[] =new int[20];

         int pr[] =new int[20];
       
         
         int wt[] =new int[20];
         int tat[] =new int[20];
         int i,j,n,total=0,pos,temp,avg_wt,avg_tat;

      
         
         n=k;
         
       
        avg_tat=0;
        for(i=0;i<n;i++){
        	pr[i]=Integer.parseInt(jt1[i].getText());
        	bt[i]=Integer.parseInt(jt2[i].getText());
        	p[i]=i+1;  
        	
        }
        
        for(i=0;i<n;i++)
        {
            pos=i;
            for(j=i+1;j<n;j++)
            {
                if(pr[j]<pr[pos])
                    pos=j;
            }
     
            temp=pr[i];
            pr[i]=pr[pos];
            pr[pos]=temp;
     
            temp=bt[i];
            bt[i]=bt[pos];
            bt[pos]=temp;
     
            temp=p[i];
            p[i]=p[pos];
            p[pos]=temp;
        }
        
        

        wt[0]=0;  
        for(i=1;i<n;i++)
        {
            wt[i]=0;
            for(j=0;j<i;j++)
                wt[i]+=bt[j];
     
            total+=wt[i];
        }
        
        
        
        
        avg_wt=total/n;     
        total=0;
     
        
        for(i=0;i<n;i++)
        {
            tat[i]=bt[i]+wt[i];     
            total+=tat[i];
           
        }
        avg_tat=total/n; 
       
       
        
            for (int l=0;l<6;l++ )
            {
                          jp.add(new JLabel(str1[l]));
            }
            
                        for (int m=0;m<n;m++)
                        {
                        	
                        	
                        	        
                        	    
                          jp.add(new JLabel("P"+p[m]));
                          jp.add(new JLabel("   "+ pr[m]));
                          jp.add(new JLabel(""+bt[m]));
                          jp.add(new JLabel(""));
                          float x=(float)tat[m]/bt[m];
                          
                          jp.add(new JLabel(""+tat[m]));
                         
                          jp.add(new JLabel(""+x));

                         
                        
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
                        PRT  window = new PRT();
                        window.setSize(500,400);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
        }//END ACTION PERFORMED
        
        
        public static void main(String[] args)
        {
            PRT  window = new PRT();
                        window.setSize(400,300);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }//end main
}//end class