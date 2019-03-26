package io.bootique.solrj.factory;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;

@BQConfig
@JsonTypeName("concurrent")
public class ConcurrentUpdateSolrClientFactory extends SolrClientFactory {
    private String baseSolrUrl;
    private int queueSize = 10;
    private int threadCount;

    @BQConfigProperty
    public void setBaseSolrUrl(String baseSolrUrl) {
        this.baseSolrUrl = baseSolrUrl;
    }

    @BQConfigProperty
    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    @BQConfigProperty
    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public SolrClient createNew() {
        return new ConcurrentUpdateSolrClient.Builder(this.baseSolrUrl)
                .withQueueSize(queueSize)
                .withThreadCount(threadCount)
                .withConnectionTimeout(this.connectionTimeoutMillis)
                .withSocketTimeout(this.socketTimeoutMillis)
                .build();
    }
}
