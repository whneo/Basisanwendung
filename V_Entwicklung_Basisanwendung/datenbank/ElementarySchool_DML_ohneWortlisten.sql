/* Ein Admin in die Datenbank einfügen */
INSERT INTO Admin (login, passwort) 
SELECT 'admin', 'admin' 
WHERE NOT EXISTS(SELECT 1 FROM Admin WHERE login = 'admin');

/* Fünf Eltern in die Datenbank einfügen */
INSERT INTO Eltern (login, passwort) 
SELECT 'eltern1', 'eltern1' 
WHERE NOT EXISTS(SELECT 1 FROM Eltern WHERE login = 'eltern1');

INSERT INTO Eltern (login, passwort) 
SELECT 'eltern2', 'eltern2' 
WHERE NOT EXISTS(SELECT 1 FROM Eltern WHERE login = 'eltern2');

INSERT INTO Eltern (login, passwort) 
SELECT 'eltern3', 'eltern3' 
WHERE NOT EXISTS(SELECT 1 FROM Eltern WHERE login = 'eltern3');

INSERT INTO Eltern (login, passwort) 
SELECT 'eltern4', 'eltern4' 
WHERE NOT EXISTS(SELECT 1 FROM Eltern WHERE login = 'eltern4');

INSERT INTO Eltern (login, passwort) 
SELECT 'eltern5', 'eltern5' 
WHERE NOT EXISTS(SELECT 1 FROM Eltern WHERE login = 'eltern5');

/* Fünf Lehrer in die Datenbank einfügen */
INSERT INTO Lehrer (login, passwort) 
SELECT 'lehrer1', 'lehrer1' 
WHERE NOT EXISTS(SELECT 1 FROM Lehrer WHERE login = 'lehrer1');

INSERT INTO Lehrer (login, passwort) 
SELECT 'lehrer2', 'lehrer2' 
WHERE NOT EXISTS(SELECT 1 FROM Lehrer WHERE login = 'lehrer2');

INSERT INTO Lehrer (login, passwort) 
SELECT 'lehrer3', 'lehrer3' 
WHERE NOT EXISTS(SELECT 1 FROM Lehrer WHERE login = 'lehrer3');

INSERT INTO Lehrer (login, passwort) 
SELECT 'lehrer4', 'lehrer4' 
WHERE NOT EXISTS(SELECT 1 FROM Lehrer WHERE login = 'lehrer4');

INSERT INTO Lehrer (login, passwort) 
SELECT 'lehrer5', 'lehrer5' 
WHERE NOT EXISTS(SELECT 1 FROM Lehrer WHERE login = 'lehrer5');

/* Fünf Benutzer in die Datenbank einfügen */
INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer1', 'benutzer1', 'vorname1', 'nachname1', '1', '1'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer1');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer2', 'benutzer2', 'vorname2', 'nachname2', '2', '2'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer2');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer3', 'benutzer3', 'vorname3', 'nachname3', '3', '3'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer3');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer4', 'benutzer4', 'vorname4', 'nachname4', '4', '4'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer4');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer5', 'benutzer5', 'vorname5', 'nachname5', '5', '5'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer5');

/* Weitere Benutzer zum Testen der Benutzerverwaltung */
INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer6', 'benutzer6', 'vorname6', 'nachname6', '1', '1'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer6');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer7', 'benutzer7', 'vorname7', 'nachname7', '1', '1'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer7');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer8', 'benutzer8', 'vorname8', 'nachname8', '1', '1'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer8');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer9', 'benutzer9', 'vorname9', 'nachname9', '1', '1'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer9');

INSERT INTO Benutzer(login, passwort, vorname, nachname, eltern_id, lehrer_id)
SELECT 'benutzer10', 'benutzer10', 'vorname10', 'nachname10', '1', '1'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer10');
