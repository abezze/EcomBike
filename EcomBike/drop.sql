
    set client_min_messages = WARNING;

    alter table if exists anagrafica 
       drop constraint if exists FKbsc97wtuy3wnf5q9p2n7a44en;

    alter table if exists dettaglio_ordine 
       drop constraint if exists FKg8p950u9hg0towv49etgqvfo2;

    alter table if exists indirizzo_spedizione 
       drop constraint if exists FKehywytnkgipqu5b9fecs6nxb5;

    alter table if exists pagamento 
       drop constraint if exists FKlokfc657jetko2tqpe3y812ip;

    drop table if exists anagrafica cascade;

    drop table if exists dettaglio_ordine cascade;

    drop table if exists indirizzo_spedizione cascade;

    drop table if exists messaggi_sistema cascade;

    drop table if exists ordine cascade;

    drop table if exists pagamento cascade;

    drop table if exists tipo_pagamento cascade;

    drop table if exists utente cascade;
