package baseball;

import dto.PlayResult;

import java.util.List;

public interface Playable {
    PlayResult play(List<Integer> answers);
}
