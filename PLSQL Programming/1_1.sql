BEGIN
  FOR c in (SELECT c.DOB, l.LoanID, l.CustomerID FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID) LOOP
    IF MONTHS_BETWEEN(DOB, SYSDATE)/12 > 60 THEN 
      UPDATE Loans SET InterestRate = c.InterestRate -1 WHERE LoanID = c.LoanID;
    END IF;
  END LOOP;
END;
