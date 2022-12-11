package study;

public class BallNumber {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private int no;

    public BallNumber(int no) {
        if(no < MIN_NUM && no > MAX_NUM) {
            throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야한다.");
        }
        this.no = no;
    }
}
