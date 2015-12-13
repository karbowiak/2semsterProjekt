CREATE TABLE roomBookingGuests (
    bookingID INT NOT NULL IDENTITY(1,1),
    guestID INT NOT NULL,
    PRIMARY KEY (bookingID),
    FOREIGN KEY (bookingID) REFERENCES roomBookings(bookingID),
    FOREIGN KEY (guestID) REFERENCES persons(personID)
  );