package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

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
    public void testCreatePokemon_Bulbizarre() {
        Pokemon bulbizarre = mockPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, bulbizarre.getIndex());
        assertEquals("Bulbizarre", bulbizarre.getName());
        assertEquals(613, bulbizarre.getCp());
        assertEquals(64, bulbizarre.getHp());
        assertEquals(4000, bulbizarre.getDust());
        assertEquals(4, bulbizarre.getCandy());
    }

    @Test
    public void testCreatePokemon_Aquali() {
        Pokemon aquali = mockPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(133, aquali.getIndex());
        assertEquals("Aquali", aquali.getName());
        assertEquals(2729, aquali.getCp());
        assertEquals(202, aquali.getHp());
        assertEquals(5000, aquali.getDust());
        assertEquals(4, aquali.getCandy());
    }
}
