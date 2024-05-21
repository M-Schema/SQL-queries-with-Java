SELECT projekt.name AS Projektname,
       COUNT(mitarbeit_projekt.mnr) AS Mitarbeiteranzahl
  FROM mitarbeit_projekt
       INNER JOIN
       projekt ON mitarbeit_projekt.pnr = projekt.pnr
 WHERE projekt.pnr LIKE '2'
 GROUP BY Projektname;