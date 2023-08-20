package seat.code.mowers.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import seat.code.mowers.model.ECardinale;
import seat.code.mowers.model.Mower;

@SpringBootTest
public class MowerControllerTest {
    @Autowired
    MowerController mowerController;

    @Test
    public void move() {
        Mower mower1 = new Mower("1 2 N");
        mowerController.move(mower1, "LMLMLMLMM");
        Assert.assertEquals(mower1.getCoordinate().getX(), 1);
        Assert.assertEquals(mower1.getCoordinate().getY(), 3);
        Assert.assertEquals(mower1.getCardinale(), ECardinale.NORTH);

        Mower mower2 = new Mower("3 3 E");
        mowerController.move(mower2, "MMRMMRMRRM");
        Assert.assertEquals(mower2.getCoordinate().getX(), 5);
        Assert.assertEquals(mower2.getCoordinate().getY(), 1);
        Assert.assertEquals(mower2.getCardinale(), ECardinale.EAST);
    }
}
