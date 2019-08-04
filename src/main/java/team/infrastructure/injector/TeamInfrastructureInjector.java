package team.infrastructure.injector;

import shared.infrastructure.injector.SharedInfrastructureInjector;
import team.infrastructure.persistence.FileSystem.TeamRepositoryImpl;

public class TeamInfrastructureInjector {

    public static TeamRepositoryImpl injectFileSystemTeamRepository() {
        return new TeamRepositoryImpl(
            SharedInfrastructureInjector.injectCSVService()
        );
    }
}
