package ayds.jj2.discoservice.disco;

import ayds.jj2.discoservice.Album;
import ayds.jj2.discoservice.ExternalService;
import ayds.jj2.discoservice.DiscoSong;
import retrofit2.Response;

class DiscoService implements ExternalService {

  private final DiscoGSAPI discoGSAPI;
  private final DiscoGSToAlbumResolver discoGSToAlbumResolver;


  DiscoService(DiscoGSAPI discoGSAPI , DiscoGSToAlbumResolver discoGSToAlbumResolver) {
    this.discoGSAPI = discoGSAPI;
    this.discoGSToAlbumResolver = discoGSToAlbumResolver;
  }

  public Album getAlbum(DiscoSong song) throws Exception {
    Response<String> callResponse = getAlbumFromService(song);
    return discoGSToAlbumResolver.getAlbumFromExternalService(callResponse.body());
  }

  private Response<String> getAlbumFromService(DiscoSong song) throws Exception {
    return discoGSAPI.getAlbumInfo(song.getAlbumName(), song.getArtistName()).execute();
  }

}


