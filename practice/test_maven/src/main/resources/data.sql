INSERT INTO users(user_id, username) VALUES(1, 'johnny');
INSERT INTO profile(user_id, first_name, last_name) VALUES(1, 'johnny', 'bravo');

INSERT INTO order_status(order_status_id, status_name, created_at)
VALUES(1, 'CREATED', CURRENT_TIMESTAMP),
(2, 'PROCESSING', CURRENT_TIMESTAMP),
(3, 'PROHIBITED', CURRENT_TIMESTAMP);

INSERT INTO `orders`(order_id, user_id, order_status_id, description, created_at)
VALUES(1, 1, 1, 'buy iphone', CURRENT_TIMESTAMP),
    (2, 1, 2, 'buy android', CURRENT_TIMESTAMP),
    (3, 1, 3, 'buy pc', CURRENT_TIMESTAMP);