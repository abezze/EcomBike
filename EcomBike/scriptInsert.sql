INSERT INTO messaggi_sistema
(lang, code, messaggio)
VALUES('IT', 'rest_deleted', 'cancellato');
INSERT INTO messaggi_sistema
(lang, code, messaggio)
VALUES('IT', 'dato_exist', 'Non esiste un dato con questo ID');
INSERT INTO messaggi_sistema
(lang, code, messaggio)
VALUES('IT', 'rest_created', 'creato dato');
INSERT INTO messaggi_sistema
(lang, code, messaggio)
VALUES('IT', 'rest_updated', 'modificato dato');
INSERT INTO messaggi_sistema
(lang, code, messaggio)
VALUES('IT', 'category_change', 'Non è possibile cambiare categoria dato');
INSERT INTO messaggi_sistema
(lang, code, messaggio)
VALUES('IT', 'login_invalid', 'Utente non valido');
INSERT INTO messaggi_sistema
(lang, code, messaggio)
VALUES('IT', 'login_valid', 'Login eseguita');


----------------------------------
INSERT INTO utente
("role", email, "password", user_name)
VALUES(0, 'abezze@yahoo.it', 'admin', 'admin');

INSERT INTO utente
("role", email, "password", user_name)
VALUES(1, 'abezze@gmail.com', 'pwd', 'abezze');

INSERT INTO utente
("role", email, "password", user_name)
VALUES(1, 'f.a@gmail.com', 'pwd', 'giulio');


----------------------------------
INSERT INTO anagrafica
(tipo_indirizzo, id, cap, codice_fiscale, partita_iva, telefono, utente_user_name, nazione, citta, cognome, nome, via)
VALUES(0, 3, '23897', 'RSSPLO98F12F233U', '02494170133', '3393938677', 'abezze', 'Italia', 'Viganò', 'BEZZE', 'ALESSIO', 'VIA ALESSANDRO VOLTA, 19');
INSERT INTO anagrafica
(tipo_indirizzo, id, cap, codice_fiscale, partita_iva, telefono, utente_user_name, nazione, citta, cognome, nome, via)
VALUES(2, 2, '23897', 'BZZLSS75L18F133U', NULL, '568868969', 'admin', 'Italy', 'Madesimo', 'Bezze', 'Alessio', 'via fondovalle 18');
INSERT INTO anagrafica
(tipo_indirizzo, id, cap, codice_fiscale, partita_iva, telefono, utente_user_name, nazione, citta, cognome, nome, via)
VALUES(0, 4, '23897', 'RSSPLO98F12F233U', NULL, '143124124', 'giulio', 'Italia', 'sirtori', 'Fumagalli', 'giulio', 'giulio');
INSERT INTO anagrafica
(tipo_indirizzo, id, cap, codice_fiscale, partita_iva, telefono, utente_user_name, nazione, citta, cognome, nome, via)
VALUES(0, 5, '23897', 'bzzgnn38j21f133u', NULL, '347897978', 'admin', 'Italia', 'Viganò', 'Bezze', 'Giovanni', 'Mazzini 8');
INSERT INTO anagrafica
(tipo_indirizzo, id, cap, codice_fiscale, partita_iva, telefono, utente_user_name, nazione, citta, cognome, nome, via)
VALUES(3, 1, '23897', 'BZZLSS75L18F133U', NULL, '347235', 'admin', 'Italy', 'Milano', 'Bezze', 'Alessio', 'Stelvio 80');
INSERT INTO anagrafica
(tipo_indirizzo, id, cap, codice_fiscale, partita_iva, telefono, utente_user_name, nazione, citta, cognome, nome, via)
VALUES(4, 6, '20152', 'RSSPLO98F12F233U', '02494170133', '039957306', 'admin', 'Italia', 'Milano', 'Paolo', 'Gino', 'Via Giovanni Bensi, 1');

----------------------------------
INSERT INTO indirizzo_spedizione
(tipo_indirizzo,   cap, codice_fiscale, partita_iva, telefono, nazione, citta, cognome, nome, via)
VALUES(1,   '23897', 'BZZLSS75L18F133U', NULL, '568868969', 'Italy', 'Madesimo', 'Bezze', 'Alessio', 'via fondovalle 18');


----------------------------------
INSERT INTO categoria
(id, descrizione)
VALUES(1, 'Bici Mountain Bike');

INSERT INTO categoria
(id, descrizione)
VALUES(2, 'Bici Mountain Bike elettrica');

INSERT INTO categoria
(id, descrizione)
VALUES(3, 'Bici da Corsa');

INSERT INTO categoria
(id, descrizione)
VALUES(4, 'Bici BMX');


----------------------------------
INSERT INTO tipo_pagamento
(id, societa_creditrice, tipo_pagamento)
VALUES(1, 'Visa', 'Credit Card');
INSERT INTO tipo_pagamento
(id, societa_creditrice, tipo_pagamento)
VALUES(2, 'Paypal Europe S.a.r.l', 'PayPal');
INSERT INTO tipo_pagamento
(id, societa_creditrice, tipo_pagamento)
VALUES(3, 'ABI ', 'Bonifico Bancario');


------------------------------------------

