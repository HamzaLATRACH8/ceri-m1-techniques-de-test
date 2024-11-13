package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * This class implements the IPokemonMetadataProvider interface.
 * It simulates retrieving Pokémon metadata.
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private final Map<Integer, PokemonMetadata> pokemonDatabase;

    public PokemonMetadataProvider() {
        pokemonDatabase = new HashMap<>();
        pokemonDatabase.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonDatabase.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    /**
     * Retrieves the metadata for the Pokémon with the given index.
     *
     * @param index The Pokémon index.
     * @return The metadata of the Pokémon.
     * @throws PokedexException If the index is invalid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata metadata = pokemonDatabase.get(index);

        if (metadata == null) {
            throw new PokedexException("Invalid Pokémon index: " + index);
        }

        return metadata;
    }
}
