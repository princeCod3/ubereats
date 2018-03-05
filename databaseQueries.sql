
CREATE TABLE Category(

id IDENTITY NOT NULL,
name VARCHAR(50) NOT NULL,
description VARCHAR(100),
is_active BOOLEAN,

CONSTRAINT pk_category_id PRIMARY KEY(id)
);

CREATE TABLE Menu(

id IDENTITY NOT NULL,
name VARCHAR(50) NOT NULL,
description VARCHAR(100) NOT NULL,
image_url VARCHAR(255),
category_id INT,
business_email VARCHAR(255) NOT NULL ,

CONSTRAINT pk_menu_id PRIMARY KEY(id),
CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category (id),
CONSTRAINT fk_business_email FOREIGN KEY (business_email) REFERENCES food_outlet (email)
);

CREATE TABLE Product(

id IDENTITY NOT NULL,
code VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
unit_price DECIMAL(10,2) NOT NULL,
image_url VARCHAR(255),
description VARCHAR(255),
is_active BOOLEAN,
purchases INT DEFAULT 0,
views INT DEFAULT 0,
category_id INT,
menu_id INT,

CONSTRAINT pk_product_id PRIMARY KEY (id),
CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
CONSTRAINT fk_menu_id FOREIGN KEY (menu_id) REFERENCES menu (id)
);

CREATE TABLE Food_Outlet(

email VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
surname VARCHAR(255) NOT NULL,
phone_num VARCHAR(15) NOT NULL,
business_name VARCHAR(255) NOT NULL,
business_address VARCHAR(500) NOT NULL,
apt_suit VARCHAR(10),
number_of_locations INT NOT NULL,
weekly_orders INT NOT NULL,
cuisine_type VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,
recovery_response VARCHAR(500) NOT NULL,
enabled BOOLEAN NOT NULL,
is_active BOOLEAN NOT NULL,
account_id INT,
role_id INT NOT NULL,

CONSTRAINT pk_business_email PRIMARY KEY (email),
CONSTRAINT fk_business_account_id FOREIGN KEY (account_id) REFERENCES account (id),
CONSTRAINT fk_business_role_id FOREIGN KEY (role_id) REFERENCES role (id)
);


CREATE TABLE Driver(

email VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
phone_num VARCHAR(15) NOT NULL,
password VARCHAR(100) NOT NULL,
recovery_response VARCHAR(500) NOT NULL,
image_url VARCHAR(255),
vehicle_type VARCHAR(255),
orders_completed INT NOT NULL,
enabled BOOLEAN NOT NULL,
is_active BOOLEAN NOT NULL,
account_id INT,
role_id INT NOT NULL,

CONSTRAINT pk_driver_email PRIMARY KEY (email),
CONSTRAINT fk_driver_account_id FOREIGN KEY (account_id) REFERENCES account (id),
CONSTRAINT fk_driver_role_id FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE TABLE Customer(

email VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
surname VARCHAR(255) NOT NULL,
phone_num VARCHAR(15) NOT NULL,
password VARCHAR(100) NOT NULL,
recovery_response VARCHAR(500) NOT NULL,
is_active BOOLEAN NOT NULL,
enabled BOOLEAN NOT NULL,
account_id INT,
role_id INT NOT NULL,

CONSTRAINT pk_customer_email PRIMARY KEY (email),
CONSTRAINT fk_customer_account_id FOREIGN KEY (account_id) REFERENCES account (id),
CONSTRAINT fk_customer_role_id FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE TABLE Admin(

email VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
phone_num VARCHAR(15) NOT NULL,
password VARCHAR(100) NOT NULL,
recovery_response VARCHAR(500) NOT NULL,
is_active BOOLEAN NOT NULL,
enabled BOOLEAN NOT NULL,
role_id INT NOT NULL,

CONSTRAINT pk_email PRIMARY KEY (email),
CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE TABLE ROLE(

id IDENTITY NOT NULL,
role VARCHAR NOT NULL,

CONSTRAINT pk_role_id PRIMARY KEY (id)
);

CREATE TABLE ACCOUNT(

id IDENTITY NOT NULL,
account_num VARCHAR(255) NOT NULL,
account_holder VARCHAR(255) NOT NULL,
card_number VARCHAR(50) NOT NULL,
exp_date VARCHAR(6) NOT NULL,
cvc INT NOT NULL,
branch_code INT NOT NULL,
payment_method VARCHAR(50),

CONSTRAINT pk_account_id PRIMARY KEY (id)
);


CREATE TABLE User(

email VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
surname VARCHAR(255) NOT NULL,
phone_num VARCHAR(15) NOT NULL,
password VARCHAR(100) NOT NULL,
recovery_response VARCHAR(500) NOT NULL,
is_active BOOLEAN NOT NULL,
enabled BOOLEAN NOT NULL,
account_id INT,

CONSTRAINT pk_user_email PRIMARY KEY (email),
CONSTRAINT fk_userAccount_id FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE TABLE User_Role(

role_id INT NOT NULL,
email VARCHAR(255) NOT NULL,

PRIMARY KEY(role_id,email),
CONSTRAINT fk_userRole_id FOREIGN KEY (role_id) REFERENCES role (id),
CONSTRAINT fk_userRole_email FOREIGN KEY (email) REFERENCES user (email)

);