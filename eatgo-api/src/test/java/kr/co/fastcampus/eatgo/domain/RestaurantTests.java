package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RestaurantTests {
    @Test
    public void creation(){
        Restaurant restaurant=Restaurant.builder()
                .id(1234L)
                .name("Bob Zip")
                .address("Seoul")
                .build();
        assertThat(restaurant.getName()).isEqualTo("Bob Zip");
        assertThat(restaurant.getAddress()).isEqualTo("Seoul");
        assertThat(restaurant.getId()).isEqualTo(1234L);
    }

    @Test
    public void information(){
        Restaurant restaurant=Restaurant.builder()
                .id(1234L)
                .name("Bob Zip")
                .address("Seoul")
                .build();

        assertThat(restaurant.getInformation()).isEqualTo("Bob Zip in Seoul");

    }
}