package io.bootique.solrj;

import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.bootique.BQCoreModule;
import io.bootique.ConfigModule;
import io.bootique.config.ConfigurationFactory;
import io.bootique.solrj.factory.SolrBasicAuthFactory;
import io.bootique.solrj.factory.SolrClientFactory;

public class SolrClientModule extends ConfigModule {

    public SolrClientModule() {
    }

    @Override
    public void configure(Binder binder) {
        super.configure(binder);

        BQCoreModule.extend(binder)
                .declareVar("solrBasicAuth.username", "SOCIAL_FEED_SOLR_USERNAME")
                .declareVar("solrBasicAuth.password", "SOCIAL_FEED_SOLR_PASSWORD");
    }

    @Singleton
    @Provides
    public SolrClientFactory provideSolrClient(ConfigurationFactory configFactory) {
        SolrClientFactory solrClientFactory = configFactory
                .config(SolrClientFactory.class, "solrClient");

        return solrClientFactory;
    }

    @Singleton
    @Provides
    public SolrBasicAuthFactory provideSolrBasicAuthFactory(ConfigurationFactory configFactory) {
        SolrBasicAuthFactory solrBasicAuthFactory = configFactory
                .config(SolrBasicAuthFactory.class, "solrBasicAuth");

        return solrBasicAuthFactory;
    }
}
