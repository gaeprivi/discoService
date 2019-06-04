package ayds.jj2.discoservice.disco;

import ayds.jj2.discoservice.Album;

public interface DiscoGSToAlbumResolver {
    Album getAlbumFromExternalService(String body);
}
