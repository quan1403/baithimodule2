package Models;

import java.util.Comparator;

public class SortGiamDan implements Comparator<Models.Product> {
    @Override
    public int compare(Models.Product o1, Models.Product o2) {
        if (o1.getPrice()<o2.getPrice()){
            return 1;
        }
        return -1;
    }
}
