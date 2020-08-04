public class LastFrame extends Frame{
    public int third;

    public LastFrame(int first, int second, int third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public int total() {
        return super.total() + this.third;
    }
}
