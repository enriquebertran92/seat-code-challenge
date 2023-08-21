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
        if(line != null && !line.isEmpty()) {
            switch (line.trim().length()) {
                case 3:
                    return ELineType.INIT_GRID;
                case 5:
                    return ELineType.INIT_MOWER;
                default:
                    return ELineType.ACTIONS_MOWER;
            }
        }

        return ELineType.NONE;
    }

    private String[] getLines(String inputMessage) {
        return inputMessage.split("[\\r\\n]");
    }

    private void readLines(Plateau plateau, String[] lines) {
        for(String line : lines) {
            if (line != null || !line.isEmpty()) {
                chooseAction(plateau, line);
            }
        }
    }

    private void chooseAction(Plateau plateau, String line) {
        switch(readLine(line)) {
            case INIT_GRID:
                plateau.setGrid(new Grid(line));
                break;
            case INIT_MOWER:
                plateau.addMower(new Mower(line));
                break;
            case ACTIONS_MOWER:
                String[] arrCommands = line.split("");
                readCommands(plateau, arrCommands);
                break;
        }
    }

    private void readCommands(Plateau plateau, String[] arrCommands) {
        for (String command : arrCommands) {
            EMowerOption mowerOption = commandService.read(command);
            plateau.setActionMower(mowerOption);
        }
    }

    public void read(Plateau plateau, String inputMessage) {
        String[] lines = getLines(inputMessage);
        readLines(plateau,  lines);
    }
}
