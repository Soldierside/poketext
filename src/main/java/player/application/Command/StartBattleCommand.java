package player.application.Command;

import shared.domain.Command.Command;
import shared.infrastructure.controller.AppController;

final public class StartBattleCommand implements Command {

    private final AppController receiver;

    private StartBattleCommand(AppController receiver) {
        this.receiver = receiver;
    }

    public static StartBattleCommand of(AppController receiver) {
        return new StartBattleCommand(receiver);
    }

    public void execute(String... args) {
        receiver.play();
    }
}
