package websample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager{

	public static Connection getConnection() {

		        //ユーザ名
				String user = "SYS as sysdba";

				//パスワード
				String pass = "oracle";

				//サーバ名
				String servername = "127.0.0.1";

				//SID
				String sid = "orcl";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@" + servername + ":1521:" + sid, user , pass);

			return connection;
		}catch(Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static void main(String[] args) throws Exception {

		Connection connection = getConnection();
		System.out.println("con=" + connection);
		connection.close();
	}
}