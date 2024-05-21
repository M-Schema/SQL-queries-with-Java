SELECT mitarbeiter.mnr,
       mitarbeiter.name AS Nachname,
       projekt.pnr AS Projektnummer 
  FROM mitarbeiter
       LEFT OUTER JOIN
       mitarbeit_projekt ON mitarbeiter.mnr = mitarbeit_projekt.mnr
 WHERE mitarbeit_projekt.pnr = 1
 ORDER BY Nachname ASC;
