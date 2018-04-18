package fr.univavignon.rodeo.test;

import junit.framework.TestCase;

import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;



public class IAnimalTest extends TestCase {
	
	
	
	public IAnimal getinstance () {
		IAnimal ia = Mockito.mock(IAnimal.class);
		
		Mockito.when(ia.getXP()).thenReturn(42);
		Mockito.when(ia.isSecret()).thenReturn(true);
		Mockito.when(ia.isBoss()).thenReturn(true);
		
		
		return ia;
	}
	
	public void testgetXP() {
		IAnimal tester = getinstance();
		assertEquals(tester.getXP(), 42);

		
	}
	
	public boolean testisSecret() {
		return false;
		
	}
	public boolean testisEndangered() {
		return false;
		
	}
	
	public boolean testisBoss() {
		return false;
		
	}

}
