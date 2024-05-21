package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class D {

	public static void main(String[] args) throws SQLException {
		/* Lassen Sie alle Mitarbeiter mit der Anzahl der Projekte ausgeben, an denen sie mitarbeiten.
		 * Auch die Mitarbeiter, die an keinem Projekt mitarbeiten, sollen mit ausgegeben werden. 
		 * Beachten Sie, dass für diese Mitarbeiter die Anzahl der Projekte 0 ist.
		 */

		DBHandler db;
		db = new DBHandler("Mitarbeiter.db");

		String sql = "SELECT mitarbeiter.mnr, "
				+ "       mitarbeiter.name AS Nachname, "
				+ "       COUNT(mitarbeit_projekt.pnr) AS Projektanzahl "
				+ "  FROM mitarbeiter "
				+ "       LEFT OUTER JOIN "
				+ "       mitarbeit_projekt ON mitarbeiter.mnr = mitarbeit_projekt.mnr "
				+ " GROUP BY mitarbeiter.mnr "
				;

		ResultSet rs = db.executeSelect(sql);

		if (rs.next() == false) {
			System.out.println("Kein DS vorhanden");
		} else {
			System.out.println("MNR \t NACHNAME \t PROJEKTANZAHL");
			System.out.println("======================================");

			do {
				System.out.print(rs.getInt("mnr") + "\t");
				System.out.print(rs.getString("Nachname") + "\t");
				System.out.print(rs.getInt("Projektanzahl") + "\t");

				System.out.print("\n");
			} while (rs.next());
		}

	}
}