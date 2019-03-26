package io.bootique.solrj.factory;

import io.bootique.annotation.BQConfig;
import org.apache.solr.client.solrj.SolrClient;
import com.fasterxml.jackson.annotation.JsonTypeName;

@BQConfig
@JsonTypeName("embedded")
public class EmbeddedSolrServerFactory extends SolrClientFactory {
    @Override
    public SolrClient createNew() {
        //TODO:
        return null;
    }
}
