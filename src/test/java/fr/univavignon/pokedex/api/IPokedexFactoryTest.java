package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokedexFactoryTest {

    private IPokedexFactory mockPokedexFactory;
    private IPokedex mockPokedex;

    @Before
    public void setUp() {
        mockPokedexFactory = Mockito.mock(IPokedexFactory.class);
        mockPokedex = Mockito.mock(IPokedex.class);

        Mockito.when(mockPokedexFactory.createPokedex(Mockito.any(IPokemonMetadataProvider.class), Mockito.any(IPokemonFactory.class)))
                .thenReturn(mockPokedex);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = mockPokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class));
        assertNotNull(pokedex);
    }
}
