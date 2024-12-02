CREATE TABLE IF NOT EXISTS client (
                                      client_identification_code SERIAL PRIMARY KEY,
                                      client_name VARCHAR(255),
    client_email VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS application (
                                           app_identification_code SERIAL PRIMARY KEY,
                                           app_name VARCHAR(255),
    monthly_cost DECIMAL(10, 2)
    );

CREATE TABLE IF NOT EXISTS subscription (
                                            subscription_identification_code SERIAL PRIMARY KEY,
                                            plan_start DATE,
                                            plan_end DATE,
                                            status VARCHAR(255),
    client_id BIGINT,
    application_id BIGINT,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(client_identification_code),
    CONSTRAINT fk_application FOREIGN KEY (application_id) REFERENCES application(app_identification_code)
    );

CREATE TABLE IF NOT EXISTS payment (
                                       payment_identification_code SERIAL PRIMARY KEY,
                                       price_paid DECIMAL(10, 2),
    payment_date DATE,
    promotional_code VARCHAR(255),
    subscription_id BIGINT,
    CONSTRAINT fk_subscription FOREIGN KEY (subscription_id) REFERENCES subscription(subscription_identification_code)
    );
