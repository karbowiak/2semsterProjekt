CREATE TABLE guests (
  guestID INT NOT NULL IDENTITY(1,1),
  email VARCHAR(255) NOT NULL,
  passportNumber VARCHAR(255) NOT NULL,
  birthDay VARCHAR(255) NOT NULL,
  PRIMARY KEY (guestID),
  FOREIGN KEY (guestID) REFERENCES persons(personID)
);