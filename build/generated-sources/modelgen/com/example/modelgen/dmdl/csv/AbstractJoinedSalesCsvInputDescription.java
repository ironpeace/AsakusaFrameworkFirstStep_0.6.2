package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.JoinedSales;
/**
 * An abstract implementation of {@link JoinedSales} importer description using Direct I/O CSV.
 */
public abstract class AbstractJoinedSalesCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<? extends JoinedSales> getModelType() {
        return JoinedSales.class;
    }
    @Override public Class<JoinedSalesCsvFormat> getFormat() {
        return JoinedSalesCsvFormat.class;
    }
}