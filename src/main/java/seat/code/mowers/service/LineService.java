package seat.code.mowers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seat.code.mowers.interfaces.ICommandService;
import seat.code.mowers.interfaces.ILineService;
import seat.code.mowers.model.*;

@Service
public class LineService implements ILineService {
    @Autowired
    ICommandService commandService;

    private ELineType readLine(String line) {
        switch(line.trim().length()) {
            case 3:
                return ELineType.INIT_GRID;
            case 5:
                return ELineType.INIT_MOWER;
            default:
                return ELineType.ACTIONS_MOWER;
        }
    }

    private String[] getLines(String inputMessage) {
        return inputMessage.split("[\\r\\n]");
    }

    private void readLines(Plateau plateau, Mower currentMower, String[] lines) {
        for(String line : lines) {
            if (line != null || !line.isEmpty()) {
                chooseAction(plateau, currentMower, line);
            }
        }
    }

    private void chooseAction(Plateau plateau, Mower currentMower, String line) {
        switch(readLine(line)) {
            case INIT_GRID:
                plateau.setGrid(new Grid(line));
                break;
            case INIT_MOWER:
                currentMower = new Mower(line);
                plateau.addMower(currentMower);
                break;
            case ACTIONS_MOWER:
                String[] arrCommands = line.split("");
                readCommands(currentMower, arrCommands);
                break;
        }
    }

    private void readCommands(Mower currentMower, String[] arrCommands) {
        for (String command : arrCommands) {
            EMowerOption mowerOption = commandService.read(command);
            if (currentMower != null) {
                currentMower.setAction(mowerOption);
            }
        }
    }

    public void read(Plateau plateau, String inputMessage) {
        String[] lines = getLines(inputMessage);
        readLines(plateau, null, lines);
    }
}
