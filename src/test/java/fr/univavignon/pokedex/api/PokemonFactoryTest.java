package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PokemonFactoryTest {

    private RocketPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
    }


    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 500, 60, 3000, 3);

        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(500, pokemon.getCp());
        assertEquals(60, pokemon.getHp());
        assertEquals(3000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        int index = -1;
        int cp = 300;
        int hp = 100;
        int dust = 500;
        int candy = 50;

        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertEquals(index, pokemon.getIndex());
        assertEquals("Ash's Pikachu", pokemon.getName()); // Correspond au mapping pour l'index -1
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());

        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0.0, pokemon.getIv(), 0.01);
    }
}
