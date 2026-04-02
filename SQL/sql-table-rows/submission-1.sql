CREATE TABLE cities(
    name TEXT,
    population INTEGER,
    country TEXT,
    is_capital BOOLEAN,
    founded_date DATE
);







-- Do not modify below this line --
INSERT INTO cities (name, population, country, is_capital, founded_date) 
VALUES ('New York', 8175133, 'United States', FALSE, '1624-01-01'),
        ('Beijing', 21516000, 'China', TRUE, '1045-01-01'),
        ('Paris', 2243833, 'France', TRUE, '0259-01-01'),
        ('London', 8136000, 'United Kingdom', TRUE, '0043-01-01'),
        ('New Delhi', 14200467, 'India', TRUE, '1911-01-01'),
        ('Mexico City', 8851080, 'Mexico', TRUE, '1325-01-01'),
        ('Sao Paulo', 11316149, 'Brazil', FALSE, '1554-01-01'),
        ('Jakarta', 10075310, 'Indonesia', TRUE, '1527-01-01'),
        ('Karachi', 14910352, 'Pakistan', FALSE, '1729-01-01');

SELECT * FROM cities;
