CREATE TABLE roomBookings (
  bookingID INT NOT NULL IDENTITY(1,1),
  roomID INT NOT NULL,
  bookingBureau INT NOT NULL,
  fromDate VARCHAR(255) NOT NULL DEFAULT('0000-00-00 00:00:00'),
  toDate VARCHAR(255) NOT NULL DEFAULT('0000-00-00 00:00:00'),
  checkinDate VARCHAR(255) NULL DEFAULT('0000-00-00 00:00:00'),
  checkoutDate VARCHAR(255) NULL DEFAULT('0000-00-00 00:00:00'),
  priceBeforeDiscount FLOAT NOT NULL,
  discount FLOAT NOT NULL,
  totalPrice FLOAT NOT NULL,
  employeeID INT NOT NULL,
  bookingActive INT DEFAULT 1,
  PRIMARY KEY (bookingID),
  FOREIGN KEY (roomID) REFERENCES rooms(roomID),
  FOREIGN KEY (employeeID) REFERENCES persons(personID)
);