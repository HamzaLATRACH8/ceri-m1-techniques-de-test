package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


import static org.junit.Assert.*;

public class IPokedexTest {

    private IPokedex mockPokedex;

    @Before
    public void setUp() throws PokedexException {
        mockPokedex = Mockito.mock(IPokedex.class);

        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56); // Bulbizarre
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100); // Aquali


        pokemons.add(bulbizarre);
        pokemons.add(aquali);

        Mockito.when(mockPokedex.size()).thenReturn(pokemons.size());
        Mockito.when(mockPokedex.addPokemon(Mockito.any(Pokemon.class)))
                .thenAnswer(invocation -> {
                    Pokemon newPokemon = invocation.getArgument(0);
                    pokemons.add(newPokemon);
                    return pokemons.size() ;
                });
        Mockito.when(mockPokedex.getPokemon(0)).thenReturn(bulbizarre);
        Mockito.when(mockPokedex.getPokemon(133)).thenReturn(aquali);
        Mockito.when(mockPokedex.getPokemons()).thenReturn(new ArrayList<>(pokemons));
        Mockito.when(mockPokedex.getPokemons(Mockito.any(Comparator.class))).thenAnswer(invocation -> {
            Comparator<Pokemon> comparator = invocation.getArgument(0);
            List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
            sortedPokemons.sort(comparator);
            return sortedPokemons;
        });
    }

    @Test
    public void testSize() {
        assertEquals(2, mockPokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon newPokemon = new Pokemon(999, "Pikachu", 500, 50, 3000, 3, 100, 100, 80, 50);
        int index = mockPokedex.addPokemon(newPokemon);
        assertEquals(3, index);
    }

    @Test
    public void testGetPokemon_Bulbizarre() throws PokedexException {
        Pokemon bulbizarre = mockPokedex.getPokemon(0);
        assertEquals(0, bulbizarre.getIndex());
        assertEquals("Bulbizarre", bulbizarre.getName());
    }

    @Test
    public void testGetPokemon_Aquali() throws PokedexException {
        Pokemon aquali = mockPokedex.getPokemon(133);
        assertEquals(133, aquali.getIndex());
        assertEquals("Aquali", aquali.getName());
    }


    @Test
    public void testGetPokemons() {
        List<Pokemon> allPokemons = mockPokedex.getPokemons();
        assertEquals(2, allPokemons.size());
        assertEquals("Bulbizarre", allPokemons.get(0).getName());
        assertEquals("Aquali", allPokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> sortedPokemons = mockPokedex.getPokemons(Comparator.comparingInt(Pokemon::getAttack));
        assertEquals("Bulbizarre", sortedPokemons.get(0).getName());
        assertEquals("Aquali", sortedPokemons.get(1).getName());
    }
    //////////////////////////////////
}