package fr.univavignon.rodeo.testimp;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.imp.GameState;
import fr.univavignon.rodeo.imp.GameStateProvider;
import fr.univavignon.rodeo.test.IGameStateProviderTest;
import fr.univavignon.rodeo.test.IGameStateTest;

public class GameStateProviderTest extends IGameStateProviderTest  {
	 IGameState ig ;
		public IGameStateProvider getinstance () {
			GameStateProvider gs = new GameStateProvider();
			//gs.rf.currentdistance = 0;
			
			ig = gs.get("Cape Buffalo");
			//gs.save(ig);
			//gs.getSpecieLevel(isp);

				
			return gs;
		}
	
}

