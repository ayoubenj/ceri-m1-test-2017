package fr.univavignon.rodeo.imp;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;

public class GameStateProvider implements IGameStateProvider {

	//dossier pour sauvegarde;
	
	@Override
	public void save(IGameState gameState) {
		// TODO Auto-generated method stub serizliser save

	}

	@Override
	public IGameState get(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub desarialise le nom
		return null;
	}

}
