CREATE TABLE IF NOT EXISTS client (
    client_identification_code BIGINT PRIMARY KEY,
    client_name VARCHAR(255) NOT NULL,
    client_email VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS application (
    app_identification_code BIGINT PRIMARY KEY,
    app_name VARCHAR(255) NOT NULL,
    monthly_cost DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS subscription (
    subscription_identification_code BIGINT PRIMARY KEY,
    plan_start DATE NOT NULL,
    plan_end DATE NOT NULL,
    status VARCHAR(255) NOT NULL,
    client_id BIGINT NOT NULL,
    application_id BIGINT NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(client_identification_code),
    CONSTRAINT fk_application FOREIGN KEY (application_id) REFERENCES application(app_identification_code)
);

CREATE TABLE IF NOT EXISTS payment (
    payment_identification_code BIGINT PRIMARY KEY,
    price_paid DECIMAL(10, 2) NOT NULL,
    payment_date DATE NOT NULL,
    promotional_code VARCHAR(255),
    subscription_id BIGINT NOT NULL,
    CONSTRAINT fk_subscription FOREIGN KEY (subscription_id) REFERENCES subscription(subscription_identification_code)
);
