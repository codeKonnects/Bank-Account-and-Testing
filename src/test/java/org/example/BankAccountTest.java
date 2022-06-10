package org.example;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {
    private BankAccount account;
    private static int count;

    @BeforeClass
    public static void BeforeClass(){
        System.out.println("This executes before any other test cases. Count = " + count++);
    }

    @Before
    public void setUp(){
        account = new BankAccount("David", "Temitope", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Test
    public void deposit() {
       double balance = account.deposit(200.00, true);
       assertEquals(1200.00,balance, 0.0);
    }

    @Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void withdraw_Notbranch() {
        double balance = account.withdraw(600.00, false);
    }

    @Test
    public void getBalance_deposit() {
       account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }
    @Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }
    @Test
    public void isChecking_true(){
        assertTrue(account.isChecking());
    }
    @Test
    public void isChecking_false(){
        assertTrue("The account is not a checking account", account.isChecking());
    }
    @AfterClass
    public static void AfterClass(){
        System.out.println("This executes after any test case. Count= " + count++);
    }

    @After
    public void tearDown(){
        System.out.println("Count = " + count++);
    }
}