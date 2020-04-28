import java.io.File;
import java.io.FileInputStream;//��ȡ���ݵ�ԭʼ�ֽ���
import java.io.FileNotFoundException;//�ļ�ʧ��ʱ�������쳣
import java.io.FileOutputStream;//FileOutputStream������һ���ı��ļ�д����.����д������ͼ������֮���ԭʼ�ֽڵ���
import java.io.IOException;//����I/O ����ʱ�������쳣
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*��Ҫ����:1.�ļ��Ķ�ȡ
          2.�ļ���д��
          3�ļ�������ʱ����  */

public class XieruDuqu {         
	private ObjectInputStream ois = null;     //�������ݶ���
	private ObjectOutputStream oos = null;     //��������д��
	private List<User> lstUsers = new ArrayList<User>();
	private String fileName = null;
	
	/*public static void main(String[] args){System.out.print("XieruDuqu");} */
	
	public XieruDuqu(String fileName){
			this.fileName = fileName; 
	}
	
	@SuppressWarnings("unchecked")  //����ĳЩ����ʱ�ľ�����Ϣ ��ǿ������ת����ʱ���������������� ����@SuppressWarnings("unchecked")�Ͳ��ᾯ����
	public  List<User> getUsers(){
		try {
			  ois = new ObjectInputStream(new FileInputStream(fileName));		//���û���Ϣ��ȡ
			  lstUsers =  (ArrayList<User>)ois.readObject();
			  ois.close();
		   }catch(FileNotFoundException e){
			   intRecord();
		  } catch (ClassNotFoundException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();		
		  }
		 return lstUsers;
   }
	                                                                               //���û���Ϣд��
	public void save(User user){
		try {
			oos = new ObjectOutputStream(new FileOutputStream("config/telephone.dat"));
			int i;
			for( i = 0;i < lstUsers.size();i++){
//				if(user.getNo().equals(lstUsers.get(i).getNo())){
//					lstUsers.set(i, user);//�޸�
//					break;
//				}
			}
			if(i >= lstUsers.size()){
			    lstUsers.add(user);//����
			}
			oos.writeObject(lstUsers);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* ��telephone�ļ�������,���ʼ����¼�ļ�*/
	private void intRecord(){
		//�����ļ�
		File f = new File("config/telephone.dat");
		try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//�½�һ����¼
		User u = new User();
		u.setNo("1");
		u.setName("�����û���");
		u.setAge(0);
		u.setSex("M");
		u.setPhone("������绰����");
		u.setImagePath("����ͼƬ·��");
		try {
			oos = new ObjectOutputStream(new FileOutputStream("config/telephone.dat"));
			lstUsers.add(u);
			oos.writeObject(lstUsers);
			oos.close();

            JOptionPane.showMessageDialog(null, "������������");
            System.exit(0);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
