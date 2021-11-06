DROP DATABASE myDB;
CREATE DATABASE myDB;
USE myDB;

CREATE TABLE Gruppe (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    Beschreibung VARCHAR(64),
    PRIMARY KEY(Identifier)
);

CREATE TABLE GruppeMerkmal (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    GruppeIdentifier INTEGER NOT NULL,
    Schluessel VARCHAR(10) NOT NULL,
    Wert VARCHAR(32) NOT NULL,
    FOREIGN KEY(GruppeIdentifier) REFERENCES Gruppe(Identifier),
    PRIMARY KEY(Identifier )
);

CREATE TABLE GruppeMerkmalBeschreibung (
     Identifier INTEGER NOT NULL AUTO_INCREMENT,
     GruppeMerkmalIdentifier INTEGER NOT NULL,
     Beschreibung VARCHAR(128) NOT NULL,
     Sprache INTEGER NOT NULL,
     PRIMARY KEY(Identifier ),
     FOREIGN KEY(Sprache) REFERENCES GruppeMerkmal(Identifier),
     FOREIGN KEY(GruppeMerkmalIdentifier) REFERENCES GruppeMerkmal(Identifier)
);

CREATE TABLE Kunde (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    Nummer VARCHAR(10) NOT NULL,
    Name VARCHAR(32) NOT NULL,
    Vorname VARCHAR(32) NOT NULL,
    TelefonNummer VARCHAR(16) NOT NULL,
    EMailAdresse VARCHAR(32) NOT NULL,
    Passwort VARCHAR(16) NOT NULL,
    Zustand INTEGER NOT NULL,
    Sprache INTEGER NOT NULL,
    PRIMARY KEY(Identifier ),
    FOREIGN KEY(Sprache) REFERENCES GruppeMerkmal(Identifier),
    FOREIGN KEY(Zustand) REFERENCES GruppeMerkmal(Identifier)
);

CREATE TABLE ZahlungsArt (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    KundeIdentifier INTEGER NOT NULL,
    ZahlungsArt INTEGER NOT NULL,
    NummerKreditkarte VARCHAR(24),
    VerfallKreditkarte VARCHAR(8),
    FOREIGN KEY(KundeIdentifier) REFERENCES Kunde(Identifier),
    PRIMARY KEY(Identifier),
    FOREIGN KEY(ZahlungsArt) REFERENCES GruppeMerkmal(Identifier)
);

CREATE TABLE Adresse (
   Identifier INTEGER NOT NULL AUTO_INCREMENT,
   KundeIdentifier INTEGER NOT NULL,
   Strasse VARCHAR(32) NOT NULL,
   Postleitzahl VARCHAR(10) NOT NULL,
   Ort VARCHAR(32) NOT NULL,
   FOREIGN KEY(KundeIdentifier) REFERENCES Kunde(Identifier),
   PRIMARY KEY(Identifier)
);

CREATE TABLE Bestellung (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    KundeIdentifier INTEGER NOT NULL,
    EmpfaengerName VARCHAR(32),
    EmpfaengerVorname VARCHAR(32),
    EmpfaengerAddresse VARCHAR(64),
    EmpfaengerPostleitzahl VARCHAR(10),
    EmpfaengerOrt VARCHAR(32),
    EmpfaengerZahlungsArt VARCHAR(2),
    EmpfaengerNummerKreditkarte VARCHAR(16),
    EmpfaengerVerfallKreditkarte VARCHAR(8),
    DatumBestellung INTEGER,
    DatumAuslierferung INTEGER,
    Zustand VARCHAR(2),
    PRIMARY KEY(Identifier),
    FOREIGN KEY(KundeIdentifier) REFERENCES Kunde(Identifier)
);

CREATE TABLE BestellungPosition (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    BestellungIdentifier INTEGER NOT NULL,
    ArtikelIdentifier INTEGER NOT NULL,
    Beschreibung INTEGER NOT NULL,
    ArtikelNummer INTEGER NOT NULL,
    Reihenfolge INTEGER NOT NULL,
    AnzahlEinheiten INTEGER NOT NULL,
    PreisProEinheit INTEGER NOT NULL,
    PRIMARY KEY(Identifier),
    FOREIGN KEY(BestellungIdentifier) REFERENCES Bestellung(Identifier)
);

