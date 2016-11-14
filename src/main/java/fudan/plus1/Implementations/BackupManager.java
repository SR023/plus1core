package fudan.plus1.Implementations;
import java.util.List;

import fudan.plus1.Interfaces.AbstractBackupManager;
import fudan.plus1.Interfaces.Counter;

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
        List<Counter> counters = fudan.plus1.Implementations.Plus1System.getInstance().getCounters();
        // TODO
        return 0;
    }
}
