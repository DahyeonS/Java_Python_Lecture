--USE memberdb;

--SELECT DISTINCT Country FROM Customers;
--SELECT COUNT(DISTINCT country) FROM Customers;

-- 같지 않음
SELECT * FROM Customers WHERE Country <> 'Mexico';
SELECT * FROM Customers WHERE Country != 'Mexico';

-- 숫자 범위 지정
SELECT * FROM Orders WHERE Freight > 50;

-- 문자열 범위 지정
SELECT COUNT(DISTINCT country) FROM Customers;
SELECT * FROM Customers WHERE Country = 'Germany' AND City = 'Berlin';
SELECT * FROM Customers WHERE Country = 'Germany' OR City = 'Berlin';

SELECT * FROM Customers WHERE Country = 'Germany' AND (City = 'Berlin' OR City = 'Lulea');

SELECT * FROM Customers WHERE Country = 'Germany' AND NOT Country = 'USA';
SELECT * FROM Customers WHERE NOT Country = 'Germany' AND NOT Country = 'USA';
SELECT * FROM Customers WHERE NOT (Country = 'Germany' AND NOT Country = 'USA');

-- 정렬
SELECT * FROM Customers ORDER BY Country;
SELECT City, Country FROM Customers ORDER BY Country;
SELECT City, Country FROM Customers ORDER BY Country, City;
SELECT City, Country FROM Customers ORDER BY Country, City DESC;

-- NULL
SELECT * FROM Customers WHERE Fax = NULL; -- X
SELECT * FROM Customers WHERE Fax != NULL; -- X
SELECT * FROM Customers WHERE Fax IS NULL;
SELECT * FROM Customers WHERE Fax IS NOT NULL;
SELECT * FROM Customers WHERE Fax IS NULL AND Region IS NULL;

-- 집계 함수
SELECT TOP 3 * FROM Products;

SELECT MIN(UnitPrice) FROM Products;
SELECT MAX(UnitPrice) FROM Products;
SELECT COUNT(ProductID) FROM Products;
SELECT AVG(UnitPrice) FROM Products;
SELECT SUM(UnitPrice) / COUNT(UnitPrice) FROM Products;

-- LIKE
SELECT * FROM Customers WHERE Country LIKE '%a';
SELECT * FROM Customers WHERE City LIKE 'a%';
SELECT * FROM Customers WHERE CompanyName LIKE '%or%';

-- IN
SELECT TOP 3 Country FROM Customers;
SELECT * FROM Customers WHERE Country = 'Argentina' OR Country = 'Belgium' ORDER BY Country;
SELECT * FROM Customers WHERE Country IN ('Argentina', 'Belgium') ORDER BY Country;
SELECT * FROM Customers WHERE Country NOT IN ('Argentina', 'Belgium') ORDER BY Country;
SELECT * FROM Customers WHERE Country NOT IN (SELECT DISTINCT TOP 3 Country FROM Customers ORDER BY Country) ORDER BY Country;

-- BETWEEN
SELECT TOP 3 * FROM Products;
SELECT COUNT(*) FROM Products WHERE UnitPrice >= 10 AND UnitPrice <= 20;
SELECT COUNT(*) FROM Products WHERE UnitPrice BETWEEN 10 AND 20;
SELECT * FROM Products WHERE UnitPrice NOT BETWEEN 10 AND 20;
SELECT * FROM Products WHERE UnitPrice BETWEEN 10 AND 20 AND CategoryID NOT IN (1, 2, 3);

SELECT * FROM Products ORDER BY ProductName;
SELECT * FROM Products WHERE ProductName BETWEEN 'Camembert Pierrot' AND 'Cote de Blaye' ORDER BY ProductName;
SELECT * FROM Products WHERE ProductName BETWEEN 'C' AND 'K' ORDER BY ProductName;

SELECT * FROM Orders WHERE OrderDate BETWEEN '1996-07-01' AND '1996-08-01';

-- INNER JOIN
SELECT TOP 3 * FROM Customers;
SELECT TOP 3 * FROM Orders;
SELECT * FROM Customers INNER JOIN Orders ON Customers.CustomerID = Orders.CustomerID;
SELECT * FROM Customers c INNER JOIN Orders o ON c.CustomerID = o.CustomerID;