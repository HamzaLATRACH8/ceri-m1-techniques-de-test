package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory mockTrainerFactory;
    private PokemonTrainer mockTrainer;
    private IPokedexFactory mockPokedexFactory;
    private IPokedex mockPokedex;

    @Before
    public void setUp() {
        mockTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        mockPokedexFactory = Mockito.mock(IPokedexFactory.class);
        mockPokedex = Mockito.mock(IPokedex.class);

        mockTrainer = new PokemonTrainer("Ash", Team.MYSTIC, mockPokedex);
        Mockito.when(mockTrainerFactory.createTrainer("Ash", Team.MYSTIC, mockPokedexFactory))
                .thenReturn(mockTrainer);
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = mockTrainerFactory.createTrainer("Ash", Team.MYSTIC, mockPokedexFactory);

        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.MYSTIC, trainer.getTeam());
        assertEquals(mockPokedex, trainer.getPokedex());
    }


}
