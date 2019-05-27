package ayds.discoService.external.disco;

import ayds.discoService.external.Album;

public interface DiscoGSToAlbumResolver {
    Album getAlbumFromExternalService(String body);
}
