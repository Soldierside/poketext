package pokedex.infrastructure.injector;

import shared.infrastructure.injector.SharedInfrastructureInjector;
import pokedex.infrastructure.persistence.SQLite.PokedexRepositoryImpl;
import pokedex.infrastructure.transformer.Matrix.PokedexTransformerImpl;

public class PokedexInfrastructureInjector {

    public static PokedexRepositoryImpl injectPokedexRepository() {
        return new PokedexRepositoryImpl(
            SharedInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static PokedexTransformerImpl injectPokedexTransformer() {
        return new PokedexTransformerImpl(
            SharedInfrastructureInjector.injectMatrixService()
        );
    }
}
