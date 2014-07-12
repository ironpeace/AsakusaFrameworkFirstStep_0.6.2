package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.OutputSales;
/**
 * An abstract implementation of {@link OutputSales} importer description using Direct I/O CSV.
 */
public abstract class AbstractOutputSalesCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<? extends OutputSales> getModelType() {
        return OutputSales.class;
    }
    @Override public Class<OutputSalesCsvFormat> getFormat() {
        return OutputSalesCsvFormat.class;
    }
}