INSERT INTO produttore
(id, codice_fiscale, partita_iva, marchio, nome_azienda)
VALUES(1, NULL, '02494170133', 'Scott ', 'Scott Bike');
INSERT INTO produttore
(id, codice_fiscale, partita_iva, marchio, nome_azienda)
VALUES(2, NULL, '13494170133', 'Santa Cruz', 'Santa Cruz Bike');
INSERT INTO produttore
(id, codice_fiscale, partita_iva, marchio, nome_azienda)
VALUES(3, NULL, '02494170133', 'Rotwild', 'Rotwild Bike GMBH');
INSERT INTO produttore
(id, codice_fiscale, partita_iva, marchio, nome_azienda)
VALUES(4, '02494170133', '02494170133', 'NS Bikes', 'NS Bike CO LTD');


-------------------------------

INSERT INTO ordine
(data_ordine, orario_ordine, stato_ordine, id, ordine_indirizzo, utente_id)
VALUES('2026-03-20', '18:30:00', 0, 1, 1, 'admin');
INSERT INTO ordine
(data_ordine, orario_ordine, stato_ordine, id, ordine_indirizzo, utente_id)
VALUES('2026-03-31', '08:37:27', 0, 10, NULL, 'abezze');

------------------------------------

INSERT INTO prodotto
(peso, product_code, quantita, categoria_id, produttore_id, taglia, colore, descrizione, image, prezzo)
VALUES(13.80, 8123456, 5, 1, 1, 'L', 'Arancione', 'Scott Gambler 900 Tuned', 'Scott_Gambler_Tuned_2020_js-11-d0990616-1ca3-4e1c-bfd7-adfe4215bc3e.jpg', 9950.00);
INSERT INTO prodotto
(peso, product_code, quantita, categoria_id, produttore_id, taglia, colore, descrizione, image, prezzo)
VALUES(13.60, 5544, 5, 1, 1, 'L', 'Bianco azzurro', 'Scott Ransom 900 tuned', 'ScottRansom-5fdeb00c-cf4e-4537-a9ec-696acf68477c.jpg', 8750.00);
INSERT INTO prodotto
(peso, product_code, quantita, categoria_id, produttore_id, taglia, colore, descrizione, image, prezzo)
VALUES(15.00, 5432165, 3, 1, 2, 'L', 'Grigio', 'Santa Cruz Nomad Mullet', 'NomadSantaCruz-65855f8c-75a1-4718-aba0-f47e9d560f7b.jpg', 7500.00);
INSERT INTO prodotto
(peso, product_code, quantita, categoria_id, produttore_id, taglia, colore, descrizione, image, prezzo)
VALUES(12.80, 987654, 2, 1, 1, 'M', 'grigio', 'Scott Genius 900 ultimate', 'ScottGenius-7e1dab2b-5db9-42c9-bceb-045c98ec580e.jpg', 8800.00);
INSERT INTO prodotto
(peso, product_code, quantita, categoria_id, produttore_id, taglia, colore, descrizione, image, prezzo)
VALUES(15.80, 73456, 8, 1, 2, 'L', 'Rosso', 'Santa Cruz V10 Mullet DH', 'Santa-Cruz-V10-Mullet-2024-5b309c1f-d79e-4c81-bec3-be04736c5d91.png', 9500.00);
INSERT INTO prodotto
(peso, product_code, quantita, categoria_id, produttore_id, taglia, colore, descrizione, image, prezzo)
VALUES(18.60, 88888, 2, 2, 3, 'M', 'grigio', 'Rotwild RE 375 PRO ', 'rotwild_re375_pro-e70075ea-9ecc-4c90-8e53-775e473be23f.jpg', 8950.00);
INSERT INTO prodotto
(peso, product_code, quantita, categoria_id, produttore_id, taglia, colore, descrizione, image, prezzo)
VALUES(15.00, 666777, 3, 4, 4, 'unica', 'nero', 'Dirt Bike ', 'ns-bikes-zircus-black-25acdbcb-002e-443b-b0a9-a83a9855d4f6.jpg', 650.00);


---------------------------------------------------------------------

INSERT INTO dettaglio_ordine
(product_code, quantita, id, ordine_id)
VALUES(5544, 5, 16, 10);
INSERT INTO dettaglio_ordine
(product_code, quantita, id, ordine_id)
VALUES(88888, 2, 25, 10);
INSERT INTO dettaglio_ordine
(product_code, quantita, id, ordine_id)
VALUES(88888, 2, 26, 1);
INSERT INTO dettaglio_ordine
(product_code, quantita, id, ordine_id)
VALUES(5544, 5, 6, 1);
INSERT INTO dettaglio_ordine
(product_code, quantita, id, ordine_id)
VALUES(5432165, 2, 1, 1);
INSERT INTO dettaglio_ordine
(product_code, quantita, id, ordine_id)
VALUES(987654, 2, 27, 1);
INSERT INTO dettaglio_ordine
(product_code, quantita, id, ordine_id)
VALUES(666777, 3, 28, 1);
INSERT INTO dettaglio_ordine
(product_code, quantita, id, ordine_id)
VALUES(8123456, 2, 29, 1);
INSERT INTO dettaglio_ordine
(product_code, quantita, id, ordine_id)
VALUES(8123456, 2, 15, 10);
