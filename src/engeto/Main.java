package engeto;

public class Main {

    public static final Integer INCREMENT_TARGET = 10;

    public static void main(String[] args) {
        Philosopher[]philosophers = new Philosopher[5];
        Fork[] forks = new Fork[philosophers.length];

        for(int i=0; i< forks.length; i++){
            forks[i] = new Fork(i+1);
        }

        for(int i=0; i<philosophers.length; i++){
            //Fork forkLeft = forks[i];
            //Fork forkRight = forks[(i+1)%forks.length];

            if (i == philosophers.length - 1)
               philosophers[i] = new Philosopher(i+1,forks[(i+1)%forks.length], forks[i]);
            else
                philosophers[i] = new Philosopher(i+1,forks[i],forks[(i+1)%forks.length]);



                Thread thread = new Thread(philosophers[i], "Philosopher" + (i + 1));
                thread.start();
            }







//        Fork fork0 = new Fork(0);
//        Fork fork1 = new Fork(1);
//        Fork fork2 = new Fork(2);
//        Fork fork3 = new Fork(3);
//        Fork fork4 = new Fork(4);
//
//        Philosopher philosopher1 = new Philosopher(0, fork0, fork1);
//        Philosopher philosopher2 = new Philosopher(1, fork1, fork2);
//        Philosopher philosopher3 = new Philosopher(2, fork2, fork3);
//        Philosopher philosopher4 = new Philosopher(3, fork3, fork4);
//        Philosopher philosopher5 = new Philosopher(4, fork4, fork0);

    }
}
