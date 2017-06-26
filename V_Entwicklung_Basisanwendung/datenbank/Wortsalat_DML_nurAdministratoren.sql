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

/* Fünf Wortlisten in die Datenbank einfügen */
INSERT INTO Wortliste (name) 
SELECT 'Obst' 
WHERE NOT EXISTS(SELECT 1 FROM Wortliste WHERE name = 'Obst');

INSERT INTO Wortliste (name) 
SELECT 'Gem&uuml;se' 
WHERE NOT EXISTS(SELECT 1 FROM Wortliste WHERE name = 'Gem&uuml;se');

INSERT INTO Wortliste (name) 
SELECT 'Tiere' 
WHERE NOT EXISTS(SELECT 1 FROM Wortliste WHERE name = 'Tiere');

INSERT INTO Wortliste (name) 
SELECT 'Verben' 
WHERE NOT EXISTS(SELECT 1 FROM Wortliste WHERE name = 'Verben');

INSERT INTO Wortliste (name) 
SELECT 'Adjektive' 
WHERE NOT EXISTS(SELECT 1 FROM Wortliste WHERE name = 'Adjektive');

/* Drei Schwierigkeitsstufen in die Datenbank einfügen */
INSERT INTO Schwierigkeit (name)
SELECT 'leicht'
WHERE NOT EXISTS(SELECT 1 FROM Schwierigkeit WHERE name = 'leicht');

INSERT INTO Schwierigkeit (name)
SELECT 'mittel'
WHERE NOT EXISTS(SELECT 1 FROM Schwierigkeit WHERE name = 'mittel');

INSERT INTO Schwierigkeit (name)
SELECT 'schwer'
WHERE NOT EXISTS(SELECT 1 FROM Schwierigkeit WHERE name = 'schwer');

/* Fünf mal fünf Wörter in die Datenbank einfügen */
/* Obst */
INSERT INTO Wort (name, wortliste_id)
SELECT 'Apfel', '1'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Apfel');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Birne', '1'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Birne');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Banane', '1'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Banane');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Kirsche', '1'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Kirsche');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Erdbeere', '1'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Erdbeere');

/* Gemüse */
INSERT INTO Wort (name, wortliste_id)
SELECT 'Tomate', '2'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Tomate');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Gurke', '2'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Gurke');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Paprika', '2'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Paprika');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Karotte', '2'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Karotte');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Bohne', '2'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Bohne');

/* Tiere */
INSERT INTO Wort (name, wortliste_id)
SELECT 'Hund', '3'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Hund');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Katze', '3'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Katze');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Affe', '3'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Affe');

INSERT INTO Wort (name, wortliste_id)
SELECT 'Elefant', '3'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'Elefant');

INSERT INTO Wort (name, wortliste_id)
SELECT 'L&ouml;we', '3'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'L&ouml;we');

/* Verben */
INSERT INTO Wort (name, wortliste_id)
SELECT 'essen', '4'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'essen');

INSERT INTO Wort (name, wortliste_id)
SELECT 'laufen', '4'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'laufen');

INSERT INTO Wort (name, wortliste_id)
SELECT 'schlafen', '4'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'schlafen');

INSERT INTO Wort (name, wortliste_id)
SELECT 'trinken', '4'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'trinken');

INSERT INTO Wort (name, wortliste_id)
SELECT 'waschen', '4'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'waschen');

/* Adjektive */
INSERT INTO Wort (name, wortliste_id)
SELECT 'schnell', '5'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'schnell');

INSERT INTO Wort (name, wortliste_id)
SELECT 'langsam', '5'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'langsam');

INSERT INTO Wort (name, wortliste_id)
SELECT 'hoch', '5'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'hoch');

INSERT INTO Wort (name, wortliste_id)
SELECT 'klein', '5'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'klein');

INSERT INTO Wort (name, wortliste_id)
SELECT 'schwer', '5'
WHERE NOT EXISTS(SELECT 1 FROM Wort WHERE name = 'schwer');

/* Fünf Benutzer in die Datenbank einfügen */
INSERT INTO Benutzer(login, passwort, vorname, nachname, maximale_Spielzeit, eltern_id, wortliste_id, lehrer_id)
SELECT 'benutzer1', 'benutzer1', 'benutzer1', 'benutzer1', '60', '7', '1', '2'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer1');

INSERT INTO Benutzer(login, passwort, vorname, nachname, maximale_Spielzeit, eltern_id, wortliste_id, lehrer_id)
SELECT 'benutzer2', 'benutzer2', 'benutzer2', 'benutzer2', '60', '8', '2', '3'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer2');

INSERT INTO Benutzer(login, passwort, vorname, nachname, maximale_Spielzeit, eltern_id, wortliste_id, lehrer_id)
SELECT 'benutzer3', 'benutzer3', 'benutzer3', 'benutzer3', '60', '9', '3', '4'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer3');

INSERT INTO Benutzer(login, passwort, vorname, nachname, maximale_Spielzeit, eltern_id, wortliste_id, lehrer_id)
SELECT 'benutzer4', 'benutzer4', 'benutzer4', 'benutzer4', '60', '10', '4', '5'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer4');

INSERT INTO Benutzer(login, passwort, vorname, nachname, maximale_Spielzeit, eltern_id, wortliste_id, lehrer_id)
SELECT 'benutzer5', 'benutzer5', 'benutzer5', 'benutzer5', '60', '11', '5', '6'
WHERE NOT EXISTS(SELECT 1 FROM Benutzer WHERE login = 'benutzer5');