CREATE TABLE rooms (
  roomID INT NOT NULL IDENTITY(1,1),
  roomDescription VARCHAR(128) NOT NULL,
  roomType INT NOT NULL,
  status INT NOT NULL,
  discount FLOAT NOT NULL,
  pricePerNight FLOAT NOT NULL,
  PRIMARY KEY (roomID),
);