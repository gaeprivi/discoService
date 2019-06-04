package ayds.jj2.discoservice;

public class Album {

  private String albumTitle;
  private String albumImageCoverPath;

  public Album(String albumDescription, String albumImageCoverPath) {
    this.albumTitle = albumDescription;
    this.albumImageCoverPath = albumImageCoverPath;
  }

  public String getAlbumCoverImage(){ return albumImageCoverPath;}

  public String getAlbumTitle() {
    return albumTitle;
  }
}
