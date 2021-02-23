package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		// Arrange
		double amount = 200.0;
		double expectedValue = 196.0;
		Account account = new Account(1L, 0.0);
		
		// Act
		account.deposit(amount);
		
		// Assert
		Assertions.assertEquals(expectedValue, account.getBalance());
		
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