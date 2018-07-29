package com.aaxee.pokerroom.engine;

public class Action {

    private ActionType actionType;
    private int betSize;

    public static Action FOLD = new Action(ActionType.FOLD);
    public static Action BET(int betSize) {
        return new Action(ActionType.BET, betSize);
    }

    private Action(ActionType actionType) {
        if (actionType == ActionType.BET) {
            throw new IllegalArgumentException("Need bet size");
        }
        this.actionType = actionType;
    }

    private Action(ActionType actionType, int betSize) {
        if (actionType != ActionType.BET) {
            throw new IllegalArgumentException("Bet size must be only of action type bet");
        }
        this.actionType = actionType;
        this.betSize = betSize;
    }
}
