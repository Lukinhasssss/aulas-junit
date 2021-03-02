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
	
}

/*
 * 		Nomenclatura de um teste
 * 
 * 	• <AÇÃO> should <EFEITO> [when <CENÁRIO>]
 * 
 * 		Padrão AAA
 * 
 * 	• Arrange: instancie os objetos necessários
 * 	• Act: execute as ações necessárias
 * 	• Assert: declare o que deveria acontecer (resultado esperado)
 * 
 */