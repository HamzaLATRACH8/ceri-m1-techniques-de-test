package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class PokemonTest {

    private IPokemonFactory mockPokemonFactory;

    @Before
    public void setUp() {
        mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Mockito.when(mockPokemonFactory.createPokemon(0, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
        Mockito.when(mockPokemonFactory.createPokemon(133, 2729, 202, 5000, 4))
                .thenReturn(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
    }

    @Test
    public void testGetIvForBulbizarre() {
        Pokemon bulbizarre = mockPokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertEquals(56, bulbizarre.getIv(), 0.0);
    }

    @Test
    public void testGetIvForAquali() {
        Pokemon aquali = mockPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        assertEquals(100, aquali.getIv(), 0.0);
    }
}
