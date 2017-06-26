CREATE TABLE IF NOT EXISTS Typ
(
  typ_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  bezeichnung VARCHAR(100) NOT NULL,
  UNIQUE (bezeichnung)
);

CREATE TABLE IF NOT EXISTS Administrator
(
  administrator_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  login VARCHAR(100) NOT NULL,
  passwort VARCHAR(100) NOT NULL,
  typ_id INTEGER NOT NULL,
  FOREIGN KEY (typ_id) REFERENCES Typ(typ_id),
  UNIQUE (login)
);

CREATE TABLE IF NOT EXISTS Benutzer
(
  benutzer_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  login VARCHAR(100) NOT NULL,
  passwort VARCHAR(100) NOT NULL,
  vorname VARCHAR(100) NOT NULL,
  nachname VARCHAR(100) NOT NULL,
  eltern_id INTEGER,
  lehrer_id INTEGER,
  FOREIGN KEY (eltern_id) REFERENCES Administrator(administrator_id),
  FOREIGN KEY (lehrer_id) REFERENCES Administrator(administrator_id),
  UNIQUE (login)
);