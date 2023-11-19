package edu.hw6;

import org.junit.jupiter.api.Test;
import static edu.hw6.Task5.HackerNews.hackerNewsTopStories;
import static edu.hw6.Task5.HackerNews.news;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    void news_shouldReturnArticleTitle() {
        //arrange
        String exp = "JDK 21 Release Notes";
        //act
        var act = news(37570037);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void hackerNewsTopStories_shouldReturnLongArrayOfTopNews() {
        //arrange
        //act
        var act = hackerNewsTopStories();
        //assert
        assertThat(act.getClass().isArray()).isTrue();
    }
}
