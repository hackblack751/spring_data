CREATE TABLE `order_status`(
    order_status_id INT NOT NULL,
    status_name CHAR(15) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    PRIMARY KEY(order_status_id)
);

CREATE TABLE `users` (
    user_id INT AUTO_INCREMENT,
    username VARCHAR(100),
    PRIMARY KEY(user_id)
);

CREATE TABLE `profile` (
    user_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    PRIMARY KEY(user_id),
    CONSTRAINT fk_profile_users FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE `orders` (
    order_id INT AUTO_INCREMENT,
    user_id INT NOT NULL, -- Make this foreign key later.
    order_status_id INT NOT NULL,
    description VARCHAR(255),
    created_at TIMESTAMP NOT NULL,
    PRIMARY KEY(order_id),
    CONSTRAINT fk_orders_status FOREIGN KEY(order_status_id) REFERENCES order_status(order_status_id),
    CONSTRAINT fk_orders_users FOREIGN KEY(user_id) REFERENCES users(user_id)
);


