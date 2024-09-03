
create table tache(id SERIAL PRIMARY KEY,
                   description VARCHAR(255) ,

                   date_debut DATE,
                    date_fin DATE,
                    budget float,
                   status VARCHAR(255) ,
                   idProjet int
);