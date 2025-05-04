import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;




class Mine {
    private AtomicInteger resources;

    public Mine(int initialResources) {
        this.resources = new AtomicInteger(initialResources);
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
    private static final int MAX_ENTRIES_BEFORE_REST = 3;
    private static final int REST_TIME_MS = 2000;

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
                        System.out.println("Miner " + id + " mined a resource. Total mined: " + resourcesMined);
                    } else {
                        System.out.println("Miner " + id + " found no resources left.");
                        break;
                    }
                } finally {
                    semaphore.release();
                }

                if (entries >= MAX_ENTRIES_BEFORE_REST) {
                    System.out.println("Miner " + id + " is resting.");
                    Thread.sleep(REST_TIME_MS);
                    entries = 0;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Miner " + id + " was interrupted.");
        }
    }
}

public class testt {
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
                System.out.println("Main thread was interrupted.");
            }
        }

        System.out.println("Mining operation completed. Remaining resources: " + mine.getRemainingResources());
    }
}