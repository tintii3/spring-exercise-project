-- MOVIES
INSERT INTO movies (movie_title, movie_genre, movie_rating, is_active) VALUES ('Mission Impossible', 'Action', 7.1, true);
INSERT INTO movies (movie_title, movie_genre, movie_rating, is_active) VALUES ('Bullet Train', 'Action', 7.3, true);
INSERT INTO movies (movie_title, movie_genre, movie_rating, is_active) VALUES ('Pirates of the Caribbean', 'Adventure', 8.1, true);
INSERT INTO movies (movie_title, movie_genre, movie_rating, is_active) VALUES ('Wonder Woman', 'Fantasy', 7.4, true);
INSERT INTO movies (movie_title, movie_genre, movie_rating, is_active) VALUES ('The Equalizer', 'Action', 7.2, true);
INSERT INTO movies (movie_title, movie_genre, movie_rating, is_active) VALUES ('Fast Five', 'Action', 7.3, true);
INSERT INTO movies (movie_title, movie_genre, movie_rating, is_active) VALUES ('Transformers: Revenge of the Fallen', 'Action', 5.9, true);
INSERT INTO movies (movie_title, movie_genre, movie_rating, is_active) VALUES ('The Hunger Games', 'Action', 7.2, true);
INSERT INTO movies (movie_title, movie_genre, movie_rating, is_active) VALUES ('Lucy', 'Action', 6.4, true);


-- ACTORS
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Brad', 'Pitt', 58, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Tom', 'Cruise', 60, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Gal', 'Gadot', 37, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Vin', 'Diesel', 55, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Scarlett', 'Johansson', 37, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Denzel', 'Washington', 67, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Jennifer', 'Lawrence', 32, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Megan', 'Fox', 36, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Emma', 'Watson', 32, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Dwayne', 'Johnson', 50, true);
INSERT INTO actors (first_name, last_name, age, is_active) VALUES ('Johnny', 'Depp', 59, true);


-- ADDRESSES
INSERT INTO addresses (actor_id, street, city, country) VALUES (1, '3282 E Anaheim St', 'California', 'United States');
INSERT INTO addresses (actor_id, street, city, country) VALUES (2, '851 N Hollywood Way', 'New York', 'United States');
INSERT INTO addresses (actor_id, street, city, country) VALUES (3, '1401 Olive Rd', 'Mississippi', 'United States');
INSERT INTO addresses (actor_id, street, city, country) VALUES (4, '752 Lincolnway', 'Iowa', 'United States');
INSERT INTO addresses (actor_id, street, city, country) VALUES (5, '1436 Patton Ave', 'Nebraska', 'United States');
INSERT INTO addresses (actor_id, street, city, country) VALUES (6, '6 Blackcraig Rd', 'Hampshire', 'United Kingdom');
INSERT INTO addresses (actor_id, street, city, country) VALUES (7, '1959 Queen St E', 'Toronto', 'Canada');
INSERT INTO addresses (actor_id, street, city, country) VALUES (8, '825 Boulevard Lebourgneuf', 'Quebec', 'Canada');
INSERT INTO addresses (actor_id, street, city, country) VALUES (9, '2899 Northtowne Ln', 'North Carolina', 'United States');
INSERT INTO addresses (actor_id, street, city, country) VALUES (10, '500 N Atlantic Blvd', 'California', 'United States');


-- MOVIE ACTORS
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (1, 2, true);
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (2, 1, true);
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (4, 3, true);
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (3, 11, true);
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (6, 4, true);
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (6, 10, true);
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (7, 8, true);
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (8, 7, true);
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (5, 6, true);
INSERT INTO movie_actor (movie_id, actor_id, is_active) VALUES (9, 5, true);


-- MOVIE REVIEWS
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (5, 'Great movie.', 1, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (5, 'Excellent movie.', 1, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (5, 'Awesome film.', 2, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (5, 'Great movie, also funny.', 3, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (5, 'Funny movie.', 3, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (3, 'Not that good though.', 4, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (2, 'Expected more from it.', 4, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (1, 'Bad one.', 9, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (5, 'Would watch it again.', 2, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (4, 'Excellent one.', 3, true);
INSERT INTO movie_reviews (number_of_stars, review_description, movie_id, is_active) VALUES (5, 'Love it.', 1, true);