package shortestjobfirst;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
class SJF  extends JFrame implements ActionListener
{
   JButton jb[] = new JButton[3];
   JTextField  jt1[],jt2[];
   JLabel  jl[],jl1,jl2,jl3;
   JPanel  jp,jp1,jp2;
   Container con;
   int  k,p;
   String str[] = {"SUBMIT","BACK","EXIT"};
   String str1[] = {"Job","   AT","BT","WT","CT","TAT"," WTAT"};
   
   
   public SJF()
        {
       super("SJF scheduling algorithm");
           con = getContentPane();
           k= Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));
           jl1 = new JLabel("\t Job");
           jl2 = new JLabel("Arrival Time");
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
        	int proc[][] = new int[k + 1][4];
        	for(int i = 0; i < k; i++)
            {
        		int m,n;
        	m =Integer.parseInt(jt1[i].getText());
        	n = Integer.parseInt(jt2[i].getText());
        	proc[i][0]=m;
        	proc[i][1]=n;
        	
            }
        	
        	int total_time = 0;
            for(int i = 0; i < k; i++)
            {
             total_time += proc[i][1];
            }
        	
            
            int time_chart[] = new int[total_time];
            
            for(int i = 0; i < total_time; i++)
            {
            	//Selection of shortest process which has arrived
            	int sel_proc = 0;
            	int min = 99999;
             
            	for(int j = 0; j < k; j++)
            	{
            		if(proc[j][0] <= i)    //Condition to check if Process has arrived
            		{
            			if(proc[j][1] < min && proc[j][1] != 0)
            			{
            				min = proc[j][1];
            				sel_proc = j;
            			}
            		}
            	}
            
             //Assign selected process to current time in the Chart
             time_chart[i] = sel_proc;
             
             //Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
             proc[sel_proc][1]--;
             //WT and TT Calculation
             for(int j =0; j < k; j++)
             {
              if(proc[j][0] <= i)
              {
               if(proc[j][1] != 0)
               {
                proc[j][3]++;//If process has arrived and it has not already completed execution its TT is incremented by 1
                   if(j != sel_proc)//If the process has not been currently assigned the CPU and has arrived its WT is incremented by 1
                    proc[j][2]++;
               }
               else if(j == sel_proc)//This is a special case in which the process has been assigned CPU and has completed its execution
                proc[j][3]++;
              }
             }
            
            }
       
           
            float WT = 0,TT = 0;
            for(int o = 0; o < k; o++)
            {
             WT += proc[o][2];
             TT += proc[o][3];
            }
                
                	 
                
            for (int l=0;l<7;l++ )
            {
                          jp.add(new JLabel(str1[l]));
            }
            
                        for (int m=0;m<k;m++)
                        {
                        	

                          jp.add(new JLabel("P"+m));
                          jp.add(new JLabel("   "+proc[m][0]));
                          jp.add(new JLabel(""+Integer.parseInt(jt2[m].getText())));
                          jp.add(new JLabel(""+proc[m][2]));
                          jp.add(new JLabel(""+(proc[m][0]+proc[m][3])));
                          jp.add(new JLabel(""+proc[m][3]));
                          
                          jp.add(new JLabel(""+(float)proc[m][3]/Integer.parseInt(jt2[m].getText())));
                        
                         
                        
                        }
                       
                        WT /= k;
                        TT /= k;
                        String str2 = "Average Waiting Time is "+ WT;
                        String str3 = "Average Turn-Around Time is "+ TT;
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
                        SJF  window = new SJF();
                        window.setSize(500,400);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
        }//END ACTION PERFORMED
        
        
        public static void main(String[] args)
        {
            SJF  window = new SJF();
                        window.setSize(400,300);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }//end main
}//end class