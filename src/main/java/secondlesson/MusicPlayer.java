package secondlesson;

import java.util.List;

public class MusicPlayer {
    private List<Music> musicList;
    private int volume;

    public MusicPlayer(List<Music> music) {
        this.musicList = music;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic() {
        System.out.print("Playing: ");
        musicList.forEach(record -> System.out.println(record.getSong()));
    }

    public void showVolume() {
        System.out.println("Volume: " + volume);
    }
}
