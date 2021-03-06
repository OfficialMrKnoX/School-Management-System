import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AdmissionFrame extends JFrame implements ActionListener{

            Container cont;
            JPanel jPanel;
            JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
            JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13;
            JRadioButton male,female;
            ButtonGroup bg;
            JComboBox classbox;
            JButton save;
            String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
            Connection conn;
	    PreparedStatement psmt;
            Statement stm2;
	    ResultSet rs2 ;
            String url="jdbc:oracle:thin:@localhost:1521:xe";
            String userName = "System";
            String password = "System";
            int pass,pass2,check1,check2;
            AdmissionFrame(){
                 cont = getContentPane();
                 setLayout(null);
                 setSize(600,550);
                 setTitle("SCHOOL MANAGEMENT SYSTEM");

                 jPanel = new JPanel();
                 jPanel.setLayout(null);
                 jPanel.setBounds(0,0,600,600);
                 setResizable(false);
                 jPanel.setBackground(new Color(0,162,232));
                 
                 JLabel logo = new JLabel(new ImageIcon("icons/logo.png"));
                 logo.setBounds(120,10,60,60);  
                   setIconImage(new ImageIcon("icons/logo.png").getImage());             
                 jPanel.add(logo);
                 JLabel heading = new JLabel("Admission Form ");
                 heading.setBounds(180,5,350,100);  
                 heading.setFont(new Font("Ravie",Font.BOLD,25));              
                 jPanel.add(heading);

                 /*******GUI******/
                 l1 = new JLabel("ID :");
                 l1.setBounds(70,80,50,25);
                 l2 = new JLabel("Name :");
                 l2.setBounds(70,120,50,25);
                 l3 = new JLabel("Father Name :");
                 l3.setBounds(70,160,100,25);
                 l4 = new JLabel("Religion :");
                 l4.setBounds(70,200,100,25);
                 l5 = new JLabel("Nationality :");
                 l5.setBounds(280,200,100,25);
                 l6 = new JLabel("Address :");
                 l6.setBounds(70,240,100,25);
                 l7 = new JLabel("Mobile no :");
                 l7.setBounds(70,280,100,25);
                 l8 = new JLabel("City :");
                 l8.setBounds(280,280,100,25);
                 l9 = new JLabel("Gender :");
                 l9.setBounds(70,320,100,25);
                 l10 = new JLabel("Class :");
                 l10.setBounds(320,320,90,25);
                 l11 = new JLabel("D.O.B :");
                 l11.setBounds(70,360,100,25);
                 l12 = new JLabel("Admission Date :");
                 l12.setBounds(260,360,100,25);



                 ltf1 = new JTextField();
                 ltf1.setBounds(140,80,340,25);
                 ltf2 = new JTextField();
                 ltf2.setBounds(140,120,340,25);
                 ltf3 = new JTextField();
                 ltf3.setBounds(180,160,300,25);
                 ltf4 = new JTextField();
                 ltf4.setBounds(140,200,120,25);
                 ltf5 = new JTextField();
                 ltf5.setBounds(360,200,120,25);
                 ltf6 = new JTextField();
                 ltf6.setBounds(140,240,340,25);
                 ltf7 = new JTextField();
                 ltf7.setBounds(140,280,120,25);
                 ltf8 = new JTextField();
                 ltf8.setBounds(340,280,140,25);
                 ltf9 = new JTextField();
                 male = new JRadioButton("Male");
                 male.setBackground(new Color(0,162,232));
                 male.setBounds(140,320,60,25);
                 male.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                        	if(e.getItemSelectable()==male){
                                       ltf9.setText("Male");
                                }
                        } 
                 });

                 female = new JRadioButton("Female");
                 female.setBackground(new Color(0,162,232));
                 female.setBounds(220,320,80,25);
                 female.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                        	if(e.getItemSelectable()==female){
                                       ltf9.setText("Female");
                                }
                        } 
                 });
                 bg = new ButtonGroup();
                 bg.add(male);
                 bg.add(female);

                 ltf10 = new JTextField(); 
                 classbox = new JComboBox();
		 classbox.setBounds(360,320,120,25);
	       	 classbox.addItem("");
	         classbox.addItem("i");
	         classbox.addItem("ii");
	       	 classbox.addItem("iii");
	      	 classbox.addItem("iv");
		 classbox.addItem("v");
                 classbox.addItem("vi");
	         classbox.addItem("vii");
	       	 classbox.addItem("viii");
	      	 classbox.addItem("ix");
		 classbox.addItem("x");
		 classbox.addItem("xi");
                 classbox.addItem("xii");
		 classbox.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent i){
					if(i.getStateChange()==ItemEvent.SELECTED){
						ltf10.setText((String) i.getItem());
					}
				}
			});
                 ltf11 = new JTextField();
                 ltf11.setBounds(140,360,110,25);
                 ltf12 = new JTextField();
                 ltf12.setBounds(360,360,120,25);

                 save = new JButton("Save");
                 save.setBackground(new Color(0,255,255));
                 save.setBounds(70,420,410,25);
                 save.addActionListener(this);

                 jPanel.add(l1);
                 jPanel.add(l2);
                 jPanel.add(l3);
                 jPanel.add(l4);
                 jPanel.add(l5);
                 jPanel.add(l6);
                 jPanel.add(l7);
                 jPanel.add(l8);
                 jPanel.add(l9);
                 jPanel.add(l10);
                 jPanel.add(l11);
                 jPanel.add(l12);
                 

                 jPanel.add(ltf1);
                 jPanel.add(ltf2);
                 jPanel.add(ltf3);
                 jPanel.add(ltf4);
                 jPanel.add(ltf5);
                 jPanel.add(ltf6);                 
                 jPanel.add(ltf7);
                 jPanel.add(ltf8);
                 jPanel.add(male);
                 jPanel.add(female);
                 jPanel.add(classbox);
                 jPanel.add(ltf11);
                 jPanel.add(ltf12);
                 jPanel.add(save);
                 
                 cont.add(jPanel);
                 setLocationRelativeTo(null);
                 setVisible(true);
                 try{ Class.forName("oracle.jdbc.driver.OracleDriver");
                    }catch(Exception cnf){ JOptionPane.showMessageDialog(this,cnf,"Error",JOptionPane.ERROR_MESSAGE);}
                 
                
            }
   
     public void actionPerformed(ActionEvent e){
                  s1="";s2="";s3="";s4="";s5="";s6="";s7="";s8="";s9="";s10="";s11="";s12="";                       
                    if(e.getSource()== save){
                         s1 = ltf1.getText();
                         s2 = ltf2.getText();
                         s3 = ltf3.getText();
                         s4 = ltf4.getText();
                         s5 = ltf5.getText();
                         s6 = ltf6.getText();
                         s7 = ltf7.getText();
                         s8 = ltf8.getText();
                         s9 = ltf9.getText();
                         s10 = ltf10.getText();
                         s11 = ltf11.getText();
                         s12 = ltf12.getText(); pass=0;pass2=0;check1=0;check2=0;
                         if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty()||s8.isEmpty()||s9.isEmpty()||s10.isEmpty()||s11.isEmpty()||s12.isEmpty()){
                                JOptionPane.showMessageDialog(this,"Some field is empty !","Error",JOptionPane.ERROR_MESSAGE);                           
                         }else{ 
                                          try{
			              		conn = DriverManager.getConnection(url,userName,password);
						stm2=conn.createStatement();
						rs2=stm2.executeQuery("Select id from admission");
							while (rs2.next())
							{
								if(s1.equals(rs2.getString(1))){
									pass=1; 
									break;
								}
							} 
                                                conn.close();
                                             } catch(Exception e3){}
                                         String i = ltf7.getText();
					
					 String i2=ltf1.getText();
					for(int y=0;y<i.length(); ++y)
					{
						 if(i.length()<=9){ pass2=7; check2=1; }
						if(!Character.isDigit(i.charAt(y)))
							{  pass2=7; check2=1;  }
						if(i.length()>10)
							{ pass2=7; check2=1;  }
					}
					
					for(int y2=0;y2<i2.length(); ++y2)
					{
						
						if(!Character.isDigit(i2.charAt(y2)))
						{  pass2=7;  check1=1; }
					}

                                         if(pass==0){
                                              if(pass2==0){
                                         try {          
							conn = DriverManager.getConnection(url,userName,password);
							psmt =  conn.prepareStatement("insert into admission values(?,?,?,?,?,?,?,?,?,?,?,?)");
			                	        psmt.setString(1,s1);
							psmt.setString(2,s2);
							psmt.setString(3,s3);
                                                        psmt.setString(4,s4);
							psmt.setString(5,s5);
							psmt.setString(6,s6);
                                                        psmt.setString(7,s7);
							psmt.setString(8,s8);
							psmt.setString(9,s9);
                                                        psmt.setString(10,s10);
							psmt.setString(11,s11);
							psmt.setString(12,s12);	
							psmt.executeUpdate();
							JOptionPane.showMessageDialog(this,"Save Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setText("");ltf2.setText("");ltf3.setText("");ltf4.setText("");ltf5.setText("");ltf6.setText("");ltf7.setText("");
                                                        ltf8.setText("");ltf9.setText("Male");ltf10.setText("");ltf11.setText("");ltf12.setText("");
                                                        male.setSelected(true);
							female.setSelected(false);
                                                        classbox.setSelectedIndex(0);
							conn.close();

							}
						catch(Exception se){ JOptionPane.showMessageDialog(this,se,"Error",JOptionPane.ERROR_MESSAGE);}
                                                      }else{ if(check1==1){ JOptionPane.showMessageDialog(this,"Id only digits !","Error",JOptionPane.ERROR_MESSAGE);}
                                                             if(check2==1){ JOptionPane.showMessageDialog(this,"Invalid mobile no !","Error",JOptionPane.ERROR_MESSAGE);}
                                                       }
                                                }else{ JOptionPane.showMessageDialog(this,"Id already exist !","Error",JOptionPane.ERROR_MESSAGE);}









                      }
                    }

     }
    
     public static void main(String []args){
               new AdmissionFrame();
     }


}