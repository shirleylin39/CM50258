import java.util.List;
import java.util.ArrayList;


public class CustomSort implements SortingInterface {
    private ArrayList<Double> values;
    private ArrayList<Integer> gaps;

    public CustomSort() {
        this.values = new ArrayList<>();
        this.gaps = new ArrayList<>();
    }

    @Override
    public void setValues(ArrayList<Double> values) {
        this.values = values;
        sort();
    }

    @Override
    public ArrayList<Integer> getGaps() {
        return gaps;
    }

    @Override
    public void add(Double value) {
        values.add(value);
        sort();
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < values.size()) {
            values.remove(index);
        }
    }

    @Override
    public void sort() {
        if (values != null) {  // Check if values is not null
            gaps = calculateGaps(values.size());

            for (int gap : gaps) {
                for (int i = gap; i < values.size(); i++) {
                    double temp = values.get(i);
                    int j;

                    for (j = i; j >= gap && values.get(j - gap) > temp; j -= gap) {
                        values.set(j, values.get(j - gap));
                    }

                    values.set(j, temp);
                }
            }
        }
    }

    private ArrayList<Integer> calculateGaps(int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        int gap = 1;
        int i = 2;

        while (gap < n) {
            temp.add(gap);
            gap = (int) Math.pow(2, i) - 1;
            i++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int j = temp.size() - 1; j >= 0; j--) {
            result.add(temp.get(j));
        }

        return result;
    }
    public List<Double> getValues() {
        if (values != null) {
            // Create a defensive copy to prevent external modifications
            return new ArrayList<>(values);
        } else {
            return new ArrayList<>(); // Return an empty list if values is null
        }
    }

}
