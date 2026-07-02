-- COVID Database Schema and Operations
-- Compatible with MySQL / MariaDB

CREATE DATABASE IF NOT EXISTS covid_db;
USE covid_db;

-- 1. Create tables
CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases BIGINT NOT NULL,
    recoveries BIGINT DEFAULT 0,
    population BIGINT NOT NULL
);

CREATE TABLE covid_deaths (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    deaths BIGINT NOT NULL DEFAULT 0
);

CREATE TABLE covid_vaccines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    vaccines_administered BIGINT NOT NULL DEFAULT 0,
    vaccinated_people BIGINT NOT NULL DEFAULT 0
);

-- 2. Insert initial COVID case data
INSERT INTO covid_cases (country, report_date, confirmed_cases, recoveries, population)
VALUES
    ('India', '2025-01-01', 1000000, 900000, 1400000000),
    ('India', '2025-01-15', 1200000, 950000, 1400000000),
    ('USA', '2025-01-01', 5000000, 4500000, 331000000),
    ('USA', '2025-01-15', 5200000, 4600000, 331000000),
    ('UK', '2025-01-01', 2000000, 1800000, 68000000),
    ('UK', '2025-01-15', 2100000, 1850000, 68000000);

-- Optional sample data for other tables
INSERT INTO covid_deaths (country, report_date, deaths)
VALUES
    ('India', '2025-01-01', 15000),
    ('USA', '2025-01-01', 250000),
    ('UK', '2025-01-01', 80000);

INSERT INTO covid_vaccines (country, report_date, vaccines_administered, vaccinated_people)
VALUES
    ('India', '2025-01-01', 5000000, 4000000),
    ('USA', '2025-01-01', 8000000, 7000000),
    ('UK', '2025-01-01', 3000000, 2500000);

-- 3. Update case information
UPDATE covid_cases
SET confirmed_cases = 1250000
WHERE country = 'India' AND report_date = '2025-01-15';

-- 4. Delete incorrect or duplicate records
-- Example: remove incorrect country code entry
DELETE FROM covid_cases
WHERE country = 'IN';

-- Example: remove duplicate rows for the same country and date
INSERT INTO covid_cases (country, report_date, confirmed_cases, recoveries, population)
VALUES ('India', '2025-01-20', 1300000, 1000000, 1400000000);

INSERT INTO covid_cases (country, report_date, confirmed_cases, recoveries, population)
VALUES ('India', '2025-01-20', 1300000, 1000000, 1400000000);

DELETE c1
FROM covid_cases c1
JOIN covid_cases c2
  ON c1.country = c2.country
 AND c1.report_date = c2.report_date
 AND c1.id > c2.id;

-- 5. Alter table to add vaccination information
ALTER TABLE covid_cases
ADD COLUMN vaccination_rate DECIMAL(5,2) DEFAULT 0.00;

-- Optional: update the new column for sample data
UPDATE covid_cases
SET vaccination_rate = 60.50
WHERE country = 'India' AND report_date = '2025-01-15';

UPDATE covid_cases
SET vaccination_rate = 75.20
WHERE country = 'USA' AND report_date = '2025-01-15';

UPDATE covid_cases
SET vaccination_rate = 68.10
WHERE country = 'UK' AND report_date = '2025-01-15';

-- View the final data
SELECT * FROM covid_cases;
SELECT * FROM covid_deaths;
SELECT * FROM covid_vaccines;
