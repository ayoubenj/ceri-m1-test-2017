package fr.univavignon.rodeo.imp;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class GameState implements IGameState {

	String Name;
	int Progression;
	
	public GameState(String Name, int Progression) {
		this.Name = Name;
		this.Progression = Progression;
		
	}
	
	@Override
	public String getName() {
		return this.Name;
	}

	@Override
	public void exploreArea() throws IllegalStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getProgression() {
		return this.Progression;
	}

}
