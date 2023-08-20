package seat.code.mowers.interfaces;

import seat.code.mowers.model.ELineType;
import seat.code.mowers.model.EMowerOption;

public interface ILineService {
    ELineType read(String line);
}
