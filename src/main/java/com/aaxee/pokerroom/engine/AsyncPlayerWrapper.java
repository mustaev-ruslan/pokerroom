package com.aaxee.pokerroom.engine;

import java.util.List;
import java.util.concurrent.*;

public class AsyncPlayerWrapper implements Player {

    private Player realPlayer;
    private ExecutorService executorService = AsyncConfiguration.executorService;
    private int waitingTime = AsyncConfiguration.WAITING_TIME;

    public AsyncPlayerWrapper(Player realPlayer) {
        this.realPlayer = realPlayer;
    }

    @Override
    public String getName() {
        return realPlayer.getName();
    }

    @Override
    public Action chooseAction(List<Action> actions) throws ExecutionException, InterruptedException {
        if (actions.isEmpty()) {
            throw new IllegalArgumentException("Action list is empty");
        }
        // no choice
        if (actions.size() == 1) {
            return actions.get(0);
        }
        Future<Action> futureAction = executorService.submit(() ->
                realPlayer.chooseAction(actions)
        );
        Action action;
        try {
            action = futureAction.get(waitingTime, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            action = Action.FOLD;
        }
        return action;
    }

    @Override
    public void lookTable(Table table) {
        executorService.submit(() ->
                realPlayer.lookTable(table)
        );
    }

    @Override
    public void getHand(Hand hand) {
        executorService.submit(() ->
                realPlayer.getHand(hand)
        );
    }
}
