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
