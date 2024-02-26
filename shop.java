import java.util.ArrayList;
import java.util.Random;

public class shop {

    ArrayList<String> shopList = new ArrayList<>();
    ArrayList<Integer> countsList;
    int totalCount = 0;

    public shop (ArrayList<Integer> countsList) {
        this.countsList = countsList;      
    }

    ArrayList<String> shopList (toysLists toysLists) {
        this.totalCount = toysLists.totalCount();
        while (totalCount > 0) {
            add(toysLists);
            totalCount = totalCount - 1;
        }
        return this.shopList;
    }

    public void add (toysLists toysLists) {
        Random random = new Random();
        int n = random.nextInt(toysLists.totalWeight()) + 1;
        for (int i = 0; i < toysLists.weightIntervals().size(); i++) {
            if (n < toysLists.weightIntervals().get(i))
            if (this.countsList.get(i)>0) {
                String prize = (toysLists.namesList().get(i) + 
                " id - " + toysLists.IDList().get(i));
                this.shopList.add(prize);
                int temp = this.countsList.get(i) - 1;
                this.countsList.set(i, temp);
            }
            else this.totalCount = totalCount-1;
        }
    }
}
