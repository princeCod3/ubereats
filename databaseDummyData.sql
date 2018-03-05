INSERT INTO category( id , name , description , is_active)
VALUES( 1 , 'BREAKFAST AND BRUNCH' , 'Get your morning started!', true);
-- category values --

INSERT INTO category( id , name , description , is_active)
VALUES( 2 , 'COFFEE AND TEA' , ' Get the best Coffee and Tea to you location!', true);

INSERT INTO category( id , name , description , is_active)
VALUES( 3 , 'ITALIAN' , 'We love Italian Food!', true );

INSERT INTO category( id , name , description , is_active)
VALUES( 4 , 'INDIAN' , 'We love Indian Food!', true);

INSERT INTO category( id , name , description, is_active)
VALUES( 5 ,'VEGETARIAN' , 'No Need For Meat!', true);

INSERT INTO category( id , name , description , is_active)
VALUES( 6 , 'SEAFOOD' , 'Bring the ocean to your table!', true);


-- product values--

INSERT INTO product(id, code, name, is_active, unit_price, category_id)
VALUES(1,'PRD567','CHICKEN CURRY', true, 89.99, 4);

INSERT INTO product(id, code, name, is_active, unit_price, category_id)
VALUES(2,'PRD568','CHICKEN CURRY AND BRYANI', true, 104.99, 4);

INSERT INTO product(id, code, name, is_active, unit_price, category_id)
VALUES(3,'PRD100','STRAWBERRY FUSE TEA', true, 30.99, 2);

INSERT INTO product(id, code, name, is_active, unit_price, category_id)
VALUES(4,'PRD789','MINT PASTA', true, 99.99, 3);

INSERT INTO product(id, code, name, is_active, unit_price, category_id)
VALUES(6,'PRD500','ROOIBOS TEA', true, 12.99, 2);
