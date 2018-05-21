package fr.univavignon.rodeo.testimp;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.imp.Environment;
import fr.univavignon.rodeo.imp.GameState;
import fr.univavignon.rodeo.test.IEnvironmentTest;
import fr.univavignon.rodeo.test.IGameStateTest;


public class EnvironmentTest extends IEnvironmentTest  {
	ISpecie isp;
		public IEnvironment getinstance () {
			Environment gs = new Environment("Savannah");
			gs.getAreas();
			gs.getSpecies();
			return gs;
		}
	
}

