package io.bootique.solrj;

import com.google.inject.Module;
import io.bootique.BQModule;
import io.bootique.BQModuleProvider;
import io.bootique.solrj.factory.SolrBasicAuthFactory;
import io.bootique.solrj.factory.SolrClientFactory;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SolrClientModuleProvider implements BQModuleProvider {
    @Override
    public Module module() {
        return new SolrClientModule();
    }

    @Override
    public BQModule.Builder moduleBuilder() {
        return BQModuleProvider.super
                .moduleBuilder()
                .description("Provides integration with SolrJ client library.");
    }

    @Override
    public Map<String, Type> configs() {
        return Collections.synchronizedMap(new HashMap<String, Type>() {{
            put("solrClient", SolrClientFactory.class);
            put("solrBasicAuth", SolrBasicAuthFactory.class);
        }});
    }
}
