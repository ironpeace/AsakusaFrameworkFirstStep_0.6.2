package com.example.modelgen.dmdl.csv;

import com.example.modelgen.dmdl.csv.AbstractItemMasterCsvInputDescription;

/**
 * 商品マスタ
 */
public class ItemMasterFromCsv extends AbstractItemMasterCsvInputDescription {

	@Override
	public String getBasePath() {
		return "sample/in";
	}

	@Override
	public String getResourcePattern() {
		return "sales_details.csv";
	}

	@Override
	public DataSize getDataSize() {
		return DataSize.UNKNOWN;
	}
}
