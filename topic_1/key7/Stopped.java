package topic_1.key7;

public class Stopped implements AudioPlayerState {

    @Override
    public void pressPlay(MediaAdaptee context) {
            context.set_state(new Playing());
            System.out.println("Begin playing Audio");
    }

    @Override
    public void pressStop(MediaAdaptee context) {
            System.out.println("no effect");
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
