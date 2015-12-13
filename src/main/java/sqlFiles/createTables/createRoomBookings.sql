CREATE TABLE roomBookings (
  bookingID INT NOT NULL IDENTITY(1,1),
  roomID INT NOT NULL,
  bookingBureau INT NOT NULL,
  fromDate DATETIME NOT NULL DEFAULT(GETDATE()),
  toDate DATETIME NOT NULL DEFAULT(GETDATE()),
  checkinDate DATETIME NULL DEFAULT(NULL),
  checkoutDate DATETIME NULL DEFAULT(NULL),
  priceBeforeDiscount FLOAT NOT NULL,
  discount FLOAT NOT NULL,
  totalPrice FLOAT NOT NULL,
  employeeID INT NOT NULL,
  bookingActive INT DEFAULT 1,
  PRIMARY KEY (bookingID),
  FOREIGN KEY (roomID) REFERENCES rooms(roomID),
  FOREIGN KEY (employeeID) REFERENCES persons(personID)
);