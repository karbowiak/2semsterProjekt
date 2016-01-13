CREATE TABLE bookings (
  bookingID INT NOT NULL IDENTITY(1,1),
  travelAgency VARCHAR(255) NOT NULL,
  paymentType VARCHAR(255) NOT NULL,
  checkInDate VARCHAR(255) NOT NULL,
  checkOutDate VARCHAR(255) NOT NULL,
  employeeID INT NOT NULL,
  PRIMARY KEY (bookingID),
  FOREIGN KEY (employeeID) REFERENCES employees(employeeID)
);