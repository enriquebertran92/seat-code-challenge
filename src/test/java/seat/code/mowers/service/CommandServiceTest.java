package seat.code.mowers.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import seat.code.mowers.model.EMowerOption;
import seat.code.mowers.service.CommandService;

@SpringBootTest
public class CommandServiceTest {
    @Autowired
    CommandService commandService;

    @Test
    public void read() {
        Assert.assertEquals(commandService.read("L"), EMowerOption.ROTATE_LEFT);
        Assert.assertEquals(commandService.read("R"), EMowerOption.ROTATE_RIGHT);
        Assert.assertEquals(commandService.read("M"), EMowerOption.MOVE);
        Assert.assertEquals(commandService.read("S"), EMowerOption.NONE);
    }
}
