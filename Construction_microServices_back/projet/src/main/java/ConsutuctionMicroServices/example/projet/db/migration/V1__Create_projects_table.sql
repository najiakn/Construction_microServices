
create table projet(id SERIAL PRIMARY KEY,
                       nom_projet VARCHAR(255) ,
                        description_projet VARCHAR(255),
                        date_debut DATE,
                        date_fin DATE,
                        budget float
                   );