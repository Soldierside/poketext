package indexer.nature.infrastructure.injector;

import shared.infrastructure.injector.SharedInfrastructureInjector;
import indexer.nature.infrastructure.persistence.SQLite.NatureRepositoryImpl;
import indexer.nature.infrastructure.transformer.Matrix.NatureTransformerImpl;

public class NatureInfrastructureInjector {

    public static NatureRepositoryImpl injectNatureRepository() {
        return new NatureRepositoryImpl(
            SharedInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static NatureTransformerImpl injectNatureTransformer() {
        return new NatureTransformerImpl(
            SharedInfrastructureInjector.injectMatrixService()
        );
    }
}
