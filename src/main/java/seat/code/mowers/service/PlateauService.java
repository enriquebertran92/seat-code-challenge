package seat.code.mowers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seat.code.mowers.interfaces.ICommandService;
import seat.code.mowers.interfaces.ILineService;
import seat.code.mowers.model.EMowerOption;
import seat.code.mowers.model.Grid;
import seat.code.mowers.model.Mower;
import seat.code.mowers.model.Plateau;

@Service
public class PlateauService {
    @Autowired
    ICommandService commandService;

    @Autowired
    ILineService lineService;

    public String init(String inputMessage) {
        Plateau plateau = new Plateau();

        if(inputMessage != null && !inputMessage.isEmpty()) {
            String[] lines = inputMessage.split("[\\r\\n]");
            Mower currentMower = null;
            for(String line : lines) {
                if (line != null || !line.isEmpty()) {
                    switch(lineService.read(line)) {
                        case INIT_GRID:
                            plateau.setGrid(new Grid(line));
                            break;
                        case INIT_MOWER:
                            currentMower = new Mower(line);
                            plateau.addMower(currentMower);
                            break;
                        case ACTIONS_MOWER:
                            String[] arrCommands = line.split("");

                            for (String command : arrCommands) {
                                EMowerOption mowerOption = commandService.read(command);
                                if (currentMower != null) {
                                    currentMower.setAction(mowerOption);
                                }
                            }
                            break;
                    }
                }
            }
        }

        return plateau.mowersOutputString();
    }
}
