CREATE TABLE IF NOT EXISTS Admin
(
  login VARCHAR(100) NOT NULL,
  passwort VARCHAR(100) NOT NULL,
  UNIQUE (login)
);

CREATE TABLE IF NOT EXISTS Eltern
(
  eltern_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  login VARCHAR(100) NOT NULL,
  passwort VARCHAR(100) NOT NULL,
  UNIQUE (login)
);

CREATE TABLE IF NOT EXISTS Lehrer
(
  lehrer_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  login VARCHAR(100) NOT NULL,
  passwort VARCHAR(100) NOT NULL,
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
  FOREIGN KEY (eltern_id) REFERENCES Eltern(eltern_id),
  FOREIGN KEY (lehrer_id) REFERENCES Lehrer(lehrer_id),
  UNIQUE (login)
);