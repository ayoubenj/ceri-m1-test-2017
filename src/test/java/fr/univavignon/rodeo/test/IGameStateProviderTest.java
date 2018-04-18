package fr.univavignon.rodeo.test;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;
import junit.framework.TestCase;

public class IGameStateProviderTest extends TestCase {

	IGameState ig;
	public IGameStateProvider getinstance () {
		IGameStateProvider ia = Mockito.mock(IGameStateProvider.class);
		IGameStateTest igt = new IGameStateTest();
		ig = igt.getinstance();
		//Mockito.when(ia.save()).thenReturn(42);
		Mockito.when(ia.get("salut")).thenReturn(ig);
		
		
		return ia;
	}
	
	/*@Test
	public void save(IGameState igs) {
		
	}*/
	@Test
	public void testget(String s) {
		IGameStateProvider tester = getinstance();
		assertEquals(tester.get("salut"), this.ig);
		
	}

}
