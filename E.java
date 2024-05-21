package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class E {

	public static void main(String[] args) throws SQLException {
		// Lassen Sie alle Projekte ausgeben, an denen mindestens 3 Mitarbeiter mitarbeiten.

		DBHandler db;
		db = new DBHandler("Mitarbeiter.db");

		String sql = "SELECT projekt.pnr, "
				+ "       projekt.name AS Projektname, "
				+ "       COUNT(mitarbeit_projekt.mnr) AS Mitarbeiteranzahl "
				+ "  FROM projekt "
				+ "       LEFT OUTER JOIN "
				+ "       mitarbeit_projekt ON projekt.pnr = mitarbeit_projekt.pnr "
				+ " GROUP BY projekt.pnr "
				+ "HAVING Mitarbeiteranzahl >= 3 "
				;

		ResultSet rs = db.executeSelect(sql);

		if (rs.next() == false) {
			System.out.println("Kein DS vorhanden");
		} else {
			System.out.println("PNR \t PROJEKTNAME \t MITARBEITERANZAHL");
			System.out.println("======================================");

			do {
				System.out.print(rs.getInt("pnr") + "\t ");
				System.out.print(rs.getString("Projektname") + "\t ");
				System.out.print(rs.getInt("Mitarbeiteranzahl") + "\t ");

				System.out.print("\n");
			} while (rs.next());
		}

	}
}