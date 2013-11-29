DROP TRIGGER IF EXISTS CAFitnessClub.RemoveEnrollment;
delimiter //
CREATE TRIGGER CAFitnessClub.RemoveEnrollment
BEFORE DELETE ON Membership
FOR EACH ROW
  BEGIN
    DELETE FROM Enrollment
    WHERE Old.m_memberID = Enrollment.e_memberID;
  END//
delimiter ;