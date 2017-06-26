package appwork.almayce.pencilpuzzle;

/**
 * Created by almayce on 13.06.17.
 */

public class AdManager {
    private static final AdManager instance = new AdManager();
    private long unblockAdMillis = 0;

    public static AdManager getInstance() {
        return instance;
    }

    private AdManager() {
        if (unblockAdMillis < System.currentTimeMillis())
            unblockAdMillis = System.currentTimeMillis();
    }

    public void hourIncrement() {
        unblockAdMillis += 3600000;
    }

    public void setOffAdMillis() {
        unblockAdMillis *= 10;
    }

    public boolean itIsTimeToShowAds(long currentMillis) {
        return currentMillis > unblockAdMillis;
    }

    public long getUnblockAdMillis() {
        return unblockAdMillis;
    }

    public void setUnblockAdMillis(long millis) {
        unblockAdMillis = millis;
    }
}
