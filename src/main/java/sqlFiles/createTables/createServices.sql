CREATE TABLE services (
  serviceID INT NOT NULL IDENTITY(1,1),
  type VARCHAR(255) NOT NULL,
  date VARCHAR(255) NOT NULL,
  numberOfServices VARCHAR(255) NOT NULL,
  bookingID VARCHAR(255) NOT NULL,
  PRIMARY KEY (serviceID),
  FOREIGN KEY (bookingID) REFERENCES bookings(bookingID)
);