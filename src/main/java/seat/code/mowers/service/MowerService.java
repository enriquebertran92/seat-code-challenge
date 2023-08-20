package seat.code.mowers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seat.code.mowers.interfaces.IMower;
import seat.code.mowers.model.EMowerOption;
import seat.code.mowers.model.Mower;

@Service
public class MowerService implements IMower {
    CommnadService commandService;

    public MowerService(CommnadService commandService) {
        this.commandService = commandService;
    }

    public void move(Mower mower, String commands){
        if(commands != null || !commands.isEmpty()) {
            System.out.println(commands);
            String[] arrCommands = commands.split("");

            for (String command: arrCommands) {
                EMowerOption mowerOption = commandService.read(command);
                mower.setAction(mowerOption);
            }
            System.out.printf("%s %s %s \n", mower.getCoordinate().getX(), mower.getCoordinate().getY(), mower.getCardinale().toString());
        }
    }
}
