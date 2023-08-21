--USE memberdb;

--SELECT DISTINCT Country FROM Customers;
--SELECT COUNT(DISTINCT country) FROM Customers;
SELECT * FROM Customers WHERE Country <> 'Mexico';

SELECT * FROM Orders WHERE Freight > 50;

SELECT COUNT(DISTINCT country) FROM Customers;
SELECT * FROM Customers WHERE Country = 'Germany' AND City = 'Berlin';
SELECT * FROM Customers WHERE Country = 'Germany' OR City = 'Berlin';

SELECT * FROM Customers WHERE Country = 'Germany' AND (City = 'Berlin' OR City = 'Lulea');

SELECT * FROM Customers WHERE Country = 'Germany' AND NOT Country = 'USA';
SELECT * FROM Customers WHERE NOT Country = 'Germany' AND NOT Country = 'USA';
SELECT * FROM Customers WHERE NOT (Country = 'Germany' AND NOT Country = 'USA');

SELECT * FROM Customers ORDER BY Country;
SELECT City, Country FROM Customers ORDER BY Country;
SELECT City, Country FROM Customers ORDER BY Country, City;
SELECT City, Country FROM Customers ORDER BY Country, City DESC;

SELECT * FROM Customers WHERE Fax = NULL; -- X
SELECT * FROM Customers WHERE Fax != NULL; -- X
SELECT * FROM Customers WHERE Fax IS NULL;
SELECT * FROM Customers WHERE Fax IS NOT NULL;
SELECT * FROM Customers WHERE Fax IS NULL AND Region IS NULL;

SELECT TOP 3 * FROM Products;

SELECT MIN(UnitPrice) FROM Products;
SELECT MAX(UnitPrice) FROM Products;
SELECT COUNT(ProductID) FROM Products;
SELECT AVG(UnitPrice) FROM Products;
SELECT SUM(UnitPrice) / COUNT(UnitPrice) FROM Products;
