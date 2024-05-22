package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @version 2024-05-22
 * @author Schema <github.com/M-Schema>
 */

public class H {

	public static void main(String[] args) throws SQLException {
		/* Es wird eine Mitarbeiternummer eingegeben. 
		 * Anschließend werden alle Projekte mit Namen und Prozent der Arbeitszeit ausgegeben, 
		 * an der der Mitarbeiter mitarbeitet. 
		 */

		DBHandler db;
		String input, sql;
		ResultSet rs;
		
		db = new DBHandler("Mitarbeiter.db");
		input = JOptionPane.showInputDialog("Mitarbeiternummer eingeben:");

		sql = "SELECT mitarbeit_projekt.mnr AS MNR, "
				+ "       projekt.name AS Projektname, "
				+ "       mitarbeit_projekt.prozent_arbzeit AS ProzentArbeitszeit "
				+ "  FROM mitarbeit_projekt "
				+ "       INNER JOIN "
				+ "       projekt ON mitarbeit_projekt.pnr = projekt.pnr "
				+ " WHERE MNR LIKE '" + input + "' "
				;

		rs = db.executeSelect(sql);
		if (rs.next() == true) {
			System.out.print("Mitarbeiter: " + rs.getInt("MNR") + "\n");
			do {
				System.out.print("Projektname: " + rs.getString("Projektname") + "; \t ");
				System.out.print("Prozent Arbeitszeit: " + rs.getInt("ProzentArbeitszeit") + "\t ");

				System.out.print("\n");
			} while (rs.next());		
		} else {
			System.out.println("Kein DS vorhanden");
		}
	}
}