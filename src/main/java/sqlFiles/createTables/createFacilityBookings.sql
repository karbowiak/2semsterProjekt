CREATE TABLE facilityBookings (
  bookingID INT NOT NULL IDENTITY(1,1),
  facilityID INT NOT NULL,
  personID INT NOT NULL,
  fromDate DATETIME NOT NULL DEFAULT(GETDATE()),
  toDate DATETIME NOT NULL DEFAULT(GETDATE()),
  facilityPrice FLOAT NOT NULL,
  PRIMARY KEY (bookingID),
  FOREIGN KEY (facilityID) REFERENCES facilities(facilityID),
  FOREIGN KEY (personID) REFERENCES persons(personID)
);