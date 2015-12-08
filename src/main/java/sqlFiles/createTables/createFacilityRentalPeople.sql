CREATE TABLE facilityRentalPeople (
  rentalID INT NOT NULL IDENTITY(1,1),
  guestID INT NOT NULL,
  PRIMARY KEY (rentalID),
  FOREIGN KEY (rentalID) REFERENCES facilityRentals(rentalID),
  FOREIGN KEY (guestID) REFERENCES persons(personID)
);