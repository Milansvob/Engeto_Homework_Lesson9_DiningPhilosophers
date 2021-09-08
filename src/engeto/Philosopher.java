package engeto;

public class Philosopher implements Runnable {
    private int i;
    private Fork forkLeft;
    private Fork forkRight;

    public Philosopher(int i, Fork forkLeft, Fork forkRight){
        this.i = i;
        this.forkLeft = forkLeft;
        this.forkRight= forkRight;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);

    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(System.nanoTime() + ": Thinking"); // thinking
                synchronized (forkLeft) {
                    doAction(System.nanoTime() + ": Picked up left fork");
                    synchronized (forkRight) {
                        doAction(System.nanoTime() + ": Picked up right fork - eating"); // eating
                        doAction(System.nanoTime() + ": Put down right fork");
                    }
                    doAction(System.nanoTime() + ": Put down left fork. Returning to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
