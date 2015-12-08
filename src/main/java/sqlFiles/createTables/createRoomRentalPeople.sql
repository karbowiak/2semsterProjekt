CREATE TABLE roomRentalPeople (
  rentalID INT NOT NULL IDENTITY(1,1),
  guestID INT NOT NULL,
  PRIMARY KEY (rentalID),
  FOREIGN KEY (rentalID) REFERENCES roomRentals(rentalID),
  FOREIGN KEY (guestID) REFERENCES persons(personID)
);