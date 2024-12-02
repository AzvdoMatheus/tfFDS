INSERT INTO client (client_name, client_email) VALUES
                                                                               ('Alice Johnson', 'alice.johnson@example.com'),
                                                                               ('Bob Smith', 'bob.smith@example.com'),
                                                                               ('Charlie Brown', 'charlie.brown@example.com'),
                                                                               ('David Wilson', 'david.wilson@example.com'),
                                                                               ('Eva Adams', 'eva.adams@example.com'),
                                                                               ('Frank White', 'frank.white@example.com'),
                                                                               ('Grace Kelly', 'grace.kelly@example.com'),
                                                                               ('Hannah Scott', 'hannah.scott@example.com'),
                                                                               ('Ian Moore', 'ian.moore@example.com'),
                                                                               ('Jane Doe', 'jane.doe@example.com');
INSERT INTO client (client_name, client_email) VALUES
                                                                                ('Alice Green', 'alicegreen@example.com'),
                                                                                ('Tom White', 'tomwhite@example.com');

INSERT INTO application (app_name, monthly_cost) VALUES
                                                                              ('Netflix', 39.90),
                                                                              ('Spotify', 19.90),
                                                                              ('Amazon Prime', 14.90),
                                                                              ('Disney+', 27.90),
                                                                              ('HBO Max', 34.90);

INSERT INTO subscription (plan_start, plan_end, status, client_id, application_id) VALUES
                                                                                                                         (CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 1, 1),
                                                                                                                         (CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 2, 2),
                                                                                                                         (CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 3, 3),
                                                                                                                         (CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 4, 4),
                                                                                                                         (CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 5, 5);
