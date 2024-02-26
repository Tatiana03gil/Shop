import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class toysLists {

    HashMap<Integer, toy> toyList = new HashMap<>();

    public void addToy(toy toy) {
        if ((!toyList.containsKey(toy.getId()) | toyList.isEmpty()))
            toyList.put(toy.getId(), toy);
        else
            System.out.println("Игрушка с таким ID уже существует!");
    }

    public List<toy> toys () {
        List<toy> toys = new ArrayList<toy> (toyList.values());
        return toys;
    }

    public List<Integer> IDList () {
        List<Integer> IDList = new ArrayList<Integer>(toyList.keySet());
        return IDList;
    }

    public ArrayList<String> namesList () {
        ArrayList<String> namesList = new ArrayList<>();
        for (int i = 0; i < toys().size(); i++) 
        namesList.add(toys().get(i).getName());
        return namesList;
    }

    public ArrayList<Integer> weightList () {
        ArrayList<Integer> weightList = new ArrayList<>();
        for (int i = 0; i < toys().size(); i++) 
        weightList.add(toys().get(i).getFrequency());
        return weightList;
    }

    public ArrayList<Integer> countsList () {
        ArrayList<Integer> counts = new ArrayList<>();
        for (int i = 0; i < toys().size(); i++) 
        counts.add(toys().get(i).getCount());
        return counts;
    }

    public int totalCount () {
        int tc = 0;
        for (int i = 0; i < countsList().size(); i++)
            tc = tc + weightList().get(i);
        return tc;
    }

    public int totalWeight () {
        int tw = 0;
        for (int i = 0; i < weightList().size(); i++)
            tw = tw + weightList().get(i);
        return tw;
    }

    public ArrayList<Integer> weightIntervals () {
        ArrayList<Integer> wi = new ArrayList<>();
        wi.add(weightList().get(0)+1);
        for (int i = 1; i < weightList().size(); i++)
            wi.add(wi.get(i-1)+weightList().get(i));
        return wi;
    }

}

