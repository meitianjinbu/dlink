package com.dlink.utils;

import org.apache.flink.table.api.TableResult;
import org.apache.flink.table.catalog.CatalogManager;
import org.apache.flink.table.catalog.ContextResolvedTable;
import org.apache.flink.table.catalog.ObjectIdentifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * FlinkUtil
 *
 * @author wenmo
 * @since 2022/05/08
 */
public class FlinkUtil {

    public static List<String> getFieldNamesFromCatalogManager(CatalogManager catalogManager, String catalog, String database, String table) {
        Optional<ContextResolvedTable> tableOpt = catalogManager.getTable(
            ObjectIdentifier.of(catalog, database, table)
        );
        if (tableOpt.isPresent()) {
            return tableOpt.get().getResolvedSchema().getColumnNames();
        } else {
            return new ArrayList<String>();
        }
    }


    public static List<String> catchColumn(TableResult tableResult) {
        return tableResult.getResolvedSchema().getColumnNames();
    }
}
