package ayds.discoService.external.disco;

import ayds.discoService.external.Album;
import ayds.discoService.external.ExternalService;
import ayds.discoService.external.DiscoSong;
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


