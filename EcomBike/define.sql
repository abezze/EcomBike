
    create table utente (
        role smallint check ((role between 0 and 3)),
        email varchar(255),
        password varchar(255),
        user_name varchar(255) not null,
        primary key (user_name)
    );
