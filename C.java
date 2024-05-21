package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class C {

	public static void main(String[] args) throws SQLException {
		/* Lassen Sie alle Mitarbeiter mit ihrer MNr, dem Namen und 
		 * den Nummern der Projekte, an denen sie mitarbeiten, ausgeben. 
		 * Auch die Mitarbeiter, die an keinem Projekt  mitarbeiten, 
		 * sollen mit ausgegeben werden. 
		 * Die Ausgabe soll nach dem Namen sortiert ausgegeben werden. 
		 */

		DBHandler db;
		db = new DBHandler("Mitarbeiter.db");

		String sql = "SELECT mitarbeiter.mnr, "
				+ "       mitarbeiter.name AS Nachname, "
				+ "       mitarbeit_projekt.pnr AS Projektnummer "
				+ "  FROM mitarbeiter "
				+ "       LEFT OUTER JOIN "
				+ "       mitarbeit_projekt ON mitarbeiter.mnr = mitarbeit_projekt.mnr "
				+ " ORDER BY Nachname ASC "
				;

		ResultSet rs = db.executeSelect(sql);

		if (rs.next() == false) {
			System.out.println("Kein DS vorhanden");
		} else {
			System.out.println("MNR \t NACHNAME \t PROJEKTNUMMER");
			System.out.println("======================================");

			do {
				System.out.print(rs.getInt("mnr") + "\t");
				System.out.print(rs.getString("Nachname") + "\t");
				System.out.print(rs.getInt("Projektnummer") + "\t");

				System.out.print("\n");
			} while (rs.next());
		}

	}
}