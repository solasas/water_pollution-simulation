package com.sashank.waterpollutionsimulator.dto;

import com.sashank.waterpollutionsimulator.model.ActionType;

public class UserActionRequest {

    private ActionType action;
    private int row;
    private int col;

    // REQUIRED: setters for Jackson
    public void setAction(ActionType action) {
        this.action = action;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    // getters
    public ActionType getAction() {
        return action;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
