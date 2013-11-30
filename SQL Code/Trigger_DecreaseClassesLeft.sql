DROP TRIGGER IF EXISTS CAFitnessClub.DecreaseClassesLeft;
delimiter //
CREATE TRIGGER CAFitnessClub.DecreaseClassesLeft
AFTER INSERT ON Enrollment
FOR EACH ROW
  BEGIN 
	DECLARE classesAllowed INT;
	SET classesAllowed = (SELECT numClassesAllowed from Membership where Membership.m_memberID = New.e_memberID);
	SET classesAllowed = classesAllowed - 1; 
	UPDATE Membership SET numClassesAllowed = classesAllowed where m_memberID = new.e_memberID;


END//
delimiter ;