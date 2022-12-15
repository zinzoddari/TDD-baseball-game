package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.StructureUtils;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 0})
    void set_size_확인_실패(int size) {


        assertThat(StructureUtils.getSetSize(numbers)).isNotEqualTo(size);
    }

    @Test
    void set_size_확인_성공() {
        assertThat(StructureUtils.getSetSize(numbers)).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_데이터_확인_성공(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @Test
    void set_데이터_확인_실패() {
        assertThat(numbers.contains(4)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3 })
    void set_데이터_ParameterizedTest_확인(int args) {
        assertThat(numbers.contains(args)).isTrue();
    }
}
