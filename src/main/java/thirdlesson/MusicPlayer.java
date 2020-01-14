package thirdlesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("musicPlayer")
public class MusicPlayer {
    private List<Music> musicList;
    @Autowired
    @Qualifier("rock")
    private Music music;
    @Value("${musicPlayer.volume}")
    private int volume;

    public MusicPlayer(List<Music> music) {
        this.musicList = music;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusicList() {
        System.out.print("Playing: ");
        musicList.forEach(record -> System.out.println(record.getSong()));
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

    public void showVolume() {
        System.out.println("Volume: " + volume);
    }
}
