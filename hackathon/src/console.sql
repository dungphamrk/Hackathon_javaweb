create database product_managements;
use product_managements;

create table Category(
    category_id int auto_increment primary key ,
    category_name VARCHAR(50) not null unique ,
    description text,
    status BIT
);
create table Product (
    product_id int primary key auto_increment,
    product_name VARCHAR(100) not null ,
    description text,
    price double not null check ( price>0 ),
    image_url varchar(255),
    status bit DEFAULT 1 ,
    created_at datetime,
    category_id int not null,
    FOREIGN KEY (category_id) references Category(category_id)
);

DELIMITER //
create procedure get_all_categories()
BEGIN
    SELECT *
    FROM Category;
END //
// DELIMITER ;


DELIMITER //
create procedure find_category_by_name(name varchar(255))
begin
    select category_id ,category_name, description, status
    from Category
    where category_name Like name;
end //
// DELIMITER ;

DELIMITER //
create procedure find_category_by_id( id int)
begin
    select category_id ,category_name, description, status
    from Category
    where category_name = id;
end //
// DELIMITER ;

DELIMITER //
create procedure insert_category(
    p_name varchar(255),
    p_status BIT,
    p_description text
)
begin
    insert into Category(category_name, description, status) VALUE (
        p_name,p_description,p_status
        );
end //
// DELIMITER ;

DELIMITER //
create procedure update_category(
    p_id int,
    p_name varchar(255),
    p_status BIT,
    p_description text
)
begin
    update Category
    set description =p_description,
        status=p_status,
        category_name=p_name
    where category_id = p_id;
end //
// DELIMITER ;

DELIMITER //
create procedure delete_category(p_id int)
begin
    delete from Category where category_id= p_id;
end //
// DELIMITER ;



DELIMITER //
create procedure get_all_products()
BEGIN
    SELECT *
    FROM Product;
END //
// DELIMITER ;


DELIMITER //
create procedure find_product_by_name(name varchar(255))
begin
    select *
    from Product
    where product_name Like name;
end //
// DELIMITER ;

DELIMITER //
create procedure find_product_by_id( id int)
begin
    select *
    from Product
    where product_name = id;
end //
// DELIMITER ;

DELIMITER //
create procedure insert_product(
    p_name varchar(255),
    p_status BIT,
    p_description text,
    p_price double,
    p_image_url varchar(255),
    p_category_id int
)
begin
    insert into Product(product_name, description, status,price,image_url,category_id) VALUE (
    p_name,p_description,p_status,p_price,p_image_url,p_category_id
        );
end //
// DELIMITER ;

DELIMITER //
create procedure update_product(
    p_id int,
    p_name varchar(255),
    p_status BIT,
    p_description text,
    p_price double,
    p_image_url varchar(255),
    p_category_id int
)
begin
    update Product
    set description =p_description,
        status=p_status,
        product_name=p_name,
        price=p_price,
        image_url= p_image_url,
        category_id =p_category_id
    where product_id = p_id;
end //
// DELIMITER ;

DELIMITER //
create procedure delete_product(p_id int)
begin
    delete from Product where product_id= p_id;
end //
// DELIMITER ;