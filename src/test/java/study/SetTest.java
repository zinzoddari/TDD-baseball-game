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

    @Test
    void set_size_확인_실패() {
        assertThat(StructureUtils.getSetSize(numbers)).isNotEqualTo(2);
    }

    @Test
    void set_size_확인_성공() {
        assertThat(StructureUtils.getSetSize(numbers)).isEqualTo(3);
    }

    @Test
    void set_데이터_확인_성공() {
        assertAll(
                () -> assertThat(numbers.contains(1)).isTrue(),
                () -> assertThat(numbers.contains(2)).isTrue(),
                () -> assertThat(numbers.contains(3)).isTrue()
        );
    }

    @Test
    void set_데이터_확인_실패() {
        assertThat(numbers.contains(4)).isFalse();
        assertThat(numbers.contains(5)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_데이터_ParameterizedTest_성공(int args) {
        assertThat(numbers.contains(args)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void set_데이터_ParameterizedTest_실패(int args) {
        assertThat(numbers.contains(args)).isFalse();
    }
}
