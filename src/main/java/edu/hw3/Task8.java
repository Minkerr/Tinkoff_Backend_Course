package edu.hw3;

import java.util.Iterator;
import java.util.List;

public class Task8 {
    public static class BackwardIterator<T> implements Iterator<T> {

        private List<T> list;
        private int position;

        public BackwardIterator(List<T> list) {
            this.list = list;
            this.position = list.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return position >= 0;
        }

        @Override
        public T next() {
            return list.get(position--);
        }

    }
}
