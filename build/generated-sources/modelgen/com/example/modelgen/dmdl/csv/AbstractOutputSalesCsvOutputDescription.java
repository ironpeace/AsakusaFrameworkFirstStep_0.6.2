package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.OutputSales;
/**
 * An abstract implementation of {@link OutputSales} exporter description using Direct I/O CSV.
 */
public abstract class AbstractOutputSalesCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<? extends OutputSales> getModelType() {
        return OutputSales.class;
    }
    @Override public Class<OutputSalesCsvFormat> getFormat() {
        return OutputSalesCsvFormat.class;
    }
}