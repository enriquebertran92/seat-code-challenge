package seat.code.mowers.interfaces;

import seat.code.mowers.model.ELineType;
import seat.code.mowers.model.EMowerOption;

public interface ILine {
    ELineType read(String line);
}
