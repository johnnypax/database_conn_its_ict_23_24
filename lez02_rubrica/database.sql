CREATE DATABASE lez_recap_03_rubrica;
USE lez_recap_03_rubrica;

CREATE TABLE Contatto(
	contattoID INTEGER PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(250) NOT NULL,
    cognome VARCHAR(250) NOT NULL,
    mail VARCHAR(250),
    telefono VARCHAR(250) NOT NULL UNIQUE
);

INSERT INTO Contatto(nome, cognome, mail, telefono) VALUES
("Giovanni", "Pace", "gio@pace.com", "12345"),
("Valeria", "Verdi", "val@verdi.com", "12346");

SELECT * FROM Contatto;