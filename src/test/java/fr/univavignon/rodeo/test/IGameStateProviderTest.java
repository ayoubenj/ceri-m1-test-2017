package fr.univavignon.rodeo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.GameStateProvider;

public class IGameStateProviderTest {

	IGameState ig;
	public IGameStateProvider getinstance () {
		IGameStateProvider ia = Mockito.mock(IGameStateProvider.class);
		IGameStateTest igt = new IGameStateTest();
		 		
		ig = igt.getinstance();
		//Mockito.when(ia.save()).thenReturn(42);
		Mockito.when(ia.get("Cape Buffalo")).thenReturn(ig);
		
		
		return ia;
	}
	
	/*@Test
	public void save(IGameState igs) {
		
	}*/
	@Test
	public void testget() {
		IGameStateProvider tester = getinstance();
		System.out.println(this.ig);
		assertEquals(tester.get("Cape Buffalo"), this.ig);
		
	}

}
