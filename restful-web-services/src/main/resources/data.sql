INSERT INTO user_details (id, name, birth_date)
VALUES (1001, 'Ram', current_date());
INSERT INTO user_details (id, name, birth_date)
VALUES (1002, 'Laxman', current_date());
INSERT INTO user_details (id, name, birth_date)
VALUES (1003, 'Prashanth', current_date());

INSERT INTO post (id, description, user_id)
VALUES (2001, 'Java Spring Framework', 1001);
INSERT INTO post (id, description, user_id)
VALUES (2002, 'Learn AWS', 1001);
INSERT INTO post (id, description, user_id)
VALUES (2003, 'Learn DevOps', 1002);
INSERT INTO post (id, description, user_id)
VALUES (2004, 'Learn Java', 1002);
INSERT INTO post (id, description, user_id)
VALUES (2005, 'Get a job', 1003);
INSERT INTO post (id, description, user_id)
VALUES (2006, 'Choose Carer path', 1003);