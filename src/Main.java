import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	/*
	 * private String User; private String PASS; private String URL; private
	 * PreparedStatement ps;
	 */
	private static Statement st;
	private static ResultSet rs;

	public static void main(String[] args) throws SQLException {
		Connection c = Jdbc.getConnection();
		String SQL = "SELECT nombre, apellidos FROM USUARIOS";
		try {
			st = c.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				System.out.println(rs.getString("nombre") + rs.getString("apellidos"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			c.close();
		}
	}

}
