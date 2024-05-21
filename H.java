package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @version 2024-05-21
 * @author Schema <github.com/M-Schema>
 */

public class H {

	public static void main(String[] args) throws SQLException {
		/* Es wird eine Mitarbeiternummer eingegeben. 
		 * Anschließend werden alle Projekte mit Namen und Prozent der Arbeitszeit ausgegeben, 
		 * an der der Mitarbeiter mitarbeitet. 
		 */

		DBHandler db;
		db = new DBHandler("Mitarbeiter.db");
		
		String input = JOptionPane.showInputDialog("Mitarbeiternummer eingeben:");

		String sql = "SELECT mitarbeit_projekt.mnr AS MNR, "
				+ "       projekt.name AS Projektname, "
				+ "       mitarbeit_projekt.prozent_arbzeit AS ProzentArbeitszeit "
				+ "  FROM mitarbeit_projekt "
				+ "       INNER JOIN "
				+ "       projekt ON mitarbeit_projekt.pnr = projekt.pnr "
				+ " WHERE MNR LIKE '" + input + "' "
				;

		ResultSet rs = db.executeSelect(sql);

		if (rs.next() == false) {
			System.out.println("Kein DS vorhanden");
		} else {
			System.out.println("MNR \t Projektname \t ProzentArbeitszeit");
			System.out.println("======================================");

			do {
				System.out.print(rs.getInt("MNR") + "\t ");
				System.out.print(rs.getString("Projektname") + "\t ");
				System.out.print(rs.getInt("ProzentArbeitszeit") + "\t ");

				System.out.print("\n");
			} while (rs.next());
		}

	}
}