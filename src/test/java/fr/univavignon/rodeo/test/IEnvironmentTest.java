package fr.univavignon.rodeo.test;




import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.Environment;
import junit.framework.TestCase;

public class IEnvironmentTest extends TestCase {

	ISpecie o;
	public IEnvironment getinstance () {
		IEnvironment ia = Mockito.mock(IEnvironment.class);
		ISpecieTest ist = new ISpecieTest();
		Environment env = new Environment("Savannah");
		 List<ISpecie> list = new ArrayList<>();
		 list.addAll(env.getSpecies());		 
		Mockito.when(ia.getAreas()).thenReturn(61);
		Mockito.when(ia.getSpecies()).thenReturn(list);
		
		
		return ia;
	}
	@Test
	public void testgetAreas() {
		IEnvironment tester = getinstance();
		assertEquals(tester.getAreas(), 61);
		
	}
	@Test
	public void testgetSpecies() {
		IEnvironment tester = getinstance();
		assertEquals(tester.getSpecies().size(), 61);
		
	}
	
}
