
    set client_min_messages = WARNING;

    alter table if exists anagrafica 
       drop constraint if exists FKbsc97wtuy3wnf5q9p2n7a44en;

    alter table if exists dettaglio_ordine 
       drop constraint if exists FKg8p950u9hg0towv49etgqvfo2;

    alter table if exists dettaglio_ordine 
       drop constraint if exists FKcwlgl042qcmilyegnw7ub8x8t;

    alter table if exists ordine 
       drop constraint if exists FKcrisolundgacttiaf6wgerfya;

    alter table if exists ordine 
       drop constraint if exists FKdg320enjlk6khf1wx5x8o28qx;

    alter table if exists pagamento 
       drop constraint if exists FKnnhmthau4vxeibihypqc1c4sx;

    alter table if exists pagamento 
       drop constraint if exists FKlokfc657jetko2tqpe3y812ip;

    alter table if exists prodotto 
       drop constraint if exists FKp54y50a2i7pdiipduc60tttrw;

    alter table if exists prodotto 
       drop constraint if exists FKakof6q73twbk4tk150ann5gg9;

    drop table if exists anagrafica cascade;

    drop table if exists categoria cascade;

    drop table if exists dettaglio_ordine cascade;

    drop table if exists indirizzo_spedizione cascade;

    drop table if exists messaggi_sistema cascade;

    drop table if exists ordine cascade;

    drop table if exists pagamento cascade;

    drop table if exists prodotto cascade;

    drop table if exists produttore cascade;

    drop table if exists tipo_pagamento cascade;

    drop table if exists utente cascade;
