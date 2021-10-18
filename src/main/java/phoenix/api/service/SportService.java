package phoenix.api.service;

import phoenix.api.sport.SportLineProvider;

public interface SportService {

    SportService registerProvider(SportLineProvider... providers);

    SportLineProvider getUserPreferredProvider();

}
