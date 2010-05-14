package org.fabric3.samples.bigbank.loan.store.memory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.fabric3.samples.bigbank.loan.domain.LoanRecord;
import org.fabric3.samples.bigbank.loan.store.StoreException;
import org.fabric3.samples.bigbank.loan.store.StoreService;

/**
 * @version $Rev$ $Date$
 */
public class TransientStoreService implements StoreService {
    private int counter = 1;
    private Map<Long, LoanRecord> cache = new ConcurrentHashMap<Long, LoanRecord>();

    public void save(LoanRecord record) throws StoreException {
        long id = record.getId();
        if (id == 0) {
            record.setId(counter++);
        }
        cache.put(id, record);
    }

    public LoanRecord update(LoanRecord record) throws StoreException {
        save(record);
        return record;
    }

    public void remove(long id) throws StoreException {
        cache.remove(id);
    }

    public LoanRecord find(long id) throws StoreException {
        return cache.get(id);
    }

    public LoanRecord findBySSN(String ssn) throws StoreException {
        // not efficient but this is a demo
        for (LoanRecord record : cache.values()) {
            if (record.getSsn().equals(ssn)) {
                return record;
            }
        }
        return null;
    }
}
