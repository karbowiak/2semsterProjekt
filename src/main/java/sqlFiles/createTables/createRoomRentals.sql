CREATE TABLE roomRentals (
  rentalID INT NOT NULL IDENTITY(1,1),
  roomID INT NOT NULL,
  guestID INT NOT NULL,
  bookingBureau INT NOT NULL,
  fromDate DATETIME NOT NULL DEFAULT(GETDATE()),
  toDate DATETIME NOT NULL DEFAULT(GETDATE()),
  priceBeforeDiscount FLOAT NOT NULL,
  discount FLOAT NOT NULL,
  totalPrice FLOAT NOT NULL,
  status INT NOT NULL,
  PRIMARY KEY (rentalID),
  FOREIGN KEY (roomID) REFERENCES rooms(roomID),
  FOREIGN KEY (guestID) REFERENCES persons(personID)
);