SELECT mitarbeiter.mnr,
       mitarbeiter.name AS Nachname,
       projekt.name AS Projektname
  FROM mitarbeiter
       INNER JOIN
       mitarbeit_projekt ON mitarbeiter.mnr = mitarbeit_projekt.mnr
       INNER JOIN
       projekt ON mitarbeit_projekt.pnr = projekt.pnr
 WHERE Projektname LIKE 'Online Marketing';