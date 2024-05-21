SELECT mitarbeiter.mnr,
       mitarbeiter.name AS Nachname,
       COUNT(mitarbeit_projekt.pnr) AS Projektanzahl
  FROM mitarbeiter
       LEFT OUTER JOIN
       mitarbeit_projekt ON mitarbeiter.mnr = mitarbeit_projekt.mnr
 GROUP BY mitarbeiter.mnr;
