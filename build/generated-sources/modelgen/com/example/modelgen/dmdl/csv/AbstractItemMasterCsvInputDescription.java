package com.example.modelgen.dmdl.csv;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.ItemMaster;
/**
 * An abstract implementation of {@link ItemMaster} importer description using Direct I/O CSV.
 */
public abstract class AbstractItemMasterCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<? extends ItemMaster> getModelType() {
        return ItemMaster.class;
    }
    @Override public Class<ItemMasterCsvFormat> getFormat() {
        return ItemMasterCsvFormat.class;
    }
}