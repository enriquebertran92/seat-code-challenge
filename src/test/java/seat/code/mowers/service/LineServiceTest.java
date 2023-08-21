package seat.code.mowers.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import seat.code.mowers.model.ECardinale;
import seat.code.mowers.model.EMowerOption;
import seat.code.mowers.model.Plateau;

@SpringBootTest
public class LineServiceTest {
    @Autowired
    LineService lineService;

    @Test
    public void read() {
        Plateau plateau = new Plateau();
        lineService.read(plateau,"5 5\r\n1 2 N\r\nLMLMLMLMM\r\n3 3 E\r\nMMRMMRMRRM");

        Assert.assertEquals(plateau.getGrid().getX(), 5);
        Assert.assertEquals(plateau.getGrid().getY(), 5);
        Assert.assertEquals(plateau.getMowers().size(), 2);
        Assert.assertEquals(plateau.getMowers().get(0).getCardinale(), ECardinale.NORTH);
        Assert.assertEquals(plateau.getMowers().get(0).getCoordinate().getX(), 1);
        Assert.assertEquals(plateau.getMowers().get(0).getCoordinate().getY(), 3);
        Assert.assertEquals(plateau.getMowers().get(1).getCardinale(), ECardinale.EAST);
        Assert.assertEquals(plateau.getMowers().get(1).getCoordinate().getX(), 3);
        Assert.assertEquals(plateau.getMowers().get(1).getCoordinate().getY(), 3);
    }
}
