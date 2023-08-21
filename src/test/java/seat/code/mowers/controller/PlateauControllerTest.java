package seat.code.mowers.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlateauControllerTest {
    @Autowired
    PlateauController plateauController;

    @Test
    public void init() {
        String textInput = plateauController.init("5 5\r\n1 2 N\r\nLMLMLMLMM\r\n3 3 E\r\nMMRMMRMRRM");

        String[] lines = textInput.split("\\n");


        Assert.assertEquals(lines.length, 2);
        Assert.assertEquals(lines[0], "1 3 N");
        Assert.assertEquals(lines[1], "5 1 E");
    }
}
