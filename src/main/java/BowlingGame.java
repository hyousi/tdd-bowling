import java.util.List;

/**
 * simulates a line of bowling game.
 *
 * @author t0iiz
 */
public class BowlingGame {

    private List<Frame> frameList;

    /**
     * calculates the total score.
     */
    public int getScore() {
        int total = 0;
        for (int i = 0; i < frameList.size()-1; i++) {
            Frame curr = frameList.get(i);
            Frame next = frameList.get(i+1);
            int frameScore = curr.total();
            if (curr.isStrike()) {
                if (i+1 == frameList.size()-1 && next.isStrike()) {
                    frameScore += next.first + next.second;
                } else if (next.isStrike()) {
                    frameScore += next.total() + frameList.get(i+2).first;
                } else {
                    frameScore += next.total();
                }
            } else if (curr.isSpare()) {
                frameScore += next.first;
            }
            total += frameScore;
        }
        return total;
    }

    /**
     * calculates the points for a specific frame.
     */
    public int getFrameScore(int counter) {
        int index = counter - 1;
        Frame currFrame = frameList.get(index);
        if (counter == 10 || currFrame.total() < 10) {
            return currFrame.total();
        } else if (currFrame.isSpare()) {
            Frame nextFrame = frameList.get(index+1);
            return currFrame.total() + nextFrame.first;
        } else {
            Frame nextFrame = frameList.get(index+1);
            if (index == 9) {
                return currFrame.total() + nextFrame.first + nextFrame.second;
            } else if (nextFrame.isStrike()) {
                return currFrame.total() + nextFrame.first + frameList.get(index+2).first;
            } else {
                return currFrame.total() + nextFrame.total();
            }
        }
    }

    /**
     * simulates the action of roll a ball.
     */
    public void roll(int first) {
        frameList.add(new Frame(first));
    }

    public void roll(int first, int second) {
        frameList.add(new Frame(first, second));
    }

    public void roll(int first, int second, int third) {
        frameList.add(new LastFrame(first, second, third));
    }
}
