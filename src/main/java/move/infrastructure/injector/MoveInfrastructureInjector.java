package move.infrastructure.injector;

import shared.infrastructure.CommonInfrastructureInjector;
import move.infrastructure.persistence.SQLite.MoveRepositoryImpl;
import move.infrastructure.transformer.Matrix.MoveTransformerImpl;

final public class MoveInfrastructureInjector {

    public static MoveRepositoryImpl injectMoveRepository() {
        return new MoveRepositoryImpl(
            CommonInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static MoveTransformerImpl injectMoveTransformer() {
        return new MoveTransformerImpl(
            CommonInfrastructureInjector.injectMatrixService()
        );
    }
}
