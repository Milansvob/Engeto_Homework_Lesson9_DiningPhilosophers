package engeto;

public class Philosopher implements Runnable {
    private int i;
    private Fork forkLeft;
    private Fork forkRight;
    private int portionNumber;

    public Philosopher(int i, Fork forkLeft, Fork forkRight, int steps){
        this.i = i;
        this.forkLeft = forkLeft;
        this.forkRight= forkRight;
        this.portionNumber = steps;
    }

    //Method which print curent thread and his action into console
    private void doAction(String action) {
        System.out.println(Thread.currentThread().getName() + " " + action);
    }

    @Override
    public void run() {
        //Cycle for eating demanded portions
            for (int i = 0; i < portionNumber; i++) {
                doAction(": Thinking");
                //It ensure that only one thread will be used during left fork acquiring
                synchronized (forkLeft) {
                    doAction(": Picked up left fork");
                    //It ensure that only one thread will be used during right fork acquiring
                    synchronized (forkRight) {
                        doAction(": Picked up right fork - eating");
                        doAction(": Put down right fork");
                    }
                    doAction(": Put down left fork. Returning to thinking");
                }
            }
    }
}
