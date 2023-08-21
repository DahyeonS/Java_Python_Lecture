--SELECT DISTINCT Country FROM Customers;
--SELECT COUNT(DISTINCT country) FROM Customers;
SELECT * FROM Customers WHERE Country <> 'Mexico';

SELECT * FROM Orders WHERE Freight > 50;

SELECT COUNT(DISTINCT country) FROM Customers;
SELECT * FROM Customers WHERE Country = 'Germany' AND City = 'Berlin';