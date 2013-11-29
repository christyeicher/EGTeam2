DROP TRIGGER IF EXISTS CAFitnessClub.CheckMembership;
delimiter //
CREATE TRIGGER CAFitnessClub.CheckMembership
BEFORE INSERT ON Enrollment
FOR EACH ROW
  BEGIN
    DECLARE classesAllowed INT;
	SET classesAllowed = (SELECT numClassesAllowed from Membership, 
	Member, Enrollment where Enrollment.memberID = Member.memberID and Member.memberID = Membership.memberID);
    IF classesAllowed > 0 AND (new.e_memberID, new.e_classID) NOT IN (SELECT * FROM Enrollment)
	THEN SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'Cannot Enroll Member. Membership has no classes left or is Enrolled already';
	END IF;

    END//
delimiter ;