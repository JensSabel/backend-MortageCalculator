CREATE TABLE IF NOT EXISTS calculations (
id INT AUTO_INCREMENT PRIMARY KEY,
userName VARCHAR,
totalLoan DOUBLE,
annualLoan INTEGER,
monthlyLoan INTEGER,
annualInterest DOUBLE,
monthlyInterest DOUBLE,
monthlyPayment VARCHAR
);