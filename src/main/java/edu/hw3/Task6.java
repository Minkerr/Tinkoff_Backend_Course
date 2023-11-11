package edu.hw3;

import java.util.Objects;
import java.util.PriorityQueue;

public class Task6 {
    static class Stock {
        private int price;

        Stock(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
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
