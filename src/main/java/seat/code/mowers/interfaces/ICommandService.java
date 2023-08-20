package seat.code.mowers.interfaces;

import seat.code.mowers.model.EMowerOption;

public interface ICommandService {
    EMowerOption read(String command);
}
