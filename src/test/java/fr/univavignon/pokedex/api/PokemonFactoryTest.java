package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        int index = 1;
        int cp = 500;
        int hp = 150;
        int dust = 1000;
        int candy = 100;

        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertEquals(index, pokemon.getIndex());
        assertEquals("PokemonName", pokemon.getName());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());

        double iv = pokemon.getIv();
        assertTrue(iv >= 0.0 && iv <= 1.0);

        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 15);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 15);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 15);
    }
}
