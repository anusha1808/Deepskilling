BEGIN
  SELECT * INTO acc_info_1 FROM Accounts WHERE AccountID = acc1;
  SELECT * INTO acc_info_2 FROM Accounts WHERE AccountID = acc2;

  IF acc_info_1.Balance >= Amount THEN
    UPDATE Accounts SET Balance = Balance - Amount WHERE AccountID = acc1;
    UPDATE Accounts SET Balance = Balance + Amount WHERE AccountID = acc2;

    commit;

    dbms_output.put_line('done successfully');

  ELSE
    dbms_output.put_line('Insufficient balance');
  END IF;

  EXCEPTION WHEN OTHERS THEN 
    rollback;
    dbms_output.put_line( SQLERRM );
END TransferFunds;
/
