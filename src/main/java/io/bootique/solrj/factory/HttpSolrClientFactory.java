package io.bootique.solrj.factory;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.params.ModifiableSolrParams;

import java.util.LinkedHashMap;
import java.util.Map;

@BQConfig
@JsonTypeName("http")
public class HttpSolrClientFactory extends SolrClientFactory {
    private String baseSolrUrl;
    private boolean compression = false;
    private Map<String, String[]> invariantParams = new LinkedHashMap<>();

    @BQConfigProperty
    public void setBaseSolrUrl(String baseSolrUrl) {
        this.baseSolrUrl = baseSolrUrl;
    }

    @BQConfigProperty
    public void setCompression(boolean compression) {
        this.compression = compression;
    }

    @Override
    public SolrClient createNew() {
        return new HttpSolrClient.Builder(this.baseSolrUrl)
                .allowCompression(this.compression)
                .withInvariantParams(new ModifiableSolrParams(invariantParams))
                .withConnectionTimeout(this.connectionTimeoutMillis)
                .withSocketTimeout(this.socketTimeoutMillis)
                .build();
    }
}
