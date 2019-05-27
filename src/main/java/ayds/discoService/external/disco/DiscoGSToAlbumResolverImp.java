package ayds.discoService.external.disco;

import ayds.discoService.external.Album;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DiscoGSToAlbumResolverImp implements DiscoGSToAlbumResolver {

    public Album getAlbumFromExternalService(String body) {

        Album album = null;

        Gson gson = new Gson();

        JsonObject jobj = gson.fromJson(body, JsonObject.class);
        JsonArray results = jobj.get("results").getAsJsonArray();

        if(results.size()>0){
            JsonObject first = results.get(0).getAsJsonObject();

            JsonElement JsonAlbumTitle = first.get("title");
            JsonElement JsonAlbumYear = first.get("year");
            JsonElement JsonAlbumImageCover = first.get("cover_image");

            String albumTitleAndYear = JsonAlbumTitle.getAsString() + " - " +JsonAlbumYear.getAsString();
            String albumImageCover = JsonAlbumImageCover.getAsString();

            album = new Album(albumTitleAndYear ,albumImageCover);

        }

        return album;
    }

}
