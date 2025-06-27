
DECLARE
    v_customer_id Customers.CustomerID%TYPE;
    v_dob Customers.DOB%TYPE;
    v_age NUMBER;
BEGIN
    FOR cust IN (SELECT CustomerID, DOB FROM Customers) LOOP
        v_customer_id := cust.CustomerID;
        v_dob := cust.DOB;

        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, v_dob) / 12);
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || ', DOB: ' || TO_CHAR(v_dob, 'YYYY-MM-DD') || ', Age: ' || v_age);

        IF v_age > 60 THEN
            
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest rate discount process completed');
END;
