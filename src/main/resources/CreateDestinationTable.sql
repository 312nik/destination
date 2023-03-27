CREATE TABLE Destinations (
    airport_code varchar(3),primerykey,notnull, unique;
    city varchar(255),notnull;
    country_code varchar(2),notnull ;
    country_name varchar(255),notnull;
    airport_name varchar(255),notnull;
    timezone varchar(4),notnull;
);
