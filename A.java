package db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 2024-05-21
 * @author Schema <github.com/M-Schema>
 */

public class A {

	public static void main(String[] args) throws SQLException {
		// Lassen Sie alle Mitarbeiter ausgeben, deren Namen mit einem M beginnt 
		// und entweder in der Abteilung A10 oder A15 arbeiten. 
		
		DBHandler db;
		db = new DBHandler("Mitarbeiter.db");

		String sql = "SELECT * "
				+ "  FROM mitarbeiter "
				+ " WHERE name LIKE 'm%' "
				+ "  AND (anr LIKE 'A10' OR anr LIKE 'A15') "
				;
		
		ResultSet rs = db.executeSelect(sql);

		if (rs.next() == false) {
			System.out.println("Kein DS vorhanden");
		} else {
			System.out.println("MNR \t NAME \t ANR");
			System.out.println("=====================");
			
			do {
				System.out.print(rs.getInt("mnr") + "\t ");
				System.out.print(rs.getString("name") + "\t ");
				System.out.print(rs.getString("anr") + "\t ");
				
				System.out.print("\n");
			} while (rs.next());
		}
	}
}