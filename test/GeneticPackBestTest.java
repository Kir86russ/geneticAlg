import Genetic.Algs;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class GeneticPackBestTest {


    Random random = new Random();
    private List<Item> items = new ArrayList<>();
    private Algs algs = new Algs();

    @Before
    public void fill() {
        items = new ArrayList<>();
        int itemsSize = 1000;
        for (int i = 0; i < itemsSize; i++)
            items.add(new Item(1 + random.nextInt(1000), 300 + random.nextInt(600)));
    }

    @Test
    public void fillKnapsackGreedy() {
        GeneticPackBest genetic = new GeneticPackBest(0.1, 10, 1000, 100);
        int maxWeight = 1000;
        Fill fillGenetic = genetic.fillKnapsackGenetic(maxWeight, items);
        System.out.println("Генетический набрал = " + fillGenetic.getCost());
        int weight = 0;
        for (Item item : fillGenetic.getItems())
            weight += item.getWeight();
        System.out.println("Вес " + weight);

        Fill fillGreedy = algs.fillKnapsackGreedy(maxWeight, items);
        System.out.println("Жадный " + fillGreedy.getCost());
        weight = 0;
        for (Item item : fillGreedy.getItems())
            weight += item.getWeight();
        System.out.println("Вес " + weight);
    }


}
