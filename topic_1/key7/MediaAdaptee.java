package topic_1.key7;



/**
 * @author Guille
 * adaptee class, a real simulated audio player
 */
public class MediaAdaptee implements MediaPlayer {
     private AudioPlayerState _state;

     /**
     * by default the player is stopped
     */
     public MediaAdaptee() {
             _state=new Stopped();
     }


    @Override
    public void play() {
            _state.pressPlay(this);
    }

    @Override
    public void pause() {
            _state.pressPause(this);

    }

    @Override
    public void stop() {
            _state.pressStop(this);

    }

    //---getters and setters

    public AudioPlayerState get_state() {
            return _state;
    }

    public void set_state(AudioPlayerState _state) {
            this._state = _state;
    }

    @Override
    public void forward() {
        _state.pressForward(this);
    }

    @Override
    public void backward() {
        _state.pressBackward(this);
    }

}
