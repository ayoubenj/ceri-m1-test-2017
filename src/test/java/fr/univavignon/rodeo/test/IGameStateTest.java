package fr.univavignon.rodeo.test;

import junit.framework.TestCase;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;

public class IGameStateTest extends TestCase {
	
	ISpecie isp;
	public IGameState getinstance () {
		IGameState ia = Mockito.mock(IGameState.class);
		ISpecieTest ispt = new ISpecieTest();
		isp = ispt.getinstance();
		//Mockito.when(ia.exploreAreas()).thenReturn(42);
		//Mockito.when(ia.catchAnimal()).thenReturn(true);
		Mockito.when(ia.getSpecieLevel(isp)).thenReturn(SpecieLevel.NOVICE);
		Mockito.when(ia.getProgression()).thenReturn(24);
		
		return ia;
	}

	/*public void exploreAreas() {
		//return 0;
		
	}
	
	
	public void catchAnimal(IAnimal ia) {
		//return null;
		
	}*/
	@Test
	public void testgetSpecieLevel() {
	
		IGameState tester = getinstance();
		assertEquals(tester.getSpecieLevel(this.isp), SpecieLevel.NOVICE);
	}
	@Test
	public void testgetProgression() {
		IGameState tester = getinstance();
		assertEquals(tester.getProgression(), 24);
		
	}
	
}
