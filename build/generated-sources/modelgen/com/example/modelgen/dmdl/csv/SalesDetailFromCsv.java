package com.example.modelgen.dmdl.csv;

import com.example.modelgen.dmdl.csv.AbstractSalesDetailCsvInputDescription;

/**
 * 売上明細
 */
public class SalesDetailFromCsv extends AbstractSalesDetailCsvInputDescription {

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
