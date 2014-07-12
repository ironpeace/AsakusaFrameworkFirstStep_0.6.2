package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.JoinedSales;
/**
 * An abstract implementation of {@link JoinedSales} exporter description using Direct I/O CSV.
 */
public abstract class AbstractJoinedSalesCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<? extends JoinedSales> getModelType() {
        return JoinedSales.class;
    }
    @Override public Class<JoinedSalesCsvFormat> getFormat() {
        return JoinedSalesCsvFormat.class;
    }
}