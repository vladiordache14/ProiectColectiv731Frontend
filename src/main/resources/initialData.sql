-- Execute this SQL script to add some initial data to the database. Replace "carshop" with the name of your used database before running the script.
INSERT INTO `carshop`.`users` (`username`, `email`, `role`, `password`) VALUES ('Daniel', 'daniel@yahoo.com', 'SELLER', 'abcd123');

INSERT INTO `carshop`.`adverts` (`description`, `is_active`, `is_blocked`, `is_promoted`, `name`, `price`, `seller_id`) VALUES ('The Alfa Romeo Giulia Quadrifoglio is a premium car model well-suited for urban navigation despite its high-performance nature.', b'1', b'0', b'0', 'Alfa Romeo Giulia Quadrifoglio', 50000, '1');

INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.unsplash.com/photo-1616411324381-88ee1e456143?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '1');
INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.unsplash.com/photo-1616411324381-21e0df163918?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '1');
INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.unsplash.com/photo-1616411501431-330ddc944cad?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '1');

INSERT INTO `carshop`.`adverts` (`description`, `is_active`, `is_blocked`, `is_promoted`, `name`, `price`, `seller_id`) VALUES ('This excellent vehicle, in good condition and with low mileage, offers style for your travels.', b'1', b'0', b'0', 'Honda Civic', 13000, '1');

INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.unsplash.com/photo-1612692165005-d22dc8db608e?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2');
INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.unsplash.com/photo-1612692165321-6d01bb734aa3?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2');
INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.unsplash.com/photo-1612692164174-305e2edfc6e2?q=80&w=1831&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2');

INSERT INTO `carshop`.`users` (`username`, `email`, `role`, `password`, `phone`) VALUES ('Bella', 'annabell@gmail.com', 'SELLER', 'DeFl34', '0754678341');

INSERT INTO `carshop`.`adverts` (`description`, `is_active`, `is_blocked`, `is_promoted`, `name`, `price`, `seller_id`) VALUES ('This car delivers powerful performance and a comfortable interior. Well-maintained with moderate mileage, it offers a driving excitement.', b'1', b'0', b'0', 'BMW M3 2017', 45000, '2');

INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.pexels.com/photos/11921988/pexels-photo-11921988.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2', '3');
INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.pexels.com/photos/257988/pexels-photo-257988.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2', '3');

INSERT INTO `carshop`.`adverts` (`description`, `is_active`, `is_blocked`, `is_promoted`, `name`, `price`, `seller_id`) VALUES ('With its low mileage and reliable performance, this car provides comfort.', b'1', b'0', b'0', 'Toyota Corolla', 11000, '2');

INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.unsplash.com/photo-1621536358994-93cc57fafa7a?q=80&w=1827&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '4');
INSERT INTO `carshop`.`images` (`url`, `advert_id`) VALUES ('https://images.unsplash.com/photo-1622488658426-0b6f6c7c68da?q=80&w=1827&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '4');