DROP DATABASE IF EXISTS lez_recap_01_ferramenta;
CREATE DATABASE lez_recap_01_ferramenta;
USE lez_recap_01_ferramenta;

DROP TABLE IF EXISTS Prodotto;
CREATE TABLE Prodotto(
	prodottoID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    descrizione TEXT,
    categoria VARCHAR(20) CHECK ( categoria IN ("Bricolage", "Illuminazione", "Fai da te") ),
    prezzo FLOAT CHECK (prezzo >= 0),
    quantita INTEGER CHECK (quantita >= 0),
    data_ins DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO Prodotto(nome, descrizione, categoria, prezzo, quantita) VALUES	
("Vite a stella", "Brillante", "Fai da te", 12, 8);

INSERT INTO Prodotto(nome, descrizione, categoria, prezzo, quantita) VALUES	
("Vite piatta", "Prova", "Fai da te", 12, 8);

INSERT INTO Prodotto(nome, descrizione, categoria, prezzo, quantita) VALUES	
("Giravite", "N.D.", "Fai da te", 85, 122),
("Lampada", "Luminosa", "Illuminazione", 5, 30),
("Colla", "Odorosa", "Bricolage", 2.5, 14),
("Scotch", "Appiccicoso", "Bricolage", 3.5, 15);

SELECT * FROM Prodotto;
SELECT prodottoID, nome, descrizione, categoria, prezzo, quantita FROM Prodotto;
SELECT prodottoID, nome, descrizione, categoria, prezzo, quantita FROM Prodotto WHERE prodottoID = 33;

-- AGGREGAZIONE

-- Conta tutte le righe
SELECT COUNT(*) AS Contatore FROM Prodotto;

-- Somma tutte le quantita
SELECT SUM(quantita) AS Somma FROM Prodotto;

-- Media dei prezzi
SELECT AVG(prezzo) AS "Media prezzi" FROM Prodotto;

-- Minimo e massimo
SELECT MAX(prezzo) AS "Prezzo massimo" FROM Prodotto;
SELECT MIN(prezzo) AS "Prezzo minimo" FROM Prodotto WHERE categoria = "Fai da te";

-- RAGGRUPPAMENTI
SELECT categoria, COUNT(*) AS contatore 
	FROM Prodotto
    GROUP BY categoria;
    
-- MEDIA CON RAGGRUPPAMENTO E ORDINAMENTO
SELECT categoria, AVG(prezzo) AS prezzo_medio
	FROM Prodotto
    GROUP BY categoria
    ORDER BY prezzo_medio DESC;     -- DESC			-- ORDINAMENTO
    
SELECT categoria, AVG(prezzo) AS prezzo_medio
	FROM Prodotto
    GROUP BY categoria
    HAVING prezzo_medio >= 5;

DELETE FROM Prodotto WHERE prodottoID = 2;

UPDATE Prodotto SET
	prezzo = 1,
    descrizione = "Prova"
    WHERE prodottoID = 3;

