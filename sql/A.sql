SELECT *
  FROM mitarbeiter
 WHERE name LIKE 'm%' AND 
       (anr LIKE 'A10' OR 
        anr LIKE 'A15');