CREATE TABLE user (
    id bigint NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    name varchar(32) NOT NULL,
    role_type enum('ADMIN', 'USER'),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE book (
    id bigint NOT NULL,
    title varchar(128) NOT NULL,
    author varchar(32) NOT NULL,
    release_date date NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE rental (
    book_id bigint NOT NULL,
    user_id bigint NOT NULL,
    rental_deadline datetime NOT NULL,
    return_datetime datetime NOT NULL,
    PRIMARY KEY book_id,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO book VALUES (100, "Kotlin入門", "山田太郎", "2020-01-01"), (101, "Java入門", "山田太郎", "2020-01-01"), (102, "Spring入門", "山田太郎", "2020-01-01");
INSERT INTO user VALUES (1, "admin@test.com", "admin", "admin", "ADMIN"), (2, "user@test.com", "user", "user", "USER");
