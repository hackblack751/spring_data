INSERT INTO user_status(status_id, status_name)
VALUES(1, 'ACTIVE'), (2, 'DELETED'), (3, 'DEACTIVE');

INSERT INTO users(user_id, username, status_id)
VALUES(1, 'johnny', 1),
       (2, 'henry', 1);

INSERT INTO profile_status(profile_status_id, status_name)
VALUES(1, 'PUBLIC'), (2, 'PRIVATE'), (3, 'LIMITED');

INSERT INTO profile(user_id, first_name, last_name, profile_status_id)
VALUES(1, 'johnny', 'bravo', 1),
       (2, 'henry', 'smith', null);

INSERT INTO order_status(order_status_id, status_name, created_at)
VALUES(1, 'CREATED', CURRENT_TIMESTAMP),
(2, 'PROCESSING', CURRENT_TIMESTAMP),
(3, 'PROHIBITED', CURRENT_TIMESTAMP);

INSERT INTO `orders`(order_id, user_id, order_status_id, description, created_at)
VALUES(1, 1, 1, 'buy iphone', CURRENT_TIMESTAMP),
    (2, 1, 2, 'buy android', CURRENT_TIMESTAMP),
    (3, 1, 3, 'buy pc', CURRENT_TIMESTAMP),

    (4, 2, 1, 'order toy', CURRENT_TIMESTAMP),
    (5, 2, 2, 'order water bottle', CURRENT_TIMESTAMP)
    ;