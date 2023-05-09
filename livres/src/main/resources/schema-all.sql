DROP TABLE IF EXISTS coffee;

CREATE TABLE coffee (
                        coffee_id BIGSERIAL PRIMARY KEY,
                        brand VARCHAR(20),
                        origin VARCHAR(20),
                        characteristics VARCHAR(30)
);
