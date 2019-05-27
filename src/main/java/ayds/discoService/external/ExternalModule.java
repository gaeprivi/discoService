package ayds.discoService.external;

import ayds.discoService.external.disco.DiscoModule;

public class ExternalModule {

  private static ExternalModule instance;

  private ExternalModule() {
  }

  public static ExternalModule getInstance() {
    if (instance == null) {
      instance = new ExternalModule();
    }
    return instance;
  }

  public ExternalService getExternalService() {
    return DiscoModule.getInstance().getExternalService();
  }
}
