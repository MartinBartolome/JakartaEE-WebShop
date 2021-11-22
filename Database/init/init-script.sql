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
                               Schluessel VARCHAR(16) NOT NULL,
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
                            DatumAuslieferung INTEGER,
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

CREATE TABLE ArtikelBeschreibung (
                                     Identifier INTEGER NOT NULL AUTO_INCREMENT,
                                     ArtikelIdentifier INTEGER NOT NULL,
                                     Sprache INTEGER NOT NULL,
                                     Beschreibung VARCHAR(128) NOT NULL,
                                     FOREIGN KEY(Sprache) REFERENCES GruppeMerkmal(Identifier),
                                     FOREIGN KEY(ArtikelIdentifier) REFERENCES Artikel(Identifier),
                                     PRIMARY KEY(Identifier)
);

CREATE TABLE ArtikelMerkmal (
                                Identifier INTEGER NOT NULL AUTO_INCREMENT,
                                ArtikelIdentifier INTEGER NOT NULL,
                                Schluessel VARCHAR(16) NOT NULL,
                                Wert VARCHAR(32) NOT NULL,
                                FOREIGN KEY(ArtikelIdentifier) REFERENCES Artikel(Identifier),
                                PRIMARY KEY(Identifier)
);

CREATE TABLE ArtikelMerkmalBeschreibung (
                                            Identifier INTEGER NOT NULL AUTO_INCREMENT,
                                            ArtikelMerkmalIdentifier INTEGER NOT NULL,
                                            Sprache INTEGER NOT NULL,
                                            Beschreibung VARCHAR(128) NOT NULL,
                                            FOREIGN KEY(Sprache) REFERENCES GruppeMerkmal(Identifier),
                                            FOREIGN KEY(ArtikelMerkmalIdentifier) REFERENCES myDB.ArtikelMerkmal(Identifier),
                                            PRIMARY KEY(Identifier)
);

