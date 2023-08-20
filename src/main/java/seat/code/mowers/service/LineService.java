package seat.code.mowers.service;

import org.springframework.stereotype.Service;
import seat.code.mowers.interfaces.ILineService;
import seat.code.mowers.model.ELineType;

@Service
public class LineService implements ILineService {
    @Override
    public ELineType read(String line) {
        switch(line.trim().length()) {
            case 3:
                return ELineType.INIT_GRID;
            case 5:
                return ELineType.INIT_MOWER;
            default:
                return ELineType.ACTIONS_MOWER;
        }
    }
}
