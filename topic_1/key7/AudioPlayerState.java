package topic_1.key7;

public interface AudioPlayerState {
	
	// Actions - Events
	
	public void pressPlay(MediaAdaptee context);
	
	public void pressStop(MediaAdaptee context);
	
	public void pressPause(MediaAdaptee context);
        
        public void pressForward(MediaAdaptee context);
        public void pressBackward(MediaAdaptee context);

}
