package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PokedexTest {

    private IPokemonMetadataProvider mockMetadataProvider;
    private IPokemonFactory mockPokemonFactory;
    private Pokedex pokedex;

    @Before
    public void setUp() {
        mockMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        pokedex = new Pokedex(mockMetadataProvider, mockPokemonFactory);
    }

    @Test
    public void testSize() {
        pokedex.addPokemon(new Pokemon(1, "Pikachu", 55, 40, 35, 500, 200, 100, 200, 0.85));
        assertEquals(1, pokedex.size());

        pokedex.addPokemon(new Pokemon(2, "Bulbizarre", 80, 60, 45, 600, 300, 150, 250, 0.90));
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 200, 100, 200, 0.85);
        int index = pokedex.addPokemon(pokemon);

        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon_ValidIndex() throws PokedexException {
        Pokemon pokemon = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 200, 100, 200, 0.85);
        pokedex.addPokemon(pokemon);

        Pokemon result = pokedex.getPokemon(0);
        assertEquals(pokemon, result);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemon_InvalidIndex() throws PokedexException {
        pokedex.getPokemon(999);
    }

    @Test
    public void testGetPokemons() {
        Pokemon pokemon1 = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 200, 100, 200, 0.85);
        Pokemon pokemon2 = new Pokemon(2, "Bulbizarre", 80, 60, 45, 600, 300, 150, 250, 0.90);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(pokemons.contains(pokemon1));
        assertTrue(pokemons.contains(pokemon2));
    }

    @Test
    public void testGetPokemons_WithComparator() {
        Pokemon pokemon1 = new Pokemon(1, "Pikachu", 55, 40, 35, 500, 200, 100, 200, 0.85);
        Pokemon pokemon2 = new Pokemon(2, "Bulbizarre", 80, 60, 45, 600, 300, 150, 250, 0.90);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        // Comparator basé sur le CP (combat points)
        Comparator<Pokemon> comparator = Comparator.comparingInt(Pokemon::getCp);
        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparator);

        assertEquals(2, sortedPokemons.size());
        assertEquals(pokemon1, sortedPokemons.get(0));
        assertEquals(pokemon2, sortedPokemons.get(1));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        int index = 1;
        PokemonMetadata metadata = new PokemonMetadata(1, "Pikachu", 55, 40, 35);
        when(mockMetadataProvider.getPokemonMetadata(index)).thenReturn(metadata);

        PokemonMetadata result = pokedex.getPokemonMetadata(index);
        assertEquals(metadata, result);
        verify(mockMetadataProvider).getPokemonMetadata(index);
    }

    @Test
    public void testCreatePokemon() {
        int index = 1;
        int cp = 500;
        int hp = 200;
        int dust = 100;
        int candy = 200;
        Pokemon mockPokemon = new Pokemon(index, "Pikachu", 55, 40, 35, cp, hp, dust, candy, 0.85);

        when(mockPokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(mockPokemon);

        Pokemon result = pokedex.createPokemon(index, cp, hp, dust, candy);
        assertEquals(mockPokemon, result);
        verify(mockPokemonFactory).createPokemon(index, cp, hp, dust, candy);
    }
}
