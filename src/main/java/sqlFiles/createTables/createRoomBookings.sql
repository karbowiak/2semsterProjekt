CREATE TABLE roomBookings (
  bookingID INT NOT NULL IDENTITY(1,1),
  roomID INT NOT NULL,
  bookingBureau INT NOT NULL,
  fromDate DATETIME NOT NULL DEFAULT(GETDATE()),
  toDate DATETIME NOT NULL DEFAULT(GETDATE()),
  checkinDate DATETIME NOT NULL DEFAULT(GETDATE()),
  checkoutDate DATETIME NOT NULL DEFAULT(GETDATE()),
  priceBeforeDiscount FLOAT NOT NULL,
  discount FLOAT NOT NULL,
  totalPrice FLOAT NOT NULL,
  employeeID INT NOT NULL,
  PRIMARY KEY (rentalID),
  FOREIGN KEY (roomID) REFERENCES rooms(roomID),
  FOREIGN KEY (employeeID) REFERENCES persons(personID)
);