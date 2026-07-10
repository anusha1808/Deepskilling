CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
  UPDATE Accounts SET Balance = 1.01* Balance 
  WHERE AccountType = 'Savings';
  
  EXCEPTION 
    WHEN OTHERS THEN dbms_output.put_line( SQLERRM );
END;
