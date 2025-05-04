import java.util.concurrent.Semaphore;

class Mine {
    private Minee resources;
    public Mine(int initialResources) {
        this.resources = new Minee (initialResources);
    }

    public boolean mineResource() {
        if (resources.get() > 0) {
            resources.decrementAndGet();
            return true;
        }
        return false;
    }

    public int getRemainingResources() {
        return resources.get();
    }
}

class Miner implements Runnable {
    private static final int MAX_ENTRIES = 3;
    private static final int REST = 2000;

    private final int id;
     private final Mine mine;
    private final Semaphore semaphore;
    private int resourcesMined = 0;
    private int entries = 0;

    public Miner(int id, Mine mine, Semaphore semaphore) {
        this.id = id;
        this.mine = mine;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            while (mine.getRemainingResources() > 0) {
                semaphore.acquire();
                try {
                    if (mine.mineResource()) {
                        resourcesMined++;
                        entries++;
                        System.out.println(id + " Total mined: " + resourcesMined);
                    } else {
                        System.out.println( id + "o resources left.");
                        break;
                    }
                } finally {
                    semaphore.release();
                }

                if (entries >= MAX_ENTRIES) {
                    System.out.println("Miner " + id + " is resting.");
                    Thread.sleep(REST);
                    entries = 0;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Miner " + id + " was interrupted.");
        }
    }
}

public class main2 {
    public static void main(String[] args) {
        final int TOTAL_RESOURCES = 20;
        final int NUM_MINERS = 5;
        final int MAX_CONCURRENT_MINERS = 3;

        Mine mine = new Mine(TOTAL_RESOURCES);
        Semaphore semaphore = new Semaphore(MAX_CONCURRENT_MINERS);

        Thread[] miners = new Thread[NUM_MINERS];
        for (int i = 0; i < NUM_MINERS; i++) {
            miners[i] = new Thread(new Miner(i + 1, mine, semaphore));
            miners[i].start();
        }

        for (Thread miner : miners) {
            try {
                miner.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("error.");
            }
        }

        System.out.println("Remaining resources: " + mine.getRemainingResources());
    }
}