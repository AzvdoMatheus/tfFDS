INSERT INTO client (client_identification_code, client_name, client_email) VALUES
                                                                               (1, 'Alice Johnson', 'alice.johnson@example.com'),
                                                                               (2, 'Bob Smith', 'bob.smith@example.com'),
                                                                               (3, 'Charlie Brown', 'charlie.brown@example.com'),
                                                                               (4, 'David Wilson', 'david.wilson@example.com'),
                                                                               (5, 'Eva Adams', 'eva.adams@example.com'),
                                                                               (6, 'Frank White', 'frank.white@example.com'),
                                                                               (7, 'Grace Kelly', 'grace.kelly@example.com'),
                                                                               (8, 'Hannah Scott', 'hannah.scott@example.com'),
                                                                               (9, 'Ian Moore', 'ian.moore@example.com'),
                                                                               (10, 'Jane Doe', 'jane.doe@example.com');


INSERT INTO application (app_identification_code, app_name, monthly_cost) VALUES
                                                                              (1, 'Netflix', 39.90),
                                                                              (2, 'Spotify', 19.90),
                                                                              (3, 'Amazon Prime', 14.90),
                                                                              (4, 'Disney+', 27.90),
                                                                              (5, 'HBO Max', 34.90);

INSERT INTO subscription (subscription_identification_code, plan_start, plan_end, status, client_id, application_id) VALUES
                                                                                                                         (1, CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 1, 1),
                                                                                                                         (2, CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 2, 2),
                                                                                                                         (3, CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 3, 3),
                                                                                                                         (4, CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 4, 4),
                                                                                                                         (5, CURRENT_DATE, CURRENT_DATE + INTERVAL '30 days', 'ACTIVE', 5, 5);
