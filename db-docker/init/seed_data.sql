DROP TABLE IF EXISTS `note`;

CREATE TABLE note(
    id  INT NOT NULL,
    anons varchar(255),
    full_text varchar(255),
    title varchar(255)
);
