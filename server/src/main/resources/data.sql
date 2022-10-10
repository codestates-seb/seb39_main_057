/* Member */
INSERT INTO MEMBER(member_id, email, joined_at, modified_at, password, payment_method, phone_number, profile_image_url, provider, provider_id, role, username, p_location_id)
VALUES(1, 'test@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-1111-1111', 'www.test.com', 'provider', 'providerId', 0, 'Moni', null),
(2, 'test2@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-2222-1111', 'www.test.com', 'provider', 'providerId', 0, 'Cain', null),
(3, 'test3@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-3333-1111', 'www.test.com', 'provider', 'providerId', 0, 'GG', null),
(4, 'test4@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-4444-1111', 'www.test.com', 'provider', 'providerId', 0, 'Hwi', null),
(5, 'test5@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-5555-1111', 'www.test.com', 'provider', 'providerId', 0, 'Johnny', null),
(6, 'test6@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-6666-1111', 'www.test.com', 'provider', 'providerId', 0, 'Hwang', null),
(7, 'test7@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-7777-1111', 'www.test.com', 'provider', 'providerId', 0, 'James', null),
(8, 'test8@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-8888-1111', 'www.test.com', 'provider', 'providerId', 0, 'Minjung', null),
(9, 'test9@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-9999-1111', 'www.test.com', 'provider', 'providerId', 0, 'Hyunsuk', null),
(10, 'test10@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-0909-1111', 'www.test.com', 'provider', 'providerId', 0, 'Daun', null),
(11, 'test11@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-0808-1111', 'www.test.com', 'provider', 'providerId', 0, 'Hong', null),
(12, 'test12@naver.com', 1664436397982, 1664436397982, 'pass1234', 'card', '010-0707-1111', 'www.test.com', 'provider', 'providerId', 0, 'Narae', null);



/* Food_Category */
INSERT INTO FOOD_CATEGORY(food_category_id, category)
VALUES
(1, 'Pork feet'),
(2, 'Soup'),
(3, 'Japanese'),
(4, 'Pizza'),
(5, 'BBQ'),
(6, 'Western'),
(7, 'Chicken'),
(8, 'Chinese'),
(9, 'Asian'),
(10, 'Fast Food');

/* Locations */
INSERT INTO LOCATION(location_id, address_detail, create_at, kor_address, latitude, longitude, modified_at, name_of_place, type)
VALUES(1, 'Jejusi', 1664436396803, 'JDNC Center', 33.481510, 126.508923, 1664436396803, 'JDNC Center', 1),
(2, 'Jejusi', 1664436396803, 'Neo Villa', 33.483925, 126.511177, 1664436396803, 'Neo Villa', 1),
(3, 'Jejusi', 1664436396803, 'MoaMoa', 33.481491, 126.505095, 1664436396803, 'MoaMoa', 1),
(4, 'Jejusi', 1664436396803, 'Deo', 33.481043, 126.505006, 1664436396803, 'A villa', 1),
(5, 'Seogwipo', 1664436396803, 'Worldcup', 33.479625, 126.509207, 1664436396803, 'ABC mart', 1),
(6, 'Seogwipo', 1664436396803, 'Worldcup', 33.480956, 126.507233, 1664436396803, 'Hyundai Service Center', 1),
(7, 'Seogwipo', 1664436396803, 'Worldcup', 33.480124, 126.508979, 1664436396803, 'CU', 1),
(8, 'Seogwipo', 1664436396803, 'Worldcup', 33.480744, 126.513505, 1664436396803, 'Laon', 1),
(9, 'Seogwipo', 1664436396803, 'Worldcup', 33.481249, 126.504474, 1664436396803, 'Friends Screen Golf', 1),
(10, 'Seogwipo', 1664436396803, 'Worldcup', 33.481752, 126.503881, 1664436396803, 'Town Town', 1);

/* Items */
INSERT INTO ITEM(item_id, body, created_at, deadline, modified_at, recruit, restaurant_name, restaurant_url, title, food_category_id, image_url_image_url_id, member_id, p_location_id)
VALUES(1, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'SevenEleven', 'http://test-url.com', 'Title1', 1, null, 1, 1),
(2, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'Mcdonald', 'http://test-url.com', 'Title2', 2, null, 2, 2),
(3, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'BurgerKing', 'http://test-url.com', 'Title3', 1, null, 3, 3),
(4, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'Muger', 'http://test-url.com', 'Title4', 3, null, 1, 4),
(5, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'Raon', 'http://test-url.com', 'Title5', 4, null, 9, 6),
(6, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'BHC', 'http://test-url.com', 'Title6', 1, null, 5, 5),
(7, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'BBQ', 'http://test-url.com', 'Title7', 1, null, 6, 7),
(8, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'Domino', 'http://test-url.com', 'Title8', 2, null, 1, 9),
(9, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'PigPig', 'http://test-url.com', 'Title9', 1, null, 8, 10),
(10, 'Lets share the delivery fee', 1664436396803, 1664436396803, 1664436396803, 5, 'NeNe', 'http://test-url.com', 'Title10', 3, null, 11, 8);

/* Participants */
INSERT INTO PARTICIPANTS(participants_id, created_at, modified_at, type, item_id, member_id)
VALUES(1, 1664436396803, 1664436396803, 1, 10, 1),
(2, 1664436396803, 1664436396803, 1, 1, 1),
(3, 1664436396803, 1664436396803, 1, 1, 1),
(4, 1664436396803, 1664436396803, 1, 9, 1),
(5, 1664436396803, 1664436396803, 1, 10, 3),
(6, 1664436396803, 1664436396803, 1, 3, 9),
(7, 1664436396803, 1664436396803, 1, 3, 2),
(8, 1664436396803, 1664436396803, 1, 9, 12),
(9, 1664436396803, 1664436396803, 1, 3, 4),
(10, 1664436396803, 1664436396803, 1,2, 5),
(11, 1664436396803, 1664436396803, 1,5, 6),
(12, 1664436396803, 1664436396803, 1,6, 7),
(13, 1664436396803, 1664436396803, 1,8, 10),
(14, 1664436396803, 1664436396803, 1,7, 11);



