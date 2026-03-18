
    set client_min_messages = WARNING;

    alter table if exists indirizzi 
       drop constraint if exists FKsudfceq03yve264uvu8vxr1kr;

    alter table if exists pagamento 
       drop constraint if exists FKlokfc657jetko2tqpe3y812ip;

    drop table if exists indirizzi cascade;

    drop table if exists messaggi_sistema cascade;

    drop table if exists pagamento cascade;

    drop table if exists tipo_pagamento cascade;

    drop table if exists utente cascade;
