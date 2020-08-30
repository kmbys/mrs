INSERT INTO meeting_room (room_name) VALUES ('札幌');
INSERT INTO meeting_room (room_name) VALUES ('旭川');
INSERT INTO meeting_room (room_name) VALUES ('帯広');
INSERT INTO meeting_room (room_name) VALUES ('釧路');
INSERT INTO meeting_room (room_name) VALUES ('稚内');
INSERT INTO meeting_room (room_name) VALUES ('網走');
INSERT INTO meeting_room (room_name) VALUES ('函館');

INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 2);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 3);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 4);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 5);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 6);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 7);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 2);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 3);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 4);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 5);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 6);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 7);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 2);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 3);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 4);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 5);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 6);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 7);

INSERT INTO usr (user_id, first_name, last_name, password, rome_name) VALUES ('taro-yamada', '太郎', '山田', 'aaa', 'USER');
INSERT INTO usr (user_id, first_name, last_name, password, rome_name) VALUES ('jiro-yamada', '次郎', '山田', 'bbb', 'USER');

INSERT INTO reservation (start_time, end_time, reserved_date, room_id, user_id) VALUES ('13:00', '14:00', CURRENT_DATE, '1', 'taro-yamada');
INSERT INTO reservation (start_time, end_time, reserved_date, room_id, user_id) VALUES ('14:00', '15:00', CURRENT_DATE, '2', 'jiro-yamada');
