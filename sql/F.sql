SELECT abteilung.anr,
       abteilung.name AS Abteilung,
       SUM(mitarbeiter.gehalt) AS Gesamtgehaelter
  FROM mitarbeiter
       INNER JOIN
       abteilung ON mitarbeiter.anr = abteilung.anr
 GROUP BY abteilung.anr;
