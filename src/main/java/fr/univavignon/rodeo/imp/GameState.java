package fr.univavignon.rodeo.imp;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class GameState implements IGameState {

	String Name;
	int Progression;
	readfile rf =new readfile();
	
	public GameState(int Progression) {
		//this.Name = Name;
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

		rf.load().put(animal.getName(), rf.informer(rf));
		System.out.println("liste "+rf.lanimalee);

	}

	@Override
	public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(getProgression()<25 && getProgression()>0)
			return SpecieLevel.NOVICE;
		if(getProgression()>=25 && getProgression()<150 )
			return SpecieLevel.WRANGLER;
		if(getProgression()>=150 && getProgression()<600 )
			return SpecieLevel.NOVICE;
		if(getProgression()>=600)
			return SpecieLevel.MASTER;
		return null;
		
		//return null;
	}

	@Override
	public int getProgression() {
		return this.Progression;
	}

}
