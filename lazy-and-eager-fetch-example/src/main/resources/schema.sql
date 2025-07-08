CREATE TABLE `order_status`(
    order_status_id INT NOT NULL,
    status_name CHAR(15) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    PRIMARY KEY(order_status_id)
);

CREATE TABLE `user_status` (
    status_id INT,
    status_name CHAR(30) NOT NULL,
    PRIMARY KEY(status_id)
);

CREATE TABLE `users` (
    user_id INT AUTO_INCREMENT,
    username VARCHAR(100),
    status_id INT,
    PRIMARY KEY(user_id),
    CONSTRAINT fk_users_status FOREIGN KEY(status_id) REFERENCES user_status(status_id)
);

CREATE TABLE `profile_status` (
    profile_status_id INT,
    status_name CHAR(30) NOT NULL,
    PRIMARY KEY(profile_status_id)
);

CREATE TABLE user_address(
    address_id INT,
    street VARCHAR(250),
    user_id INT UNIQUE,
    PRIMARY KEY(address_id),
    CONSTRAINT fk_user_address_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE `profile` (
    user_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    profile_status_id INT,
    PRIMARY KEY(user_id),
    CONSTRAINT fk_profile_users FOREIGN KEY(user_id) REFERENCES users(user_id),
    CONSTRAINT fk_profile_status FOREIGN KEY(profile_status_id) REFERENCES profile_status(profile_status_id)
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


