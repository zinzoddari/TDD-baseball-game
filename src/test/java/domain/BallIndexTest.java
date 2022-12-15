package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallIndexTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void 볼_인덱스는_1부터_3범위만_가질_수_있다(int index) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallIndex(index));

    }

    @Test
    void 볼_동등성_비교() {
        assertAll(
                () -> assertThat(new BallIndex(1).equals(new BallIndex(3))).isFalse(),
                () -> assertThat(new BallIndex(3).equals(new BallIndex(3))).isTrue()
        );
    }

}
