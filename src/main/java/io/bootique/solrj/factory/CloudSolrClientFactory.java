package io.bootique.solrj.factory;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;

import java.util.ArrayList;
import java.util.List;

@BQConfig
@JsonTypeName("cloud")
public class CloudSolrClientFactory extends SolrClientFactory {
    private List<String> solrUrls = new ArrayList<>();
    private boolean parallelUpdates = true;

    @BQConfigProperty
    public void setSolrUrls(List<String> solrUrls) {
        this.solrUrls = solrUrls;
    }

    @BQConfigProperty
    public void setParallelUpdates(boolean parallelUpdates) {
        this.parallelUpdates = parallelUpdates;
    }

    @Override
    public SolrClient createNew() {
        return new CloudSolrClient.Builder(this.solrUrls)
                .withParallelUpdates(this.parallelUpdates)
                .withConnectionTimeout(this.connectionTimeoutMillis)
                .withSocketTimeout(this.socketTimeoutMillis)
                .build();
    }
}
