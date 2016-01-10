CREATE TABLE employees (
  employeeID INT NOT NULL IDENTITY(1,1),
  function VARCHAR(255) NOT NULL,
  PRIMARY KEY (employeeID),
  FOREIGN KEY (employeeID) REFERENCES persons(personID)
);