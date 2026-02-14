package q2;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;

/**
 * A clean, readable implementation for injecting video into a SurfaceTexture.
 * This class handles the playback of video files onto surfaces used in camera previews.
 */
public class VideoInjector {
    
    private MediaPlayer mediaPlayer;
    private SurfaceTexture surfaceTexture;
    private Surface surface;
    private boolean isPlaying = false;
    
    /**
     * Creates a new VideoInjector with the given SurfaceTexture
     * @param surfaceTexture The SurfaceTexture to inject video into
     */
    public VideoInjector(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("SurfaceTexture may not be null");
        }
        this.surfaceTexture = surfaceTexture;
        // Create a Surface from the SurfaceTexture for MediaPlayer
        this.surface = new Surface(surfaceTexture);
    }
    
    /**
     * Sets up video playback from file path
     * @param filePath Path to the video file
     */
    public void setVideoPath(String filePath) {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.setSurface(surface);
            mediaPlayer.prepareAsync();
            
            // Set up completion listener
            mediaPlayer.setOnPreparedListener(mp -> {
                // Start playback when prepared
                mp.start();
                isPlaying = true;
            });
            
            mediaPlayer.setOnCompletionListener(mp -> {
                // Loop the video
                mp.seekTo(0);
                mp.start();
            });
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Starts video playback
     */
    public void start() {
        if (mediaPlayer != null && !isPlaying) {
            mediaPlayer.start();
            isPlaying = true;
        }
    }
    
    /**
     * Pauses video playback
     */
    public void pause() {
        if (mediaPlayer != null && isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
        }
    }
    
    /**
     * Stops video playback and releases resources
     */
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            isPlaying = false;
        }
    }
    
    /**
     * Releases all resources held by this injector
     */
    public void release() {
        stop();
        if (surface != null) {
            surface.release();
            surface = null;
        }
    }
    
    /**
     * Checks if video playback is currently active
     * @return true if playing, false otherwise
     */
    public boolean isPlaying() {
        return isPlaying && mediaPlayer != null && mediaPlayer.isPlaying();
    }
}
