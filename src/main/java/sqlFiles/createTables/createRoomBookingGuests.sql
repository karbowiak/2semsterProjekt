CREATE TABLE roomBookingGuests (
  bookingID INT NOT NULL IDENTITY(1,1),
  guestID INT NOT NULL,
  PRIMARY KEY (rentalID),
  FOREIGN KEY (rentalID) REFERENCES roomBookings(bookingID),
  FOREIGN KEY (guestID) REFERENCES persons(personID)
);