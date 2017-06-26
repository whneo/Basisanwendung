/* Die drei Admintypen in die Datenbank einfügen */
INSERT INTO Typ (bezeichnung)
SELECT 'Root'
WHERE NOT EXISTS(SELECT 1 FROM Typ WHERE bezeichnung = 'Root');

INSERT INTO Typ (bezeichnung)
SELECT 'Lehrer'
WHERE NOT EXISTS(SELECT 1 FROM Typ WHERE bezeichnung = 'Lehrer');

INSERT INTO Typ (bezeichnung)
SELECT 'Eltern'
WHERE NOT EXISTS(SELECT 1 FROM Typ WHERE bezeichnung = 'Eltern');

/* Einen RootAdmin in die Datenbank einfügen */
INSERT INTO Administrator (login, passwort, typ) 
SELECT 'root', 'root', '1' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'root');

/* Fünf Lehrer in die Datenbank einfügen */
INSERT INTO Administrator (login, passwort) 
SELECT 'lehrer1', 'lehrer1', '2' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'lehrer1');

INSERT INTO Administrator (login, passwort) 
SELECT 'lehrer2', 'lehrer2', '2' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'lehrer2');

INSERT INTO Administrator (login, passwort) 
SELECT 'lehrer3', 'lehrer3', '2'
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'lehrer3');

INSERT INTO Administrator (login, passwort) 
SELECT 'lehrer4', 'lehrer4', '2' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'lehrer4');

INSERT INTO Administrator (login, passwort) 
SELECT 'lehrer5', 'lehrer5', '2' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'lehrer5');

/* Fünf Eltern in die Datenbank einfügen */
INSERT INTO Administrator (login, passwort) 
SELECT 'eltern1', 'eltern1', '3' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'eltern1');

INSERT INTO Administrator (login, passwort) 
SELECT 'eltern2', 'eltern2', '3' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'eltern2');

INSERT INTO Administrator (login, passwort) 
SELECT 'eltern3', 'eltern3', '3' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'eltern3');

INSERT INTO Administrator (login, passwort) 
SELECT 'eltern4', 'eltern4', '3' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'eltern4');

INSERT INTO Administrator (login, passwort) 
SELECT 'eltern5', 'eltern5', '3' 
WHERE NOT EXISTS(SELECT 1 FROM Administrator WHERE login = 'eltern5');

/* Fünf Benutzer in die Datenbank einfügen */
INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer1', 'benutzer1', 'vorname1', 'nachname1', '7', '2'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer1');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer2', 'benutzer2', 'vorname2', 'nachname2', '8', '3'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer2');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer3', 'benutzer3', 'vorname3', 'nachname3', '9', '4'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer3');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer4', 'benutzer4', 'vorname4', 'nachname4', '10', '5'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer4');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer5', 'benutzer5', 'vorname5', 'nachname5', '11', '6'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer5');

/* Weitere Benutzer zum Testen der Benutzerverwaltung */
INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer6', 'benutzer6', 'vorname6', 'nachname6', '7', '2'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer6');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer7', 'benutzer7', 'vorname7', 'nachname7', '7', '2'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer7');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer8', 'benutzer8', 'vorname8', 'nachname8', '7', '2'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer8');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer9', 'benutzer9', 'vorname9', 'nachname9', '7', '2'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer9');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer10', 'benutzer10', 'vorname10', 'nachname10', '7', '2'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer10');
