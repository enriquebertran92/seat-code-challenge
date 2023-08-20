package seat.code.mowers.model;

import java.util.List;

public class Grid {
    int y;
    int x;

    public Grid(String gridOptions) {
        String[] gridOption = gridOptions.split(" ");
        String x = gridOption[0];
        String y = gridOption[1];

        this.y = Integer.parseInt(y);
        this.x = Integer.parseInt(x);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
