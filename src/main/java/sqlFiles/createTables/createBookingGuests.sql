CREATE TABLE bookingGuests (
  bookingID INT NOT NULL,
  guestID INT NOT NULL,
  FOREIGN KEY (bookingID) REFERENCES bookings(bookingID),
  FOREIGN KEY (guestID) REFERENCES guests(guestID)
);