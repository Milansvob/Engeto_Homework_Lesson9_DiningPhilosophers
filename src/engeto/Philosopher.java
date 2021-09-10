package engeto;

public class Philosopher implements Runnable {
    private int i;
    private Fork forkLeft;
    private Fork forkRight;
    private int portiosnNumber;

    public Philosopher(int i, Fork forkLeft, Fork forkRight, int portionsnumber){
        this.i = i;
        this.forkLeft = forkLeft;
        this.forkRight= forkRight;
        this.portiosnNumber = portionsnumber;
    }

    //Method which print current thread and his action into console
    //Furthermore sleep thread for 0,001s (each calling method doAction sleep thread for 0,001s)
    //method "sleep" request exception treatment
    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(1);
    }

    @Override
    public void run() {

        try {
            //Cycle for eating demanded portions
            for (int i = 0; i < portiosnNumber; i++) {
                doAction(": Thinking");
//It ensure that certain fork is picked by philosopher and no-one else can pick up the same for until to be put down
                synchronized (forkLeft) {
                    doAction(": Picked up left fork");
//It ensure that certain fork is picked by philosopher and no-one else can pick up the same for until to be put  down
                    synchronized (forkRight) {
                        doAction(": Picked up right fork - eating dinner number " + (i + 1));
                        doAction(": Put down right fork");
                    }
                    doAction(": Put down left fork. Returning to thinking");
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
