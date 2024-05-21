SELECT mitarbeit_projekt.mnr AS MNR,
       projekt.name AS Projektname,
       mitarbeit_projekt.prozent_arbzeit AS ProzentArbeitszeit
  FROM mitarbeit_projekt
       INNER JOIN
       projekt ON mitarbeit_projekt.pnr = projekt.pnr
 WHERE MNR LIKE '1';
