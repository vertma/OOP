package L6.model.comparator;

import L6.model.RepairRequest;

import java.util.Comparator;

public class RepairRequestTitleComparator implements Comparator<RepairRequest> {
    @Override
    public int compare(RepairRequest r1, RepairRequest r2) {
        return r1.getTitle().compareTo(r2.getTitle());
    }
}
