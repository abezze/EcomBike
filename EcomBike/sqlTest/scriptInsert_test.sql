-- INSERT UTILI PER TEST

-- Inserimento di un'altra anagrafica per l'utente admin
INSERT INTO anagrafica
(tipo_indirizzo,  cap, codice_fiscale, partita_iva, telefono, nazione, citta, cognome, nome, via, utente_user_name)
VALUES(1,  '23897', 'BZZLSS75L18F133U', NULL, '568868969', 'Italy', 'Madesimo', 'Bezze', 'Alessio', 'via fondovalle 18', 'admin');


-- Inserimento e configurazione di un nuovo utente 'pluto'
INSERT INTO utente
(role, email, password, user_name)
VALUES(1, 'pluto@fakemail.it', 'pluto', 'pluto');

INSERT INTO anagrafica
(tipo_indirizzo,  cap, codice_fiscale, partita_iva, telefono, nazione, citta, cognome, nome, via, utente_user_name)
VALUES(0,  '20154', 'DSNPLT80A01F205W', NULL, '123456789', 'Italy', 'Milano', 'Disney', 'Pluto', 'Via Cenisio, 26', 'pluto');


-- Inserimento di nuovi produttori
INSERT INTO produttore
(id, codice_fiscale, partita_iva, marchio, nome_azienda)
VALUES(1, '04925720288', '04925720288', 'Olimpia', 'Cicli Olimpia');

INSERT INTO produttore
(id, codice_fiscale, partita_iva, marchio, nome_azienda)
VALUES(2, '02179510819', '02179510819', 'Lombardo', 'Lombardo Bikes');

INSERT INTO produttore
(id, codice_fiscale, partita_iva, marchio, nome_azienda)
VALUES(3, '47698356915', '47698356915', 'Santa Cruz', 'Santa Cruz Bicycles');

INSERT INTO produttore
(id, codice_fiscale, partita_iva, marchio, nome_azienda)
VALUES(4, '67954863251', '67954863251', 'Scott', 'Scott');


-- Inserimento di nuovi prodotti
INSERT INTO prodotto
(product_code, categoria_id, produttore_id, descrizione, colore, taglia, peso, quantita, image)
VALUES(1, 1, 3, 'Mountain Bike - Nomad', 'Grigio', 'XL', 14.5, 8, 'NomadSantaCruz-65855f8c-75a1-4718-aba0-f47e9d560f7b.jpg');

INSERT INTO prodotto
(product_code, categoria_id, produttore_id, descrizione, colore, taglia, peso, quantita, image)
VALUES(2, 1, 3, 'Mountain Bike - V10 Mullet 2024', 'Rosso', 'S', 13.4, 2, 'Santa-Cruz-V10-Mullet-2024-5b309c1f-d79e-4c81-bec3-be04736c5d91.png');

INSERT INTO prodotto
(product_code, categoria_id, produttore_id, descrizione, colore, taglia, peso, quantita, image)
VALUES(3, 1, 4, 'Mountain Bike - Gambler Tuned 2020', 'Giallo', 'M', 14.5, 1, 'Scott_Gambler_Tuned_2020_js-11-d0990616-1ca3-4e1c-bfd7-adfe4215bc3e.jpg');

INSERT INTO prodotto
(product_code, categoria_id, produttore_id, descrizione, colore, taglia, peso, quantita, image)
VALUES(4, 1, 4, 'Mountain Bike - Genius', 'Grigio', 'M', 14.6, 0, 'ScottGenius-7e1dab2b-5db9-42c9-bceb-045c98ec580e.jpg');

INSERT INTO prodotto
(product_code, categoria_id, produttore_id, descrizione, colore, taglia, peso, quantita, image)
VALUES(5, 1, 4, 'Mountain Bike - Ransom', 'Bianco', 'S', 13.2, 7, 'ScottRansom-5fdeb00c-cf4e-4537-a9ec-696acf68477c.jpg');

INSERT INTO prodotto
(product_code, categoria_id, produttore_id, descrizione, colore, taglia, peso, quantita, image)
VALUES(6, 2, 4, 'Mountain Bike Elettrica - Lumen eRide', 'Verde', 'M', 17.2, 3, 'scott_lumen_e_ride-d6235e08-f82f-45fe-826d-e338ff55f8af.jpg');



-- Inserimento ordini
INSERT INTO ordine
(data_ordine, orario_ordine, stato_ordine, id, utente_id, ordine_indirizzo)
VALUES('2026-03-20', '18:30:00', 0, 1, 'admin', 1);