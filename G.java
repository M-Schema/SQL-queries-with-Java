package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @version 2024-05-21
 * @author Schema <github.com/M-Schema>
 */

public class G {

	public static void main(String[] args) throws SQLException {
		/* Es wird eine Projektnummer eingegeben (1 oder 2).  
		 * Ausgegeben wird der Projektname und die Anzahl der Mitarbeiter, die an dem Projekt arbeiten. 
		 * 
		 * Außerdem wird eine Liste aller am Projekte arbeitenden Mitarbeiter mit Mitarbeiternummer,  
		 * Name des Mitarbeiters und die Prozentzahl, mit welcher er an dem Projekt arbeitet, ausgegeben. 
		 */

		DBHandler db;
		db = new DBHandler("Mitarbeiter.db");
		
		String input = JOptionPane.showInputDialog("Projektnummer eingeben (1 oder 2)");

		String sql = "SELECT projekt.name AS Projektname, "
				+ "       COUNT(mitarbeit_projekt.mnr) AS Mitarbeiteranzahl "
				+ "  FROM mitarbeit_projekt "
				+ "       INNER JOIN "
				+ "       projekt ON mitarbeit_projekt.pnr = projekt.pnr "
				+ " WHERE projekt.pnr LIKE '" + input + "' "
				+ " GROUP BY Projektname "
				;

		ResultSet rs = db.executeSelect(sql);

		if (rs.next() == false) {
			System.out.println("Kein DS vorhanden");
		} else {
			System.out.println("Projektname \t Mitarbeiteranzahl");
			System.out.println("======================================");

			do {
				System.out.print(rs.getString("Projektname") + "\t ");
				System.out.print(rs.getInt("Mitarbeiteranzahl") + "\t ");

				System.out.print("\n\n");
			} while (rs.next());
		}

		
		sql = "    SELECT mitarbeit_projekt.mnr, "
				+ "       mitarbeiter.name AS Nachname, "
				+ "       mitarbeit_projekt.prozent_arbzeit AS ProzentArbeitszeit "
				+ "  FROM mitarbeit_projekt "
				+ "       INNER JOIN "
				+ "       projekt ON mitarbeit_projekt.pnr = projekt.pnr "
				+ "       INNER JOIN "
				+ "       mitarbeiter ON mitarbeit_projekt.mnr = mitarbeiter.mnr "
				+ " WHERE projekt.pnr LIKE '" + input + "' "
				+ " ORDER BY mitarbeit_projekt.mnr ASC"
				; 

		rs = db.executeSelect(sql);

		if (rs.next() == false) {
			System.out.println("Kein DS vorhanden");
		} else {
			System.out.println("MNR \t Nachname \t ProzentArbeitszeit");
			System.out.println("======================================");

			do {
				System.out.print(rs.getString("MNR") + "\t");
				System.out.print(rs.getString("Nachname") + "\t");
				System.out.print(rs.getInt("ProzentArbeitszeit") + "\t");

				System.out.print("\n\n");
			} while (rs.next());
		}

	}
}