package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import beans.Verse;

@Stateless
@Local(DataAccessInterface.class)
@LocalBean
@Alternative
public class DataAccessService implements DataAccessInterface {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String dbURL = "jdbc:mysql://localhost:3306/cst235benchmark?useSSL=false";
	String user = "root";
	String pass = "root";
	

	
	
	
	
	@Override
	public Verse findFirst(String word) {
		try {
			conn = DriverManager.getConnection(dbURL, user, pass);
			stmt = conn.prepareStatement("SELECT * FROM bible WHERE text LIKE ?");
	        stmt.setString(1, "%" + word + "%");
	        rs = stmt.executeQuery();
        	Verse verse = new Verse();
	        if(rs.next()) {
	        	verse.setBook_name(rs.getString("book"));
	        	verse.setChapter(rs.getInt("chapter"));
	        	verse.setVerse(rs.getInt("verse"));
	        	verse.setText(rs.getString("text"));
	        }
	        return verse;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
