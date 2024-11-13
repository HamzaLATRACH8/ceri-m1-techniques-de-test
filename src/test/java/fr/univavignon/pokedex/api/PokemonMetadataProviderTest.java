package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class PokemonMetadataProviderTest {

    private IPokemonMetadataProvider mockProvider;

    @Before
    public void setUp() throws PokedexException {
        mockProvider = Mockito.mock(IPokemonMetadataProvider.class);

        Mockito.when(mockProvider.getPokemonMetadata(0))
                .thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        Mockito.when(mockProvider.getPokemonMetadata(133))
                .thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));
        Mockito.when(mockProvider.getPokemonMetadata(999))
                .thenThrow(new PokedexException("Invalid Pokémon index: 999"));
    }

    @Test
    public void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        PokemonMetadata metadata = mockProvider.getPokemonMetadata(0);

        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        mockProvider.getPokemonMetadata(999);
    }

    @Test
    public void testGetPokemonMetadata_Aquali() throws PokedexException {
        PokemonMetadata metadata = mockProvider.getPokemonMetadata(133);

        assertEquals(133, metadata.getIndex());
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());

    }
}