CREATE TABLE Artikel (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    Nummer VARCHAR(10) NOT NULL ,
    ArtikelArt INTEGER NOT NULL,
    Einheit INTEGER NOT NULL,
    Zustand INTEGER NOT NULL,
    Konfigurator VARCHAR(56) NOT NULL,
    FOREIGN KEY(Zustand) REFERENCES GruppeMerkmal(Identifier),
    PRIMARY KEY(Identifier ),
    FOREIGN KEY(Einheit) REFERENCES GruppeMerkmal(Identifier),
    FOREIGN KEY(ArtikelArt) REFERENCES GruppeMerkmal(Identifier)
);

CREATE TABLE ArtikelMerkmal (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    ArtikelIdentifier INTEGER NOT NULL,
    Schluessel VARCHAR(10) NOT NULL,
    Wert VARCHAR(32) NOT NULL,
    FOREIGN KEY(ArtikelIdentifier) REFERENCES Artikel(Identifier),
    PRIMARY KEY(Identifier)
);

CREATE TABLE ArtikelBeschreibung (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    ArtikelIdentifier INTEGER NOT NULL,
    Sprache INTEGER NOT NULL,
    Beschreibung VARCHAR(128) NOT NULL,
    FOREIGN KEY(Sprache) REFERENCES GruppeMerkmal(Identifier),
    FOREIGN KEY(ArtikelIdentifier) REFERENCES Artikel(Identifier),
    PRIMARY KEY(Identifier)
);

CREATE TABLE BestellungPositionMerkmal (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    BestellungPositionIdentifier INTEGER NOT NULL ,
    Schluessel VARCHAR(10) NOT NULL,
    Wert VARCHAR(32) NOT NULL,
    FOREIGN KEY(BestellungPositionIdentifier) REFERENCES BestellungPosition(Identifier),
    PRIMARY KEY(Identifier )
);

CREATE TABLE PreisProEinheit (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    ArtikelIdentifier INTEGER NOT NULL,
    GueltigVon INTEGER NOT NULL,
    GueltigBis INTEGER NOT NULL,
    Preis NUMERIC NOT NULL,
    FOREIGN KEY(ArtikelIdentifier) REFERENCES Artikel(Identifier),
    PRIMARY KEY(Identifier )
);

CREATE TABLE Lager (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    Beschreibung VARCHAR(128) NOT NULL,
    PRIMARY KEY(Identifier )
);

CREATE TABLE Lagerbestand (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    LagerIdentifier INTEGER NOT NULL,
    ArtikelIdentifier INTEGER NOT NULL,
    VerfuegbareEinheiten NUMERIC NOT NULL,
    PRIMARY KEY(Identifier ),
    FOREIGN KEY(LagerIdentifier) REFERENCES Lager(Identifier),
    FOREIGN KEY(ArtikelIdentifier) REFERENCES Artikel(Identifier)
);

CREATE TABLE Rechnung (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    KundeIdentifier INTEGER NOT NULL,
    EmpfaengerName VARCHAR(32) NOT NULL,
    EmpfaengerVorname VARCHAR(32) NOT NULL,
    EmpfaengerAdresse VARCHAR(64) NOT NULL,
    EmpfaengerPostleitzahl VARCHAR(10) NOT NULL,
    EmpfaengerOrt VARCHAR(32) NOT NULL,
    DatumRechung INTEGER NOT NULL,
    PRIMARY KEY(Identifier),
    FOREIGN KEY(KundeIdentifier) REFERENCES Kunde(Identifier)
);

CREATE TABLE RechnungPosition (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    RechnungIdentifier INTEGER NOT NULL,
    Beschreibung VARCHAR(128) NOT NULL,
    ArtikelNummer VARCHAR(10) NOT NULL,
    PreisProEinheit NUMERIC NOT NULL,
    Reihenfolge INTEGER NOT NULL,
    AnzahlEinheiten NUMERIC NOT NULL,
    FOREIGN KEY(RechnungIdentifier) REFERENCES Rechnung(Identifier),
    PRIMARY KEY(Identifier )
);

