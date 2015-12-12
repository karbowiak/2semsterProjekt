CREATE TABLE rooms (
  roomID INT NOT NULL IDENTITY(1,1),
  roomDescription VARCHAR(128) NOT NULL,
  roomSize INT NOT NULL,
  roomStatus INT NOT NULL,
  roomDiscount FLOAT NOT NULL,
  roomPricePerNight FLOAT NOT NULL,
  PRIMARY KEY (roomID),
);