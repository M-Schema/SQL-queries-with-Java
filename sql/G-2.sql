SELECT mitarbeit_projekt.mnr,
       mitarbeiter.name AS Nachname,
       mitarbeit_projekt.prozent_arbzeit AS ProzentArbeitszeit
  FROM mitarbeit_projekt
       INNER JOIN
       projekt ON mitarbeit_projekt.pnr = projekt.pnr
       INNER JOIN
       mitarbeiter ON mitarbeit_projekt.mnr = mitarbeiter.mnr
 WHERE projekt.pnr LIKE '2'
 ORDER BY mitarbeit_projekt.mnr ASC;
