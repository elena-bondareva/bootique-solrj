package io.bootique.solrj.factory;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;
import io.bootique.config.PolymorphicConfiguration;
import org.apache.solr.client.solrj.SolrClient;

@BQConfig
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = HttpSolrClientFactory.class)
public abstract class SolrClientFactory implements PolymorphicConfiguration {

    protected Integer connectionTimeoutMillis;
    protected Integer socketTimeoutMillis;
    protected boolean autocommit;

    @BQConfigProperty
    public void setConnectionTimeoutMillis(Integer connectionTimeoutMillis) {
        this.connectionTimeoutMillis = connectionTimeoutMillis;
    }

    @BQConfigProperty
    public void setSocketTimeoutMillis(Integer socketTimeoutMillis) {
        this.socketTimeoutMillis = socketTimeoutMillis;
    }

    public abstract SolrClient createNew();

    public boolean getAutocommit() {
        return autocommit;
    }

    @BQConfigProperty("Specifies if to perform hard or soft commit into Solr. Soft commit is by default.")
    public void setAutocommit(boolean autocommit) {
        this.autocommit = autocommit;
    }
}
