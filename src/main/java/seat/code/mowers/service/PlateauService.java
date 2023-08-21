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
    ILineService lineService;

    public String init(String inputMessage) {
        Plateau plateau = new Plateau();

        if(inputMessage != null && !inputMessage.isEmpty()) {
            lineService.read(plateau, inputMessage);
        }

        return plateau.mowersOutputString();
    }
}
