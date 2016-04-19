package fifo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class FCFS  extends JFrame implements ActionListener
{
   JButton jb[] = new JButton[3];
   JTextField  jt1[],jt2[];
   JLabel  jl[],jl1,jl2,jl3;
   JPanel  jp,jp1,jp2;
   Container con;
   int  k,p;
   String str[] = {"SUBMIT","BACK","EXIT"};
   String str1[] = {"Job","  AT","BT","WT","CT","TAT"," WTAT"};
   
   
   public FCFS()
        {
       super("FCFS scheduling algorithm");
           con = getContentPane();
           k= Integer.parseInt(JOptionPane.showInputDialog("Enter number of job"));
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
                int FT[] = new int[k];
                int WT[] = new int[k];
                int TAT[] = new int[k];
                int m[] = new int[k];
                int p[] = new int[k];
                int h[] = new int[k];


        float NTAT[] = new float[k];
                float sum=0;
                float sum2=0;
        float avg;
        float avg2;
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
                	
                	for(int i=0;i<k;i++){
                		
                m[i]= Integer.parseInt(jt1[i].getText());
        		p[i]=Integer.parseInt(jt2[i].getText());
h[i]=i;
                
                	}
                	 for (int i = 0; i < k; i++) 
                     {
                         for (int j = i + 1; j < k; j++) 
                         {
                        	

                             if (m[i] > m[j]) 
                             {
                               int  temp = m[i];
                                 m[i] = m[j];
                                 m[j] =temp;
                                 
                                 int o=p[i];
                                 p[i]=p[j];
                                 p[j]=o;
                                 
                                 int y=h[i];
                                 h[i]=h[j];
                                 h[j]=y;
                             }
                         }
                     }
                	
                	 
                	
                  FT[0] = m[0] + p[0];
                  for(int i=0;i<k;i++)
                        {
                          if(i==0)
                                 WT[i] = 0;
                           else
                             {
                                  if(FT[i-1] < m[i])
                                        {
                                          FT[i] =m[i]+p[i];
                                          WT[i] = 0;
                                        }
                                        else
                                        {
                                                FT[i] = FT[i-1] +p[i];
                                                WT[i] = FT[i-1] -m[i];
                                        }
                }
                                TAT[i] = WT[i]+p[i];
                                NTAT[i] = (float)TAT[i]/p[i];
                                sum = sum+WT[i];
                                sum2= sum2+FT[i];
                        }//end for loop
            for (int i=0;i<7;i++ )
            {
                          jp.add(new JLabel(str1[i]));
            }
                        for (int i=0;i<k;i++)
                        {
                          jp.add(new JLabel("P"+h[i]));
                          jp.add(new JLabel("   "+m[i]));
                          jp.add(new JLabel(""+p[i]));
                          jp.add(new JLabel(""+WT[i]));
                          jp.add(new JLabel(""+FT[i]));
                          jp.add(new JLabel(""+TAT[i]));
                          jp.add(new JLabel(""+NTAT[i]));
                        }
                        avg = sum/k;
                        avg2=sum2/k;
                        String str2 = "Average Waiting Time is "+ avg;
                        String str3 = "Average Turn-Around Time is "+ avg2;
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
                        FCFS  window = new FCFS();
                        window.setSize(500,400);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
        }//END ACTION PERFORMED
        public static void main(String[] args)
        {
            FCFS  window = new FCFS();
                        window.setSize(400,300);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }//end main
}//end class