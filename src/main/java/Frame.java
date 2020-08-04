public class Frame {
    public int first;
    public int second;

    Frame(int first) {
        this.first = first;
        this.second = 0;
    }

    Frame(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public boolean isSpare() {
        return first != 10 && first + second == 10;
    }

    public boolean isStrike() {
        return first == 10;
    }

    public int total() {
        return this.first + this.second;
    }
}
