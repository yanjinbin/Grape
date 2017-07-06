package com.yanjinbin.concurrent.chapter_5;

import lombok.Builder;

import java.util.concurrent.*;

/**
 * nextodo
 * CellularAutomata
 * <p>
 * Coordinating computation in a cellular automaton with CyclicBarrier
 *
 * @author Brian Goetz and Tim Peierls
 */
public class CellularAutomata {

    private final Board mainBoard;

    private final Worker[] workerQueue;

    private final CyclicBarrier cyclicBarrier;

    public CellularAutomata(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.cyclicBarrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                mainBoard.commitNewValues();
            }
        });
        this.workerQueue = new Worker[count];
        for (int i = 0; i < count; i++) {
            //workerQueue[i] = Worker.builder().board(mainBoard.getSubBoard(count, i)).build();
            workerQueue[i] = new Worker(mainBoard.getSubBoard(count,i));
        }
    }

    private class Worker implements Runnable {
        public Worker(Board board) {
            this.board = board;
        }

        private final Board board;

        @Override
        public void run() {
            while (!board.hasCoveraged()) {
                for (int i = 0; i < board.getMaxX(); i++) {
                    for (int j = 0; j < board.getMaxY(); j++) {
                        board.setNewValue(i, j, computerValue(i, j));
                    }
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }

        private int computerValue(int x, int y) {
            return 0;
        }
    }

    public void start(){
        for (int i = 0; i < workerQueue.length; i++) {
            new Thread(workerQueue[i]).start();

        }
        mainBoard.waitForCoveragence();
    }
    
    interface Board {
        int getMaxX();

        int getMaxY();

        int getValue(int x, int y);

        int setNewValue(int x, int y, int newValue);

        void commitNewValues();

        boolean hasCoveraged();

        void waitForCoveragence();

        Board getSubBoard(int numPartitions, int index);

    }
}