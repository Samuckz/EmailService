CREATE TABLE emails (
    id BINARY(16) NOT NULL,
    owner_ref VARCHAR(100) NOT NULL,
    email_from VARCHAR(100) NOT NULL,
    email_to VARCHAR(100) NOT NULL,
    subject VARCHAR(100) NOT NULL,
    text TEXT NOT NULL,
    send_date_email TIMESTAMP NOT NULL,
    status_email VARCHAR(5) NOT NULL,
    PRIMARY KEY (id)
);
