package fr.univavignon.rodeo.test;

import junit.framework.TestCase;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;



public class IAnimalTest extends TestCase {
	
	
	
	public IAnimal getinstance () {
		IAnimal ia = Mockito.mock(IAnimal.class);
		
		Mockito.when(ia.getXP()).thenReturn(42);
		Mockito.when(ia.isSecret()).thenReturn(true);
		Mockito.when(ia.isBoss()).thenReturn(true);
		Mockito.when(ia.isEndangered()).thenReturn(true);
		
		return ia;
	}
	
	@Test
	public void testgetXP() {
		IAnimal tester = getinstance();
		assertEquals(tester.getXP(), 42);

		
	}
	@Test
	public void testisSecret() {
		IAnimal tester = getinstance();
		assertEquals(tester.isSecret(), true);
		
	}
	@Test
	public void testisEndangered() {
		IAnimal tester = getinstance();
		assertEquals(tester.isEndangered(), true);
		
	}
	@Test
	public void testisBoss() {
		IAnimal tester = getinstance();
		assertEquals(tester.isBoss(), true);
		
	}

}
