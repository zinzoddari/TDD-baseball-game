package baseball;

import study.PlayResult;

import java.util.List;

public interface Playable {
    PlayResult play(List<Integer> answers);
}
