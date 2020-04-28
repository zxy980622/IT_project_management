import java.awt.Color;
import java.awt.Container;
//import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.applet.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//class Lines extends Applet{
//    private static final long serialVersionUID = 1L;
//    public void paint(Graphics g){
//	    g.drawLine(90, 160, 151, 33);
//      }
//     }

 public class chaxun extends JFrame implements ActionListener{
	 private static final long serialVersionUID = 1L;
	
	  JButton btnClear ;//退出
      JButton btncx ;//查寻
    
      JButton  btnreturn ;
	
	JTextField txtNum;//编号
	JTextField txtName;//姓名
	JTextField txtAge ;//年龄
	JTextField txtTel;//联系方式
	JTextField txtTel2;
	JTextField txtName2;
	JLabel lblPhotoShow;
	
	/*查寻主窗体*/
	
	public chaxun(){
		  this.setTitle("通讯录");
			this.setSize(350, 430);
			this.setLocationRelativeTo(null);//窗口居中
			this.setResizable(false);
		                                                                                                                                                                                                                                                                                                                        
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container con = this.getContentPane();
			con.setLayout(null);
			
			JLabel lblNum = new JLabel("用户编号:");
			lblNum.setBounds(20, 20, 60, 25);//标签位置
			con.add(lblNum);
			txtNum = new JTextField();
			txtNum.setBounds(90, 20, 100, 25);//文本框位置
			txtNum.setEditable(false);
			con.add(txtNum);
			
			lblPhotoShow = new JLabel("            照片");
			lblPhotoShow.setBounds(233, 15, 95, 105);
			lblPhotoShow.setBorder(BorderFactory.createLineBorder(Color.gray));
			con.add(lblPhotoShow);
		
		JLabel lblName = new JLabel("姓        名:");
		lblName.setBounds(20, 55, 60, 25);
		con.add(lblName);
		txtName = new JTextField();
		txtName.setBounds(90, 55, 100, 25);
		con.add(txtName);
		
		JLabel lblName2 = new JLabel("输入姓名:");
		lblName2.setBounds(20, 175, 60, 25);
		con.add(lblName2);
		txtName2 = new JTextField();
		txtName2.setBounds(90,175, 100, 25);
		con.add(txtName2);

		JLabel lblAge = new JLabel("年        龄:");
		lblAge.setBounds(20, 90, 60, 25);
		con.add(lblAge);
		txtAge = new JTextField();
		txtAge.setBounds(90, 90, 50, 25);
		//txtAge.getDocument().addDocumentListener(new TextChange());
		con.add(txtAge);
		

		JLabel lblTel = new JLabel("联系方式:");
		lblTel.setBounds(20, 135, 60, 25);
		con.add(lblTel);
		txtTel = new JTextField();
		txtTel.setBounds(90, 135, 150, 25);
		//txtTel.getDocument().addDocumentListener(new TextChange());
		con.add(txtTel);
		
     

		JLabel lblTel1 = new JLabel("电话查询:");
		lblTel1.setBounds(20, 215, 60, 25);
		con.add(lblTel1);
		txtTel2 = new JTextField();
		txtTel2.setBounds(90, 215, 150, 25);
		//txtTel.getDocument().addDocumentListener(new TextChange());
		con.add(txtTel2);
		
		btncx=new JButton("查询");
	    btncx.setBounds(200, 275, 60, 25);
		con.add(btncx);
		
		 btnClear=new JButton("清空");
		 btnClear.setBounds(100, 275, 60, 25);
		con.add( btnClear);
	
		 btnreturn=new JButton("返回");
		 btnreturn.setBounds(10, 275, 60, 25);
		con.add(btnreturn);
		
		/*清空按钮*/
	btncx.addActionListener(this);
	btnClear.addActionListener(new ActionListener() {
		public void actionPerformed( ActionEvent e) {
			 txtNum.setText("");
			 txtTel2.setText("");
		      txtName.setText("");
		      txtAge.setText("");
		      txtTel.setText("");
		      txtName2.setText("");
		      lblPhotoShow.setIcon(new ImageIcon(""));
		}
		});
	
	/*返回按钮*/
	btnreturn.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e) {
				setVisible(false);
			new MainWindow();
			
			}
			});

		setVisible(true);
		

//	         public  void cx(User user){
//		
//	        	if(user.getName().equals(txtName.getText()) ){
//	        		txtNum.setText(user.getNo());
//	                txtName.setText(user.getName());
//	                txtAge.setText(user.getAge()+"");
//	                txtTel.setText(user.getPhone());
//	        	}else {
//	        	System.out.println("asdfdf");
//	        	}
	}
	 
	/*按姓名电话查寻*/
	 public void actionPerformed(ActionEvent e) {
	        	 if(e.getSource() == btncx){
	        		 AnNiu bo=new AnNiu();
	        		 if ("".equals(txtName2.getText().trim())&&("".equals(txtTel2.getText().trim())) ){
	        			
	     	           		JOptionPane.showMessageDialog(this, "用户姓名或电话输入一个进行查寻!");
	     	         
	        		 
	     	           		}
	     	           	    	
	        		   for(int i=0;i<bo.users.length;i++)
	        		 {
	        			 
	        			 if(bo.users[i].getName().equals(txtName2.getText()) ){ //比较姓名
	     	        		txtNum.setText(bo.users[i].getNo());
	     	                txtName.setText(bo.users[i].getName());
	     	                txtAge.setText(bo.users[i].getAge()+"");
	     	                txtTel.setText(bo.users[i].getPhone());
	     	                lblPhotoShow.setIcon(new ImageIcon(bo.users[i].getImagePath())); 
	     	                break;
	     	        	}else if(bo.users[i].getPhone().equals(txtTel2.getText())){//比较电话
	     	        		txtNum.setText(bo.users[i].getNo());
	     	                txtName.setText(bo.users[i].getName());
	     	                txtAge.setText(bo.users[i].getAge()+"");
	     	                txtTel.setText(bo.users[i].getPhone());
	     	               lblPhotoShow.setIcon(new ImageIcon(bo.users[i].getImagePath()));
	     	                break;

	     	        	} 
//	     	        	else if(e.getSource() == btnClear){
//	        			      txtNum.setText("");
//	        			      txtName.setText("");
//	        			      txtAge.setText("");
//	        			      txtTel.setText("");
//	        			      lblPhotoShow.setIcon(new ImageIcon(""));
//	        				 }
	        			 // System.out.print("asf");
	    	        	 
	        		 }}}}
	        		   
	        		
	     	        	
// public static void main(String args[])
//	{
//		new chaxun();
//	}};