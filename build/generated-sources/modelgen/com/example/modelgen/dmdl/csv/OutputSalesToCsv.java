package com.example.modelgen.dmdl.csv;

import com.example.modelgen.dmdl.csv.AbstractOutputSalesCsvOutputDescription;
import java.util.List;

/**
 * 出力明細
 */
public class OutputSalesToCsv extends AbstractOutputSalesCsvOutputDescription {

	@Override
	public String getBasePath() {
		return "sample/out";
	}

	@Override
	public String getResourcePattern() {
		return "output_sales.csv";
	}

	@Override
	public List<String> getOrder() {
		return super.getOrder();
	}

	@Override
	public List<String> getDeletePatterns() {
		return super.getDeletePatterns();
	}
}
