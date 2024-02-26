public class toy {

    private int id;
    private int count;
    private int frequency;
    private String name;

    toy () {
        this.id = 0;
        this.frequency = 0;
        this.name = "";
        this.count = 0;
    }

    public void setID (int id) {
        this.id = id;
    }   

    public void setName (String name) {
        this.name = name;
    }   

    public void setFrequency (int frequency) {
        this.frequency = frequency;
    }

    public void setCount (int count) {
        this.count = count;
    }

    public int getId () {
        return this.id;
    }

    public int getCount () {
        return this.count;
    }

    public int getFrequency () {
        return this.frequency;
    }

    public String getName () {
        return this.name;
    }
}