package com.sashank.waterpollutionsimulator.controller;
import com.sashank.waterpollutionsimulator.model.WaterGrid;
import com.sashank.waterpollutionsimulator.service.SimulationService;
import com.sashank.waterpollutionsimulator.dto.UserActionRequest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulation")
@CrossOrigin
public class SimulationController {

    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @PostMapping("/action")
    public WaterGrid applyUserAction(@RequestBody UserActionRequest request) {
        return simulationService.applyAction(
                request.getAction(),
                request.getRow(),
                request.getCol()
        );
    }

    @GetMapping("/state")
    public WaterGrid getState() {
        return simulationService.getCurrentState();
    }
}
