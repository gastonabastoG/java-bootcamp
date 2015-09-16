package topic_1.key7;

public class Playing implements AudioPlayerState {

    @Override
    public void pressPlay(MediaAdaptee context) {
            System.out.println("no effect");

    }

    @Override
    public void pressStop(MediaAdaptee context) {
            System.out.println("Stopped");
            context.set_state(new Stopped());

    }

    @Override
    public void pressPause(MediaAdaptee context) {
            System.out.println("Paused");
            context.set_state(new Paused());

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
