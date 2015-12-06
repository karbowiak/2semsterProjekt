CREATE TABLE facilityRentals (
  rentalID INT NOT NULL IDENTITY(1,1),
  facilityID INT NOT NULL,
  guestID INT NOT NULL,
  fromDate DATETIME NOT NULL DEFAULT(GETDATE()),
  toDate DATETIME NOT NULL DEFAULT(GETDATE()),
  price FLOAT NOT NULL,
  PRIMARY KEY (rentalID),
  FOREIGN KEY (facilityID) REFERENCES facilities(facilityID),
  FOREIGN KEY (guestID) REFERENCES persons(personID)
);