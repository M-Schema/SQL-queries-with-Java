SELECT projekt.pnr,
       projekt.name AS Projektname,
       COUNT(mitarbeit_projekt.mnr) AS Mitarbeiteranzahl
  FROM projekt
       LEFT OUTER JOIN
       mitarbeit_projekt ON projekt.pnr = mitarbeit_projekt.pnr
 GROUP BY projekt.pnr
HAVING Mitarbeiteranzahl >= 3;
