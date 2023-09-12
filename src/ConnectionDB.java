

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private Connection conn = null;
	private String jdbc_url="jdbc:oracle:thin:@192.168.0.90:1521:air3"; //ip:post:DB명
	private String db_id="tokki";
	private String db_pwd="so";
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//1
			conn = DriverManager.getConnection(jdbc_url,db_id,db_pwd); //2.
			System.out.println("내 디비 성공적으로 로딩되었음@");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버를 찾을 수 없습니다.1 " + e.getMessage());
		}catch (SQLException se) {
			System.out.println("해당 드라이버를 찾을 수 없습니다.2");
		}
	}

	
	public static void main(String[] args) {
		new ConnectionDB().connect();
	}
}



