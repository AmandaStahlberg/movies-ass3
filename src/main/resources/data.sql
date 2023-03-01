INSERT INTO franchise (name, description) VALUES ('franchiseName1', 'description1');
INSERT INTO franchise (name, description) VALUES ('franchiseName2', 'description2');
INSERT INTO franchise (name, description) VALUES ('franchiseName3', 'description3');
INSERT INTO franchise (name, description) VALUES ('franchiseName4', 'description4');

INSERT INTO character (name, gender, picture) VALUES ('CharacterName1','Male', 'picture1');
INSERT INTO character (name, gender, picture) VALUES ('CharacterName2', 'Female', 'picture2');
INSERT INTO character (name, alias, gender, picture) VALUES ('CharacterName3', 'alias3', 'Male', 'picture3');
INSERT INTO character (name, alias, gender, picture) VALUES ('CharacterName4', 'alias4', 'Male', 'picture4');
INSERT INTO character (name, alias, gender, picture) VALUES ('CharacterName5', 'alias5', 'Male', 'picture5');
INSERT INTO character (name, gender, picture) VALUES ('CharacterName6',  'Female', 'picture6');
INSERT INTO character (name,  gender, picture) VALUES ('CharacterName7',  'Male', 'picture7');

INSERT INTO movie (director, genre, title, release, picture,  trailer, franchise_id) VALUES ('director1', 'genre1', 'title1', '1994', 'picture1',  'trailer1',2);
INSERT INTO movie (director, genre, title, release, picture,  trailer, franchise_id) VALUES ('director2', 'genre2', 'title2', '1971','picture2', 'trailer2',1);
INSERT INTO movie (director, genre, title, release, picture,  trailer, franchise_id) VALUES ('director3', 'genre3', 'title3', '2001','picture3', 'trailer3', 3);
INSERT INTO movie (director, genre, title, release, picture,  trailer, franchise_id) VALUES ('director4', 'genre4', 'title4', '2001','picture4', 'trailer4', 3);
INSERT INTO movie (director, genre, title, release, picture,  trailer, franchise_id) VALUES ('director5', 'genre5', 'title5', '1999','picture5', 'trailer5', 4);
INSERT INTO movie (director, genre, title, release, picture,  trailer, franchise_id) VALUES ('director6', 'genre6', 'title6', '2003','picture6', 'trailer6', 4);
INSERT INTO movie (director, genre, title, release, picture,  franchise_id) VALUES ('director7', 'genre7', 'title', '2012','picture7', 1);

INSERT INTO movie_character(movie_id, character_id) VALUES ('1', '1');
INSERT INTO movie_character(movie_id, character_id) VALUES ('2', '2');
INSERT INTO movie_character(movie_id, character_id) VALUES ('3', '3');
INSERT INTO movie_character(movie_id, character_id) VALUES ('4', '3');
INSERT INTO movie_character(movie_id, character_id) VALUES ('4', '4');
INSERT INTO movie_character(movie_id, character_id) VALUES ('5', '5');
INSERT INTO movie_character(movie_id, character_id) VALUES ('6', '5');
INSERT INTO movie_character(movie_id, character_id) VALUES ('5', '6');
INSERT INTO movie_character(movie_id, character_id) VALUES ('6', '6');
INSERT INTO movie_character(movie_id, character_id) VALUES ('7', '7');