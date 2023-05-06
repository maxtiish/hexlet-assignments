package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        assertThat(App.take(list1,2));

        List<Integer> list2 = new ArrayList<>();
        assertThat(list2.isEmpty());

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(5);
        list3.add(7);
        list3.add(9);
        list3.add(11);

        assertThat(App.take(list3, 5));

        // END
    }
}
