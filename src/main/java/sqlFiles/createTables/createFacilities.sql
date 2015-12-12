CREATE TABLE facilities (
  facilityID INT NOT NULL IDENTITY(1,1),
  facilityType VARCHAR(128) NOT NULL,
  facilityDescription VARCHAR(128) NOT NULL,
  facilityStatus INT NOT NULL,
  facilityPricePerHour FLOAT NOT NULL,
  PRIMARY KEY (facilityID),
);