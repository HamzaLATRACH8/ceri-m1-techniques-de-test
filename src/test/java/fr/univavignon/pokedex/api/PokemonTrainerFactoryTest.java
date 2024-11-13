package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PokemonTrainerFactoryTest {

    private IPokemonMetadataProvider mockMetadataProvider;
    private IPokemonFactory mockPokemonFactory;
    private IPokedexFactory mockPokedexFactory;
    private Team mockTeam;
    private PokemonTrainerFactory pokemonTrainerFactory;



    @Before
    public void setUp() {
        // Initialisation des mocks
        mockMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        mockPokemonFactory = Mockito.mock(IPokemonFactory.class);
        mockPokedexFactory = Mockito.mock(IPokedexFactory.class);
        mockTeam = Team.MYSTIC;

        pokemonTrainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        IPokedex mockPokedex = Mockito.mock(IPokedex.class);

        when(mockPokedexFactory.createPokedex(mockMetadataProvider, mockPokemonFactory)).thenReturn(mockPokedex);

        String trainerName = "Ketchum";
        Team trainerTeam = Team.MYSTIC;

        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer(trainerName, trainerTeam, mockPokedexFactory);

        assertNotNull(trainer);
        assertEquals(trainerName, trainer.getName());
        assertEquals(trainerTeam, trainer.getTeam());

    }

}
