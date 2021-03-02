package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalancendDiscountFeeWhenPositiveAmount() {
		
		// Arrange
		double amount = 200.0;
		double expectedValue = 196.0;
		Account account = new Account(1L, 0.0);
		
		// Act
		account.deposit(amount);
		
		// Assert
		Assertions.assertEquals(expectedValue, account.getBalance());
		
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double expectedValue = 100.0;
		Account account = new Account(1L, expectedValue);
		double amount = -200.0;
		
		account.deposit(amount);
		
		Assertions.assertEquals(expectedValue, account.getBalance());

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