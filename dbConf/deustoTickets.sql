DROP SCHEMA IF EXISTS deustoTickets;
DROP USER IF EXISTS 'spq'@'%';
CREATE SCHEMA IF NOT EXISTS deustoTickets;
CREATE USER IF NOT EXISTS 'spq'@'%' IDENTIFIED BY 'spq';
GRANT ALL ON deustoTickets.* TO 'spq'@'%';