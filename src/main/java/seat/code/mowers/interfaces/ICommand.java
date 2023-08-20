package seat.code.mowers.interfaces;

import seat.code.mowers.model.EMowerOption;

public interface ICommand {
    EMowerOption read(String command);
}
