
    set client_min_messages = WARNING;

    alter table if exists indirizzi 
       drop constraint if exists FKsudfceq03yve264uvu8vxr1kr;

    drop table if exists indirizzi cascade;

    drop table if exists messaggi_sistema cascade;

    drop table if exists utente cascade;
