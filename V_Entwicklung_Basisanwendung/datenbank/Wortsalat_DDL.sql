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

CREATE TABLE IF NOT EXISTS Wortliste
(
  wortliste_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  name VARCHAR(100) NOT NULL,
  UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS Schwierigkeit
(
  schwierigkeit_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  name VARCHAR(100) NOT NULL,
  UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS Wort
(
  wort_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  name VARCHAR(100) NOT NULL,
  wortliste_id INTEGER,
  FOREIGN KEY (wortliste_id) REFERENCES Wortliste(wortliste_id),
  UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS Benutzer
(
  benutzer_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  login VARCHAR(100) NOT NULL,
  passwort VARCHAR(100) NOT NULL,
  vorname VARCHAR(100) NOT NULL,
  nachname VARCHAR(100) NOT NULL,
  maximale_Spielzeit INTEGER NOT NULL,
  eltern_id INTEGER,
  wortliste_id INTEGER,
  lehrer_id INTEGER,
  FOREIGN KEY (eltern_id) REFERENCES Eltern(eltern_id),
  FOREIGN KEY (wortliste_id) REFERENCES Wortliste(wortliste_id),
  FOREIGN KEY (lehrer_id) REFERENCES Lehrer(lehrer_id),
  UNIQUE (login)
);

CREATE TABLE IF NOT EXISTS Sitzung
(
  sitzung_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  spielBeginn BIGINT NOT NULL,
  spielEnde BIGINT NOT NULL,
  richtigeWorte INTEGER NOT NULL,
  falscheWorte INTEGER NOT NULL,
  benutzer_id INTEGER NOT NULL,
  schwierigkeit_id INTERGER NOT NULL,
  FOREIGN KEY (benutzer_id) REFERENCES Benutzer(benutzer_id),
  FOREIGN KEY (schwierigkeit_id) REFERENCES Schwierigkeit(schwierigkeit_id)
);