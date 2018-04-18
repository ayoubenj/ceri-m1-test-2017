package fr.univavignon.rodeo.test;




import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;

import junit.framework.TestCase;

public class IEnvironmentTest extends TestCase {

	public IEnvironment getinstance () {
		IEnvironment ia = Mockito.mock(IEnvironment.class);
		
		Mockito.when(ia.getAreas()).thenReturn(42);
		//Mockito.when(ia.getSpecies()).thenReturn(true);
		
		
		return ia;
	}
	@Test
	public int testgetAreas() {
		return 0;
		
	}
	@Test
	public List<ISpecie> getSpecies() {
		return null;
		
	}
	
}
