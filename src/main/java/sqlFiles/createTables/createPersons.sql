CREATE TABLE persons(
  personID INT NOT NULL IDENTITY(1,1),
  personFirstName VARCHAR(255) NOT NULL,
  personLastName VARCHAR(255) NOT NULL,
  personAddress VARCHAR(255) NOT NULL,
  personPassportInformation VARCHAR(255) DEFAULT(NULL),
  personPhoneNumber VARCHAR(255) NOT NULL,
  personEMail VARCHAR(255) NOT NULL,
  personBirthDate VARCHAR(255) NOT NULL,
  personFromCountry VARCHAR(255) NOT NULL,
  personType INT NOT NULL,
  personFunction VARCHAR(255) DEFAULT(NULL),
  PRIMARY KEY (personID)
);