package topic_1.key7;

public class Paused implements AudioPlayerState {

    @Override
    public void pressPlay(MediaAdaptee context) {
        context.set_state(new Stopped());
        System.out.println("resuming audio");
    }

    @Override
    public void pressStop(MediaAdaptee context) {
        context.set_state(new Stopped());
        System.out.println("stopped");
    }

    @Override
    public void pressPause(MediaAdaptee context) {
        System.out.println("no effect");

    }

    @Override
    public void pressForward(MediaAdaptee context) {
        context.set_state(new Stopped());
        System.out.println("forward");
    }

    @Override
    public void pressBackward(MediaAdaptee context) {
        context.set_state(new Stopped());
        System.out.println("backward");
    }

}
