DROP TRIGGER IF EXISTS CAFitnessClub.UpdateExpAndNumClass;
delimiter //
CREATE TRIGGER CAFitnessClub.UpdateExpAndNumClass
BEFORE UPDATE ON Membership
FOR EACH ROW
BEGIN
IF (New.membershipType = "AU")
THEN
SET New.experation = DATE_ADD(now(), INTERVAL 1 YEAR);
SET New.numClassesAllowed = 365;
ELSEIF (New.membershipType = "MU")
THEN 
SET New.experation = DATE_ADD(now(), INTERVAL 30 DAY);
SET New.numClassesAllowed = 365;
ELSEIF (New.membershipType = "MC")
THEN 
SET New.experation = DATE_ADD(now(), INTERVAL 30 DAY);
SET New.numClassesAllowed = 5;
END IF;

END//
delimiter ;