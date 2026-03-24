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


----------------------------------
INSERT INTO anagrafica
(tipo_indirizzo,  cap, codice_fiscale, partita_iva, telefono, nazione, citta, cognome, nome, via, utente_user_name)
VALUES(0,  '23897', 'BZZLSS75L18F133U', NULL, '568868969', 'Italy', 'Viganò', 'Bezze', 'Alessio', 'A. Volta 19', 'admin');
INSERT INTO anagrafica
(tipo_indirizzo,  cap, codice_fiscale, partita_iva, telefono, nazione, citta, cognome, nome, via, utente_user_name)
VALUES(1,  '23897', 'BZZLSS75L18F133U', NULL, '568868969', 'Italy', 'Madesimo', 'Bezze', 'Alessio', 'via fondovalle 18', 'admin');

----------------------

INSERT INTO ordine
(data_ordine, orario_ordine, stato_ordine, id, utente_id, ordine_indirizzo)
VALUES('2026-03-20', '18:30:00', 0, 1, 'admin', null);

-----------------------------

INSERT INTO indirizzo_spedizione
(tipo_indirizzo,   cap, codice_fiscale, partita_iva, telefono, nazione, citta, cognome, nome, via)
VALUES(1,   '23897', 'BZZLSS75L18F133U', NULL, '568868969', 'Italy', 'Madesimo', 'Bezze', 'Alessio', 'via fondovalle 18');


----------------------------------

update ordine set ordine_indirizzo = 1;



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

--------------------------------------

INSERT INTO tipo_pagamento
(id, societa_creditrice, tipo_pagamento)
VALUES(1, 'Visa', 'Credit Card');
INSERT INTO tipo_pagamento
(id, societa_creditrice, tipo_pagamento)
VALUES(2, 'Paypal Europe S.a.r.l', 'PayPal');
INSERT INTO tipo_pagamento
(id, societa_creditrice, tipo_pagamento)
VALUES(3, 'ABI ', 'Bonifico Bancario');