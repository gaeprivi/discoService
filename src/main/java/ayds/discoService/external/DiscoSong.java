package ayds.discoService.external;

public class DiscoSong {

    private String songName;
    private String artistName;
    private String albumName;
    private String url;

    public DiscoSong(String songName, String artistName, String albumName, String url) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.url = url;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getUrl() {
        return url;
    }
}
