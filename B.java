package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class B {

	public static void main(String[] args) throws SQLException {
		// Lassen Sie alle Mitarbeiter ausgeben, die am Projekt Online Marketing mitarbeiten. 

		DBHandler db;
		db = new DBHandler("Mitarbeiter.db");

		String sql = "SELECT mitarbeiter.mnr, "
				+ "       mitarbeiter.name AS Nachname, "
				+ "       projekt.name AS Projektname "
				+ "  FROM mitarbeiter "
				+ "       INNER JOIN "
				+ "       mitarbeit_projekt ON mitarbeiter.mnr = mitarbeit_projekt.mnr "
				+ "       INNER JOIN "
				+ "       projekt ON mitarbeit_projekt.pnr = projekt.pnr "
				+ " WHERE Projektname LIKE 'Online Marketing' "
				;

		ResultSet rs = db.executeSelect(sql);

		if (rs.next() == false) {
			System.out.println("Kein DS vorhanden");
		} else {
			System.out.println("MNR \t NACHNAME \t PROJEKTNAME");
			System.out.println("====================================");

			do {
				System.out.print(rs.getInt("mnr") + "\t ");
				System.out.print(rs.getString("Nachname") + "\t ");
				System.out.print(rs.getString("Projektname") + "\t ");

				System.out.print("\n");
			} while (rs.next());
		}

	}
}