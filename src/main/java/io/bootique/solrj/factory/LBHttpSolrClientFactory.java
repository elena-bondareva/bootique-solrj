package io.bootique.solrj.factory;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.LBHttpSolrClient;

import java.util.List;

@BQConfig
@JsonTypeName("lbHttp")
public class LBHttpSolrClientFactory extends SolrClientFactory {
    private List<String> baseSolrUrls;

    @BQConfigProperty
    public void setBaseSolrUrls(List<String> baseSolrUrls) {
        this.baseSolrUrls = baseSolrUrls;
    }

    @Override
    public SolrClient createNew() {
        return new LBHttpSolrClient.Builder()
                .withBaseSolrUrls(baseSolrUrls.stream()
                        .toArray(String[]::new))
                .withConnectionTimeout(this.connectionTimeoutMillis)
                .withSocketTimeout(this.socketTimeoutMillis)
                .build();
    }
}
