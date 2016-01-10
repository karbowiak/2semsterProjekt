CREATE TABLE serviceTypes (
  serviceTypeID INT NOT NULL IDENTITY(1,1),
  name VARCHAR(255) NOT NULL,
  price VARCHAR(255) NOT NULL,
  serviceID VARCHAR(255) NOT NULL,
  PRIMARY KEY (serviceTypeID),
  FOREIGN KEY (serviceID) REFERENCES services(serviceID)
);