package edu.hw3;

import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Task6 {
    static class Stock implements Comparable<Stock> {
        private int price;

        public Stock(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public int compareTo(@NotNull Stock o) {
            return this.price - o.price;
        }

        @Override public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Stock stock = (Stock) o;
            return price == stock.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price);
        }
    }

    static class StockMarket {
        PriorityQueue<Stock> queue = new PriorityQueue<>((o1, o2) -> o2.getPrice() - o1.getPrice());

        void add(Stock stock) {
            queue.add(stock);
        }

        void remove(Stock stock) {
            queue.remove(stock);
        }

        Stock mostValuableStock() {
            return queue.peek();
        }
    }
}
