package shared.application.search.Command;

import shared.application.search.Searcher;
import shared.domain.Command.Command;

final public class RemoveFilterCommand implements Command {

    private final Searcher receiver;

    private RemoveFilterCommand(Searcher receiver) {
        this.receiver = receiver;
    }

    public static RemoveFilterCommand of(Searcher receiver) {
        return new RemoveFilterCommand(receiver);
    }

    public void execute(String... args) {
        switch (args[0]) {
            case "n":
                receiver.removeNameFilter();
                break;
            case "t":
                receiver.removeTypeFilter();
                break;
            default:
                System.out.print("Filter not found");
        }
    }
}
