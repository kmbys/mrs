CREATE TABLE meeting_room (
    room_id INTEGER NOT NULL AUTO_INCREMENT,
    room_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (room_id)
);

CREATE TABLE reservable_room (
    reserved_date DATE NOT NULL,
    room_id INTEGER NOT NULL,
    PRIMARY KEY (reserved_date, room_id),
    FOREIGN KEY (room_id) REFERENCES meeting_room (room_id)
);
