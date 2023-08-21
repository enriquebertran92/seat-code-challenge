package seat.code.mowers.interfaces;

import seat.code.mowers.model.ELineType;
import seat.code.mowers.model.EMowerOption;
import seat.code.mowers.model.Plateau;

public interface ILineService {
    void read(Plateau plateau, String inputMessage);
}
