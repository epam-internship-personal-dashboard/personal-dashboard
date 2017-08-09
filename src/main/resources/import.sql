INSERT INTO `personaldashboard`.`address` (`id`, `houseNumber`, `street`, `zipCode`, `city`, `country`) VALUES ('1', '23Y', 'Pitt stret', '23234', 'Bordory', 'Yemen');

INSERT INTO `personaldashboard`.`address` (`id`, `houseNumber`, `street`, `zipCode`, `city`, `country`) VALUES ('2', '88B', 'Carl street', '23009', 'Cornrow', 'China');

INSERT INTO `personaldashboard`.`address` (`id`, `houseNumber`, `street`, `zipCode`, `city`, `country`) VALUES ('3', '60', 'Beet Root', '2324', 'Abuja', 'Nigeria');

INSERT INTO `personaldashboard`.`user` (`id`, `name`, `username`, `email`, `password`, `birthday`, `gender`, `role`, `address_id`, `enabled`) VALUES ('1', 'Lola Ben', 'lola.ben', 'lola.ben@gmail.com', 'lola.ben', '1998-08-09', 'FEMALE', 'ROLE_USER', '1', '1');

INSERT INTO `personaldashboard`.`user` (`id`, `name`, `username`, `email`, `password`, `birthday`, `gender`, `role`, `address_id`, `enabled`) VALUES ('2', 'Sam Pitt', 'sam.pitt', 'sam.pitt@gmail.com', 'sam.pitt', '1998-09-09', 'MALE', 'ROLE_USER', '2', '1');

INSERT INTO `personaldashboard`.`user` (`id`, `name`, `username`, `email`, `password`, `birthday`, `gender`, `role`, `address_id`, `enabled`) VALUES ('3', 'Judy Carl', 'judy.carl', 'judy.carl@gmail.com', 'judy.carl', '1998-09-09', 'FEMALE', 'ROLE_ADMIN', '3', '1');