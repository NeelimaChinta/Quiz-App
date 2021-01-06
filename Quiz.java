import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class Quiz extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    Quiz(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Review");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);
		add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Your Score");  
            }  
        }  
        if(e.getActionCommand().equals("Review"))  
        {  
            JButton bk=new JButton("Review"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Your Score");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Review"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Your Score"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            
            JOptionPane.showMessageDialog(this,"Correctly Answered="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("1. Who was the first Indian woman in Space?");  
            jb[0].setText("Kalpana Chawla");jb[1].setText("Sunita Williams");jb[2].setText("Sunita Williams");jb[3].setText("None of the above");   
        }  
        if(  current==1)  
        {  
            l.setText("2. Who was the first Indian in space?");  
            jb[0].setText("Vikram Ambalal");jb[1].setText("Ravish Malhotra");jb[2].setText("Rakesh Sharma");jb[3].setText("Nagapathi Bhat");  
        }  
        if(current==2)  
        {  
            l.setText("3. Who was the first Man to Climb Mount Everest Without Oxygen?");  
            jb[0].setText("Junko Tabei");jb[1].setText("Reinhold Messner");jb[2].setText("Peter Habeler");jb[3].setText("Phu Dorji");  
        }  
        if(current==3)  
        {  
            l.setText("4. Who built the Jama Masjid?");  
            jb[0].setText("Jahangir");jb[1].setText("Akbar");jb[2].setText("Imam Bukhari");jb[3].setText("Shah Jahan");  
        }  
        if(current==4)  
        {  
            l.setText("5. Who wrote the Indian National Anthem?");  
            jb[0].setText("Bakim Chandra Chatterji");jb[1].setText("Rabindranath Tagore");jb[2].setText("Swami Vivekanand");jb[3].setText("None of the above");  
        }  
        if(current==5)  
        {  
            l.setText("6. Who was the first Indian Scientist to win a Nobel Prize?");  
            jb[0].setText("CV Raman");jb[1].setText("Amartya Sen");jb[2].setText("Hargobind Khorana");jb[3].setText("Subramanian Chrandrashekar");  
        }  
        if(current==6)  
        {  
            l.setText("7. Who is the first Indian to win a Nobel Prize?");  
            jb[0].setText("Rabindranath Tagore");jb[1].setText(" CV Raman");jb[2].setText("Mother Theresa");  jb[3].setText("Hargobind Khorana");  
        }  
        if(current==7)  
        {  
            l.setText("8. Who was the first Indian woman to win the Miss World Title?");  
            jb[0].setText("Aishwarya Rai");jb[1].setText("Sushmita Sen");jb[2].setText("Reita Faria");  jb[3].setText("Diya Mirza");         
        }  
        if(current==8)  
        {  
            l.setText("9. Who was the first President of India?");  
            jb[0].setText("Abdul Kalam");jb[1].setText("Lal Bahadur Shastri");jb[2].setText("Dr. Rajendra Prasad");jb[3].setText("Zakir Hussain");  
        }  
        if(current==9)  
        {  
            l.setText("10. Who was the first Indian to win the Booker Prize?");  
            jb[0].setText("Dhan Gopal Mukerji");jb[1].setText("Nirad C. Chaudhuri");jb[2].setText("Arundhati Roy");  jb[3].setText("Aravind Adiga");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[0].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[3].isSelected());  
        if(current==4)  
            return(jb[1].isSelected());  
        if(current==5)  
            return(jb[0].isSelected());  
        if(current==6)  
            return(jb[0].isSelected());  
        if(current==7)  
            return(jb[2].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new Quiz("Welcome to the GK Quiz. Good Luck!");  
    }  
}  