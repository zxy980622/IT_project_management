
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Test {
	private ObjectOutputStream oos = null;
	private List<User> lstUsers = new ArrayList<User>();
	User u = null;
	User u2 = null;
	User u3 = null;

	public Test() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream("config/telephone.dat"));
			u = new User();
			u.setNo("1");
			u.setName("1");
			u.setSex("M");
			u.setAge(1);
			u.setPhone("123");
			u.setImagePath("config/demo.jpg");
			lstUsers.add(u);
			u2 = new User();
			u2.setNo("2");
			u2.setName("2");
			u2.setSex("F");
			u2.setAge(1);
			u2.setPhone("321");
			u2.setImagePath("config/demo.jpg");
			lstUsers.add(u2);
			u3 = new User();
			u3.setNo("3");
			u3.setName("3");
			u3.setSex("F");
			u3.setAge(3);
			u3.setPhone("333");
			u3.setImagePath("config/demo.jpg");
			lstUsers.add(u3);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		try {
			t.oos.writeObject(t.lstUsers);
			t.oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
