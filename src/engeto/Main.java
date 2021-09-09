package engeto;

public class Main {

    public static final int PHILOSOPHERS_NUMBER = 10;
    public static final int PORTIONS_NUMBER = 10000;

    public static void main(String[] args) {
        // Creation of space in memory for array of 10 philosophers
        Philosopher[]philosophers = new Philosopher[PHILOSOPHERS_NUMBER];
        // Creation of space in memory for array of 10 forks
        Fork[] forks = new Fork[philosophers.length];

        // filling arrays by fork objects
        for(int i=0; i< forks.length; i++){
            forks[i] = new Fork(i+1);
        }
        // filling arrays by philosopher objects
        for(int i=0; i<philosophers.length; i++){
            //Fork forkLeft = forks[i];
            //Fork forkRight = forks[(i+1)%forks.length];

            // Deadlock treatment: last philosopher ask for right fork first (the others for left fork first)
            if (i == philosophers.length - 1)
               philosophers[i] = new Philosopher(i+1,forks[(i+1)%forks.length], forks[i], PORTIONS_NUMBER);
            else
                philosophers[i] = new Philosopher(i+1,forks[i],forks[(i+1)%forks.length], PORTIONS_NUMBER);

            // Thread creation
                Thread thread = new Thread(philosophers[i], "Philosopher" + (i + 1));
                thread.start();
            }

    }
}
