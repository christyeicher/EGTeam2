DROP PROCEDURE IF EXISTS Cleanup;
DELIMITER //
CREATE PROCEDURE Cleanup(IN cutoff TIMESTAMP)
BEGIN
	INSERT INTO MembershipArchive
	SELECT * FROM Membership
	WHERE updatedAt < cutoff;
DELETE FROM Membership WHERE updatedAt < cutoff;
END //
DELIMITER ;
