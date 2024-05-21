package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class F {

	public static void main(String[] args) throws SQLException {
		// Lassen Sie pro Abteilung die Summe aller Gehälter der Mitarbeiter dieser Abteilung ausgeben.

		DBHandler db;
		db = new DBHandler("Mitarbeiter.db");

		String sql = "SELECT abteilung.anr, "
				+ "       abteilung.name AS Abteilung, "
				+ "       SUM(mitarbeiter.gehalt) AS Gesamtgehaelter "
				+ "  FROM mitarbeiter "
				+ "       INNER JOIN "
				+ "       abteilung ON mitarbeiter.anr = abteilung.anr "
				+ " GROUP BY abteilung.anr "
				;

		ResultSet rs = db.executeSelect(sql);

		if (rs.next() == false) {
			System.out.println("Kein DS vorhanden");
		} else {
			System.out.println("ANR \t Abteilung \t Gesamtgehaelter");
			System.out.println("======================================");

			do {
				System.out.print(rs.getString("anr") + "\t ");
				System.out.print(rs.getString("Abteilung") + "\t ");
				System.out.print(rs.getInt("Gesamtgehaelter") + "\t ");

				System.out.print("\n");
			} while (rs.next());
		}

	}
}