package fr.univavignon.rodeo.testimp;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.imp.GameState;
import fr.univavignon.rodeo.test.IGameStateTest;

public class GameStateTest extends IGameStateTest  {
	ISpecie isp;
		public IGameState getinstance () {
			GameState gs = new GameState(24, "Savannah");
			gs.getSpecieLevel(isp);
				
			return gs;
		}
	
}
