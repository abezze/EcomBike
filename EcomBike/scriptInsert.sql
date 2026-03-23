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
(tipo_indirizzo, id, cap, codice_fiscale, partita_iva, telefono, nazione, citta, cognome, nome, via, utente_user_name)
VALUES(0, 1, '23897', 'BZZLSS75L18F133U', NULL, '568868969', 'Italy', 'Viganò', 'Bezze', 'Alessio', 'A. Volta 19', 'admin');
INSERT INTO anagrafica
(tipo_indirizzo, id, cap, codice_fiscale, partita_iva, telefono, nazione, citta, cognome, nome, via, utente_user_name)
VALUES(1, 2, '23897', 'BZZLSS75L18F133U', NULL, '568868969', 'Italy', 'Viganò', 'Bezze', 'Alessio', 'A. Volta 19', 'admin');


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