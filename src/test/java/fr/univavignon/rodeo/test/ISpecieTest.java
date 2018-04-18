package fr.univavignon.rodeo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;
import junit.framework.TestCase;

public class ISpecieTest extends TestCase {

	IAnimal isp;
	public ISpecie getinstance () {
		ISpecie is = Mockito.mock(ISpecie.class);
		IAnimalTest iss = new IAnimalTest();
		isp = iss.getinstance();
		 List<IAnimal> list = new ArrayList<IAnimal> (20);
		 list.add(isp);
		 
		Mockito.when(is.getArea()).thenReturn(42);
		Mockito.when(is.getAnimals()).thenReturn(list);
		
		
		return is;
	}
	@Test
	public void getArea() {
		ISpecie tester = getinstance();
		assertEquals(tester.getArea(), 42);
		
	}
	
	@Test
	public void getAnimals() {
		ISpecie tester = getinstance();
		assertEquals(tester.getAnimals().size(), 20);
	}
}
