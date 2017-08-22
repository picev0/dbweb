package websample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class SelectServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,
					    HttpServletResponse response)
				throws ServletException, IOException {

			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter outPrintWriter = response.getWriter();

			String sql = "SELECT * FROM 商品マスタ";

			Connection connection = null;
			Statement statement = null;

			try {

				connection = DBManager.getConnection();
				statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				List list = new ArrayList();

				while(resultSet.next()) {

					Master master = new Master();
					master.setId(resultSet.getInt("商品ID"));
					master.setName(resultSet.getString("商品名"));
					master.setGroup(resultSet.getString("グループ名"));
					master.setPurchasePrice(resultSet.getString("仕入単価"));
					master.setWholesalePrice(resultSet.getString("卸単価"));

					list.add(master);

				}

				request.setAttribute("list", list);


			}catch(SQLException e) {
				throw new ServletException(e);
			}finally {

				if(statement != null) {
					try {
						statement.close();
					}catch(SQLException ignore) {

					}
				}
				if(connection != null) {
					try {
						connection.close();
					}catch(SQLException ignore) {

					}
				}
			}

			request.getRequestDispatcher("/websample/select.jsp").forward(request, response);


	}

}
