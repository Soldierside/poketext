package indexer.pokemon.domain;

import java.util.ArrayList;

public class PokemonsCollection {

    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public void add(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }
}
