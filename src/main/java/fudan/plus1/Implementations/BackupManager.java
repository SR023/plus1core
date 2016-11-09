package Implementations;
import java.util.List;

import Interfaces.AbstractBackupManager;
import Interfaces.Counter;

/**
 * Created by billlai on 08/Oct/2016.
 */
class BackupManager implements AbstractBackupManager {
    private static BackupManager ourInstance = new BackupManager();

    static BackupManager getInstance() {
        return ourInstance;
    }

    private BackupManager() {
    }
    public int backup() {
        List<Counter> counters = Implementations.Plus1System.getInstance().getCounters();
        // TODO
        return 0;
    }
}
