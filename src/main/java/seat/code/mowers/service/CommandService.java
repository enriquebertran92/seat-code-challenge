package seat.code.mowers.service;

import org.springframework.stereotype.Service;
import seat.code.mowers.interfaces.ICommandService;
import seat.code.mowers.model.EMowerOption;

@Service
public class CommandService implements ICommandService {
    @Override
    public EMowerOption read(String command) {
        switch(command) {
            case "L":
                return EMowerOption.ROTATE_LEFT;
            case "R":
                return EMowerOption.ROTATE_RIGHT;
            case "M":
                return EMowerOption.MOVE;
            default:
                return EMowerOption.NONE;
        }
    }
}
