package io.bootique.solrj;

import io.bootique.test.junit.BQModuleProviderChecker;
import org.junit.Test;

public class SolrClientModuleProviderTest {

    @Test
    public void testAutoLoadable() {
        BQModuleProviderChecker.testAutoLoadable(SolrClientModuleProvider.class);
    }

    @Test
    public void testMetadata() {
        BQModuleProviderChecker.testMetadata(SolrClientModuleProvider.class);
    }
}
