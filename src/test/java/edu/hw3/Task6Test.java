package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.PriorityQueue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    void stockMarketAdd_shouldAddElementsAccordingPrice() {
        //arrange
        PriorityQueue<Task6.Stock> exp = new PriorityQueue<Task6.Stock>((o1, o2) -> o2.getPrice() - o1.getPrice());
        exp.add(new Task6.Stock(5));
        exp.add(new Task6.Stock(15));
        exp.add(new Task6.Stock(10));
        //act
        Task6.StockMarket stockMarket = new Task6.StockMarket();
        stockMarket.add(new Task6.Stock(15));
        stockMarket.add(new Task6.Stock(10));
        stockMarket.add(new Task6.Stock(5));
        PriorityQueue<Task6.Stock> act = stockMarket.queue;
        //assert
        for (int i = 0; i < 3; i++) {
            assertThat(act.poll()).isEqualTo(exp.poll());
        }
    }

    @Test
    void stockMarketMostValuableStock_shouldGetMostExpensiveStock() {
        //arrange
        Task6.Stock exp = new Task6.Stock(15);
        //act
        Task6.StockMarket stockMarket = new Task6.StockMarket();
        stockMarket.add(new Task6.Stock(5));
        stockMarket.add(new Task6.Stock(10));
        stockMarket.add(new Task6.Stock(15));
        Task6.Stock act = stockMarket.mostValuableStock();
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void stockMarketRemove_shouldRemoveStock() {
        //arrange
        Task6.Stock exp = new Task6.Stock(10);
        //act
        Task6.StockMarket stockMarket = new Task6.StockMarket();
        stockMarket.add(new Task6.Stock(5));
        stockMarket.add(new Task6.Stock(10));
        stockMarket.add(new Task6.Stock(15));
        stockMarket.remove(new Task6.Stock(15)); //The most expensive Stock has deleted
        Task6.Stock act = stockMarket.mostValuableStock();
        //assert
        assertThat(act).isEqualTo(exp);
    }

}