CREATE TABLE BestellungPositionMerkmal (
                                           Identifier INTEGER NOT NULL AUTO_INCREMENT,
                                           BestellungPositionIdentifier INTEGER NOT NULL ,
                                           Schluessel VARCHAR(16) NOT NULL,
                                           Wert VARCHAR(32) NOT NULL,
                                           FOREIGN KEY(BestellungPositionIdentifier) REFERENCES BestellungPosition(Identifier),
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
INSERT INTO Gruppe (Beschreibung) VALUES ('BestellungKalkulation');

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
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (6,'VK','Versandkosten');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (6,'ST','MWST');
INSERT INTO GruppeMerkmal (GruppeIdentifier, Schluessel, Wert) VALUES (6,'BT','Bestellbetrag');
INSERT INTO GruppeMerkmalBeschreibung (GruppeMerkmalIdentifier, Beschreibung, Sprache) VALUES (16, 'Versandkosten', 3);
INSERT INTO GruppeMerkmalBeschreibung (GruppeMerkmalIdentifier, Beschreibung, Sprache) VALUES (17, 'Mehrwertsteuer', 3);
INSERT INTO GruppeMerkmalBeschreibung (GruppeMerkmalIdentifier, Beschreibung, Sprache) VALUES (18, 'Bestellbetrag', 3);
-- Merkmale Kontrolleinheit
-- I*=Info,
-- K*=Konfiguration
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (1, 9, 15, 1, 'KonfiguratorKontrolleinheit');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (1, 3, 'Steuerungseinheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'ILaenge','150');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (1, 3, 'Länge (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'IBreite','100');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (2, 3, 'Breite(mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'IHoehe','50');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (3, 3, 'Höhe (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'IGewicht','200');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (4, 3, 'Gewicht (g)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'ISpannung','12');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (5, 3, 'Spannung (V)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'KFarbe','#275c35');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (6, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (7, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'PPreisEinheit','200.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (8, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'PBetrag','200.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (9, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'PVersand','5.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (10, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (1,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (11, 3, 'Mehrwertsteuer');
-- Merkmale Pumpeneinheit
-- I*=Info,
-- K*=Konfiguration
-- +--KFB*=Farbe
-- +--KFM*=Foerdermenge mm3/s
-- +--KDS*=Durchmesser Schlauch mm
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (2, 9, 15, 1, 'KonfiguratorPumpeneinheit');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (2, 3, 'Pumpeneinheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'ILaenge','150');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (12, 3, 'Länge (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'IBreite','60');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (13, 3, 'Breite (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'IHoehe','40');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (14, 3, 'Höhe (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'IGewicht','300');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (15, 3, 'Gewicht (g)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'ISpannung','3');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (16, 3, 'Spannung (V)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (17, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (18, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'PPreisEinheit','50.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (19, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'PBetrag','50.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (20, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'PVersand','5.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (21, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (22, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'KDS','2');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (23, 3, 'Innendurchmesser Schlauch (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (2,'KFM','10');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (24, 3, 'Fördermenge (mm³)');
-- Merkmale Schlauch
-- I*=Info,
-- K*=Konfiguration
-- +--KL*=Laenge Schlauch
-- +--KDS*=Innendurchmesser
-- +--KFB*=Farbe
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (3, 10, 15, 1, 'KonfiguratorSchlauch');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (3, 3, 'Schlauch');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'IWandstärke','4.3');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (25, 3, 'Wandstärke (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'IDruck','3');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (26, 3, 'Max. Betriebsdruck (bar)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'IMaterial','PVC');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (27, 3, 'Material');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (28, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'PPreisEinheit','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (29, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'PBetrag','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (30, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'PVersand','5.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (31, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (32, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'KDS','2');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (33, 3, 'Innendurchmesser (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (34, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'KL','100');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (35, 3, 'Länge (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (3,'PVariable','0.15');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (36, 3, 'Preis (cm)');

-- Merkmale Bewässerungsspitze
-- I*=Info,
-- K*=Konfiguration
-- +--KD*=Innendurchmesser Schlauch
-- +--KFB*=Länge Stab
-- +--KL*=Länge Stab
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (4, 11, 15, 1, 'KonfiguratorBewaesserungsSpitze');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (4, 3, 'Bewässerungsspitze');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'IKopf','PVC');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (37, 3, 'Material Spitze');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'IStab','PA.66');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (38, 3, 'Material Stab');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (39, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'PPreisEinheit','7.50');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (40, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'PBetrag','7.50');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (41, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'PVersand','3.5');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (42, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (43, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'KDS','2');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (44, 3, 'Innendurchmesser Schlauch (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (45, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (4,'KL','5');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (46, 3, 'Länge Stab (mm)');
-- Merkmale Topf, rund, internes Resevoir
-- I*=Info,
-- K*=Konfiguration
-- +--KDS*=Innendurchmesser
-- +--KFB*=Farbe
-- +--KH*=Höhe
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (5, 13, 15, 1, 'KonfiguratorTopfKreisInternesReservoir');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (5, 3, 'Topf, rund, internes Reservoir');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'IWandstärke','8');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (47, 3, 'Wandstärke (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'IMaterial','PF.34');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (48, 3, 'Material');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (49, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'PPreisEinheit','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (50, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'PBetrag','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (51, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'PVersand','20.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (52, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (53, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'KDS','20');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (54, 3, 'Aussendurchmesser (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (55, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'PVariable','0.05');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (56, 3, 'Preis (cm³)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (5,'KH','10');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (57, 3, 'Höhe (cm)');
-- Merkmale Topf, quadratisch, internes Resevoir
-- I*=Info,
-- K*=Konfiguration
-- +--KSA*=Seite
-- +--KFB*=Farbe
-- +--KH*=Höhe
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (6, 13, 15, 1, 'KonfiguratorTopfQuadratInternesReservoir');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (6, 3, 'Topf, quadratisch, internes Reservoir');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'IWandstärke','8');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (58, 3, 'Wandstärke (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'IMaterial','PF.34');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (59, 3, 'Material');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (60, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'PPreisEinheit','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (61, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'PBetrag','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (62, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'PVersand','10.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (63, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (64, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'KSA','20');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (65, 3, 'Seitenlänge (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (66, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'PVariable','0.05');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (67, 3, 'Preis (cm³)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (6,'KH','10');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (68, 3, 'Höhe (cm)');
-- Merkmale Topf, rechteck, internes Resevoir
-- I*=Info,
-- K*=Konfiguration
-- +--KSA*=Seite A
-- +--KSB*=Seite B
-- +--KH*=Höhe
-- +--KFB*=Farbe
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (7, 13, 15, 1, 'KonfiguratorTopfRechteckInternesReservoir');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (7, 3, 'Topf, rechteckig, internes Reservoir');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'IWandstärke','8');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (69, 3, 'Wandstärke (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'IMaterial','PF.34');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (70, 3, 'Material');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (71, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'PPreisEinheit','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (72, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'PBetrag','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (73, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'PVersand','10.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (74, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (75, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'KSA','20');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (76, 3, 'Seitenlänge A (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (77, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'PVariable','0.05');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (78, 3, 'Preis (cm³)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'KSB','20');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (79, 3, 'Seitenlänge B (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (7,'KH','10');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (80, 3, 'Höhe (cm)');
-- Merkmale Topf, dreieck, internes Resevoir
-- I*=Info,
-- K*=Konfiguration
-- +--KSA*=Seite A
-- +--KSA*=Seite C
-- +--KH*=Höhe
-- +--KFB*=Farbe
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (8, 13, 15, 1, 'KonfiguratorTopfDreieckInternesReservoir');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (8, 3, 'Topf, dreieckig, internes Reservoir');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'IWandstärke','8');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (81, 3, 'Wandstärke (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'IMaterial','PF.34');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (82, 3, 'Material');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (83, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'PPreisEinheit','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (84, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'PBetrag','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (85, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'PVersand','10.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (86, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (87, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'KSA','30');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (88, 3, 'Seitenlänge A (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (89, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'PVariable','0.05');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (90, 3, 'Preis (cm³)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'KSC','50');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (91, 3, 'Seitenlänge C (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'KH','10');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (92, 3, 'Höhe (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (8,'KSB','30');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (93, 3, 'Seitenlänge B (cm)');
-- Merkmale Topf, rund, externes Resevoir
-- I*=Info,
-- K*=Konfiguration
-- +--KDS*=Aussendurchmesser
-- +--KFB*=Farbe
-- +--KH*=Höhe
-- +--KBY*=Bohrung Y-Position
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (9, 14, 15, 1, 'KonfiguratorTopfKreisExterneWasserzufuhr');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (9, 3, 'Topf, rund, externe Wasserzufuhr');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'IWandstärke','8');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (94, 3, 'Wandstärke (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'IMaterial','PF.34');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (95, 3, 'Material');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (96, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'PPreisEinheit','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (97, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'PBetrag','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (98, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'PVersand','20.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (99, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (100, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'KDS','20');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (101, 3, 'Aussendurchmesser (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (102, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'PVariable','0.05');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (103, 3, 'Preis (cm³)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'KH','10');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (104, 3, 'Höhe (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (9,'KBY','1');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (105, 3, 'Bohrung Y-Position (cm)');
-- Merkmale Topf, quadratisch, externes Resevoir
-- I*=Info,
-- K*=Konfiguration
-- +--KSA*=Seite
-- +--KFB*=Farbe
-- +--KH*=Höhe
-- +--KBS*=Bohrung Seite
-- +--KBY*=Bohrung Y-Position
-- +--KBY*=Bohrung X-Position
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (10, 14, 15, 1, 'KonfiguratorTopfQuadratExterneWasserzufuhr');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (10, 3, 'Topf, quadratisch, externe Wasserzufuhr');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'IWandstärke','8');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (106, 3, 'Wandstärke (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'IMaterial','PF.34');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (107, 3, 'Material');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (108, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'PPreisEinheit','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (109, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'PBetrag','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (110, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'PVersand','10.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (111, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (112, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'KSA','20');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (113, 3, 'Seitenlänge (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'PVariable','0.05');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (114, 3, 'Preis (cm³)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'KH','10');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (115, 3, 'Höhe (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'KBY','1');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (116, 3, 'Bohrung Y-Position (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'KBX','1');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (117, 3, 'Bohrung X-Position (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'KBS','A');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (118, 3, 'Bohrung Seite');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (10,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (119, 3, 'Farbe');
-- Merkmale Topf, rechteck, externes Reservoir
-- I*=Info,
-- K*=Konfiguration
-- +--KSA*=Seite A
-- +--KSA*=Seite B
-- +--HH*=Höhe
-- +--KBS*=Bohrung Seite
-- +--KBY*=Bohrung Y-Position
-- +--KBY*=Bohrung X-Position
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (11, 14, 15, 1, 'KonfiguratorTopfRechteckExterneWasserzufuhr');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (11, 3, 'Topf, rechteckig, externe Wasserzufuhr');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'IWandstärke','8 mm');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (120, 3, 'Wandstärke (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'IMaterial','PF.34');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (121, 3, 'Material');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (122, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'PPreisEinheit','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (123, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'PBetrag','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (124, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'PVersand','10.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (125, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (126, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'KSA','20');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (127, 3, 'Seitenlänge A (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (128, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'PVariable','0.05');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (129, 3, 'Preis (cm³)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'KSB','20');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (130, 3, 'Seitenlänge B (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'KH','10');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (131, 3, 'Höhe (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'KBY','1');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (132, 3, 'Bohrung Y-Position (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'KBX','1');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (133, 3, 'Bohrung X-Position (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (11,'KBS','A');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (134, 3, 'Bohrung Seite');
-- Merkmale Topf, dreieck, exterenes Resevoir
-- I*=Info,
-- K*=Konfiguration
-- +--KSA*=Seite A
-- +--KSA*=Seite C
-- +--KFB*=Farbe
-- P*=Preiskalkulation
-- E*=Endkalkulation
INSERT INTO Artikel (Nummer, ArtikelArt, Einheit, Zustand, Konfigurator) VALUES (12, 14, 15, 1, 'KonfiguratorTopfDreieckExterneWasserzufuhr');
INSERT INTO ArtikelBeschreibung (ArtikelIdentifier, Sprache, Beschreibung) VALUES (12, 3, 'Topf, dreieckig, externe Wasserzufuhr');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'IWandstärke','8');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (135, 3, 'Wandstärke (mm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'IMaterial','PF.34');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (136, 3, 'Material');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'PMenge','0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (137, 3, 'Menge');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'PPreisEinheit','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (138, 3, 'Preis/Einheit');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'PBetrag','0.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (139, 3, 'Betrag');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'PVersand','10.00');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (140, 3, 'Verpackung/Versand');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'PSteuern','5.0');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (141, 3, 'Mehrwertsteuer');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'KSA','30');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (142, 3, 'Seitenlänge A (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'KFarbe','#000000');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (143, 3, 'Farbe');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'PVariable','0.05');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (144, 3, 'Preis (cm³)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'KSC','50');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (145, 3, 'Seitenlänge C (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'KH','10');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (146, 3, 'Höhe (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'KBY','1');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (147, 3, 'Bohrung Y-Position (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'KBX','1');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (148, 3, 'Bohrung X-Position (cm)');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'KBS','A');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (149, 3, 'Bohrung Seite');
INSERT INTO ArtikelMerkmal (ArtikelIdentifier, Schluessel, Wert) VALUES (12,'KSB','30');
INSERT INTO ArtikelMerkmalBeschreibung (ArtikelMerkmalIdentifier, Sprache, Beschreibung) VALUES (150, 3, 'Seitenlänge B (cm)');
--
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('1', 'Duck', 'Donald', '033 333 33 33', 'donald.duck@disney.com', 1, 3, 'donald');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('2', 'Duck', 'Daisy', '011 111 11 11', 'daisy.duck@disney.com', 1, 3, 'daisy');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('3', 'Duck', 'Dagobert', '022 222 22 22', 'dagobert.duck@disney.com', 1, 3, 'dagobert');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('4', 'Duck', 'Trick', '033 333 33 33', 'trick.duck@disney.com', 1, 4, 'trick');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('5', 'Duck', 'Tick', '033 333 33 33', 'trik.duck@disney.com', 1, 4, 'tick');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('6', 'Duck', 'Track', '033 333 33 33', 'track.duck@disney.com', 1, 4, 'track');
INSERT INTO Kunde (Nummer, Name, Vorname, TelefonNummer, EMailAdresse, Zustand, Sprache, Passwort) VALUES ('7', 'Duck', 'Oma', '044 444 44 44', 'oma.duck@disney.com', 1, 3, 'oma');
--
INSERT INTO Adresse (KundeIdentifier, Strasse, Postleitzahl, Ort) VALUES (1, 'Entenweg 8', '5432', 'Enternhausen');
INSERT INTO Adresse (KundeIdentifier, Strasse, Postleitzahl, Ort) VALUES (2, 'Gratenweg 34', '5432', 'Enternhausen');
INSERT INTO Adresse (KundeIdentifier, Strasse, Postleitzahl, Ort) VALUES (3, 'Goldspeicher 1', '5785', 'Goldberg');
INSERT INTO Adresse (KundeIdentifier, Strasse, Postleitzahl, Ort) VALUES (4, 'Entenweg 8', '5432', 'Enternhausen');
INSERT INTO Adresse (KundeIdentifier, Strasse, Postleitzahl, Ort) VALUES (5, 'Entenweg 8', '5432', 'Enternhausen');
INSERT INTO Adresse (KundeIdentifier, Strasse, Postleitzahl, Ort) VALUES (6, 'Entenweg 8', '5432', 'Enternhausen');
INSERT INTO Adresse (KundeIdentifier, Strasse, Postleitzahl, Ort) VALUES (7, 'Bauhernof', '5576', 'Landhausen');
-- KK=8 Rechnung 7
INSERT INTO ZahlungsArt (KundeIdentifier, ZahlungsArt, NummerKreditkarte, VerfallKreditkarte) VALUES (1, 2, '5566778899', '202112');
INSERT INTO ZahlungsArt (KundeIdentifier, ZahlungsArt, NummerKreditkarte, VerfallKreditkarte) VALUES (2, 2, '9988776655', '202206');
INSERT INTO ZahlungsArt (KundeIdentifier, ZahlungsArt, NummerKreditkarte, VerfallKreditkarte) VALUES (3, 7, '', '');
INSERT INTO ZahlungsArt (KundeIdentifier, ZahlungsArt, NummerKreditkarte, VerfallKreditkarte) VALUES (4, 7, '', '');
INSERT INTO ZahlungsArt (KundeIdentifier, ZahlungsArt, NummerKreditkarte, VerfallKreditkarte) VALUES (5, 7, '', '');
INSERT INTO ZahlungsArt (KundeIdentifier, ZahlungsArt, NummerKreditkarte, VerfallKreditkarte) VALUES (6, 7, '', '');
INSERT INTO ZahlungsArt (KundeIdentifier, ZahlungsArt, NummerKreditkarte, VerfallKreditkarte) VALUES (7, 7, '', '');
--
INSERT INTO Lager (Beschreibung) VALUE('Ilanz');
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 1, 100);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 2, 200);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 3, 0);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 4, 800);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 5, 0);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 6, 0);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 7, 0);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 8, 0);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 9, 0);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 10, 0);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 11, 0);
INSERT INTO Lagerbestand (LagerIdentifier, ArtikelIdentifier, VerfuegbareEinheiten) VALUES(1, 12, 0);
