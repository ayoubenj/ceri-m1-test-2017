package fr.univavignon.rodeo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.readfile;
import junit.framework.TestCase;

public class ISpecieTest extends TestCase {

	IAnimal isp;
	
	public ISpecie getinstance () {
		ISpecie is = Mockito.mock(ISpecie.class);
		IAnimalTest iss = new IAnimalTest();
		isp = iss.getinstance();
		 List<IAnimal> list = new ArrayList<> ();
		 
		 for(int i=0; i<8 ; i++)
			 list.add(isp);
		 
		 
		 
		Mockito.when(is.getArea()).thenReturn(1);
		Mockito.when(is.getAnimals()).thenReturn(list);
		
		
		return is;
	}
	@Test
	public void testgetArea() {
		ISpecie tester = getinstance();
		assertEquals(tester.getArea(), 1);
		
	}
	
	@Test
	public void testgetAnimals() {
		ISpecie tester = getinstance();
		assertEquals(tester.getAnimals().size(), 8);
	}
}
