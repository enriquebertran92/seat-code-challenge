package seat.code.mowers.model;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    Grid grid;
    List<Mower> mowers;

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }

    public void addMower(Mower mower) {
        if(this.mowers == null) {
            this.mowers = new ArrayList<>();
        }

        deactivateAllMowers();

        this.mowers.add(mower);
    }

    private void deactivateAllMowers() {
        for(Mower mower : this.mowers) {
            mower.setActive(false);
        }
    }

    public String mowersOutputString() {
        String outputString = "";
        if(this.mowers != null) {
            for (Mower mower : this.mowers) {
                outputString += mower.toOutputString() + "\n";
            }
        }
        return outputString;
    }

    public void setActionMower(EMowerOption mowerOption) {
        if(this.mowers != null) {
            for(Mower mower : this.mowers) {
                if(mower.isActive()) {
                    mower.setAction(mowerOption);
                }
            }
        }
    }
}
