package edu.hw9;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void push_shouldAddElementAndRecalculateStats() {
        //arrange
        StatsCollector collector = new StatsCollector();
        var expMin = 1.0;
        var expMax = 2.0;
        var expSum = 4.5;
        var expAvg = 1.5;
        //act
        collector.push(new double[] {1.0, 1.5, 2.0});
        var actMin = collector.getMin();
        var actMax = collector.getMax();
        var actSum = collector.getSum();
        var actAvg = collector.getAvg();
        //assert
        assertThat(actMin).isEqualTo(expMin);
        assertThat(actMax).isEqualTo(expMax);
        assertThat(actSum).isEqualTo(expSum);
        assertThat(actAvg).isEqualTo(expAvg);
    }

    @Test
    void StatsCollector_testMulthithread() {
        StatsCollector collector = new StatsCollector();
        Thread addData1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                collector.push(new double[] {1, 1, 1, 1});
            }
        });
        Thread addData2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                collector.push(new double[] {1, 1, 1, 1, 1});
            }
        });
        Thread addData3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                collector.push(new double[] {1, 1, 1, 1, 1, 1, 1});
            }
        });
        Thread getStat = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                assertThat(collector.getAvg()).isEqualTo(1.0);
            }
        });
        addData1.start();
        addData2.start();
        addData3.start();
        getStat.start();

        try {
            addData1.join();
            addData2.join();
            addData3.join();
            getStat.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
