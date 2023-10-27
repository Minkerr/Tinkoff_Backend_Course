package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    void backwardIterator_shouldIterateInReverseOrder(){
        // arrange
        List exp = List.of(4, 3, 2, 1);
        // act
        Task8.BackwardIterator<Integer> it = new Task8.BackwardIterator<>(List.of(1, 2, 3, 4));
        List<Integer> act = new ArrayList<>();
        while (it.hasNext()){
            act.add(it.next());
        }
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
