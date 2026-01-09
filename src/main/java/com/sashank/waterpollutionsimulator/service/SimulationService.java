package com.sashank.waterpollutionsimulator.service;
import com.sashank.waterpollutionsimulator.model.ActionType;
import com.sashank.waterpollutionsimulator.model.WaterGrid;
import com.sashank.waterpollutionsimulator.model.Zone;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    private final WaterGrid waterGrid = new WaterGrid(10, 10);

    public WaterGrid applyAction(ActionType action, int row, int col) {

        Zone zone = waterGrid.getGrid()[row][col];

        switch (action) {
            case FACTORY -> zone.applyPollution(10);
            case AGRICULTURE -> zone.applyPollution(5);
            case WASTE_DUMPING -> zone.applyPollution(8);

            case FILTER -> zone.cleanup(4);
            case TREATMENT -> zone.cleanup(6);
            case REGULATION -> zone.cleanup(3);
        }

        spreadPollution();
        return waterGrid;
    }

    private void spreadPollution() {
        Zone[][] grid = waterGrid.getGrid();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int spread = grid[i][j].getPollution() / 10;

                if (spread > 0) {
                    if (i > 0) grid[i - 1][j].applyPollution(spread);
                    if (j > 0) grid[i][j - 1].applyPollution(spread);
                }
            }
        }
    }

    public WaterGrid getCurrentState() {
        return waterGrid;
    }
}