package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;

public class PokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);

        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        ArgumentCaptor<IPokedex> captor = ArgumentCaptor.forClass(IPokedex.class);

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);


        assertNotNull(pokedex);
    }
}
