package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalancendDiscountFeeWhenPositiveAmount() {
		
		// Arrange
		double amount = 200.0;
		double expectedValue = 196.0;
		Account account = AccountFactory.createEmptyAccount();
		
		// Act
		account.deposit(amount);
		
		// Assert
		Assertions.assertEquals(expectedValue, account.getBalance());
		
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double expectedValue = 100.0;
		Account account = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		account.deposit(amount);
		
		Assertions.assertEquals(expectedValue, account.getBalance());

	}
	
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account account = AccountFactory.createAccount(initialBalance);
		
		double result = account.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == account.getBalance());
		Assertions.assertTrue(result == initialBalance);
		
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account account = AccountFactory.createAccount(800.0);
		
		account.withdraw(500.0);
		
		Assertions.assertEquals(300.0, account.getBalance());
		
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account account = AccountFactory.createAccount(800.0);
			account.withdraw(801.0);
		});
		
	}
	
}

/*
 * 		Nomenclatura de um teste
 * 
 * 	� <A��O> should <EFEITO> [when <CEN�RIO>]
 * 
 * 		Padr�o AAA
 * 
 * 	� Arrange: instancie os objetos necess�rios
 * 	� Act: execute as a��es necess�rias
 * 	� Assert: declare o que deveria acontecer (resultado esperado)
 * 
 */