CREATE TABLE RechnungPositionMerkmal (
    Identifier INTEGER NOT NULL AUTO_INCREMENT,
    RechnungPositionIdentifier INTEGER NOT NULL,
    Beschreibung VARCHAR(128) NOT NULL,
    Schluessel VARCHAR(10) NOT NULL,
    Wert VARCHAR(32) NOT NULL,
    FOREIGN KEY(RechnungPositionIdentifier) REFERENCES RechnungPosition(Identifier),
    PRIMARY KEY(Identifier)
);

INSERT INTO Gruppe (Beschreibung) VALUES ('Zustand');
INSERT INTO Gruppe (Beschreibung) VALUES ('Sprache');
INSERT INTO Gruppe (Beschreibung) VALUES ('ZahlungsArt');
INSERT INTO Gruppe (Beschreibung) VALUES ('ArtikelArt');
INSERT INTO Gruppe (Beschreibung) VALUES ('Einheit');

INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (1,'A','Aktiv');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (1,'G','Gesperrt');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (2,'DE','Deutsch');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (2,'IT','Italiano');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (2,'FR','Français');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (2,'EN','English');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (3,'RE','Rechnung elektronisch');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (3,'KK','Kreditkarte');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (4,'EK','Elektronik');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (4,'SH','Schlauch');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (4,'BS','Bewässerungsspitze');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (4,'SH','Schlauch');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (4,'TI','Topf, internes Reservoir');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (4,'TE','Topf, externe Wasserzufuhr');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (5,'STK','Stück');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (5,'mm','Millimeter');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (5,'m','Meter');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (5,'mm3','Kubikmillimeter');

INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (1, 9, 15, 1, 'konfiguratorKontrolleinheit.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (2, 9, 15, 1, 'konfiguratorPumpeneinheit.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (3, 10, 15, 1, 'konfiguratorSchlauch.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (4, 11, 15, 1, 'konfiguratorBewaesserungsSpitze.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (5, 13, 15, 1, 'konfiguratorTopfKreisInternesReservoir.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (6, 13, 15, 1, 'konfiguratorTopfQuadratInternesReservoir.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (7, 13, 15, 1, 'konfiguratorTopfRechteckInternesReservoir.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (8, 13, 15, 1, 'konfiguratorTopfDreieckInternesReservoir.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (9, 14, 15, 1, 'konfiguratorTopfKreisExterneWasserzufuhr.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (10, 14, 15, 1, 'konfiguratorTopfQuadratExterneWasserzufuhr.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (11, 14, 15, 1, 'konfiguratorTopfRechtecExterneWasserzufuhr.xhtml');
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (12, 14, 15, 1, 'konfiguratorTopfDreieckExterneWasserzufuhr.xhtml');

INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (1, 3, 'Steuerungseinheit');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (2, 3, 'Pumpeneinheit');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (3, 3, 'Schlauch');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (4, 3, 'Bewässerungsspitze');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (5, 3, 'Topf, rund, internes Reservoir');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (6, 3, 'Topf, quadratisch, internes Reservoir');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (7, 3, 'Topf, rechteckig, internes Reservoir');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (8, 3, 'Topf, dreieckig, internes Reservoir');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (9, 3, 'Topf, rund, externe Wasserzufuhr');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (10, 3, 'Topf, quadratisch, externe Wasserzufuhr');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (11, 3, 'Topf, rechteckig, externe Wasserzufuhr');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (12, 3, 'Topf, dreieckig, externe Wasserzufuhr');

INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('1', 'Duck', 'Donald', '033 333 33 33', 'donald.duck@disney.com', 1, 3, 'donald');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('2', 'Duck', 'Daisy', '011 111 11 11', 'daisy.duck@disney.com', 1, 3, 'daisy');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('3', 'Duck', 'Dagobert', '022 222 22 22', 'dagobert.duck@disney.com', 1, 3, 'dagobert');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('4', 'Duck', 'Trick', '033 333 33 33', 'trick.duck@disney.com', 1, 4, 'trick');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('4', 'Duck', 'Tick', '033 333 33 33', 'trik.duck@disney.com', 1, 4, 'tick');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('4', 'Duck', 'Track', '033 333 33 33', 'track.duck@disney.com', 1, 4, 'track');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('4', 'Duck', 'Oma', '044 444 44 44', 'oma.duck@disney.com', 1, 3, 'oma');
