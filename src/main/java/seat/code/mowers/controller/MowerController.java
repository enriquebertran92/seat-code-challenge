package seat.code.mowers.controller;

import org.springframework.stereotype.Controller;
import seat.code.mowers.model.Mower;
import seat.code.mowers.service.MowerService;

@Controller
public class MowerController {
    MowerService mowerService;

    public MowerController(MowerService mowerService) {
        this.mowerService = mowerService;
    }

    public void move(Mower mower, String commands) {
        mowerService.move(mower, commands);
    }
}
