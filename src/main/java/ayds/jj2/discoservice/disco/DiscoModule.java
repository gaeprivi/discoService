package ayds.jj2.discoservice.disco;


import ayds.jj2.discoservice.ExternalService;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DiscoModule {

  private static final String DISCOGS_API_URL = "https://api.discogs.com/database/";

  private static DiscoModule instance;
  private final ExternalService externalService;

  private static final Retrofit discoGSAPIretrofit = new Retrofit.Builder()
          .baseUrl(DISCOGS_API_URL)
          .addConverterFactory(ScalarsConverterFactory.create())
          .build();

  private DiscoModule() {
    externalService = new DiscoService(discoGSAPIretrofit.create(DiscoGSAPI.class) , new DiscoGSToAlbumResolverImp());
  }

  public static DiscoModule getInstance() {
    if (instance == null) {
      instance = new DiscoModule();
    }
    return instance;
  }

  public ExternalService getExternalService() {
    return externalService;
  }
}
