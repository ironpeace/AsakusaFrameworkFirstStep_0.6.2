package com.example.jobflow;

import com.asakusafw.vocabulary.flow.Export;
import com.asakusafw.vocabulary.flow.FlowDescription;
import com.asakusafw.vocabulary.flow.Import;
import com.asakusafw.vocabulary.flow.In;
import com.asakusafw.vocabulary.flow.JobFlow;
import com.asakusafw.vocabulary.flow.Out;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory;
import com.asakusafw.vocabulary.flow.util.CoreOperatorFactory.Extend;
import com.example.modelgen.dmdl.csv.ItemMasterFromCsv;
import com.example.modelgen.dmdl.csv.OutputSalesToCsv;
import com.example.modelgen.dmdl.csv.SalesDetailFromCsv;
import com.example.modelgen.dmdl.model.ItemMaster;
import com.example.modelgen.dmdl.model.OutputSales;
import com.example.modelgen.dmdl.model.SalesDetail;
import com.example.operator.MainOperatorFactory;
import com.example.operator.MainOperatorFactory.JoinedSales;
import com.example.operator.MainOperatorFactory.Updated;

/**
 * MainJobFlow
 */
@JobFlow(name = "mainJobFlow")
public class MainJobFlow extends FlowDescription {
	/** sales_detail */
	private final In<SalesDetail> sales_detail;
	/** item_master */
	private final In<ItemMaster> item_master;
	/** output_sales */
	private final Out<OutputSales> output_sales;

	public MainJobFlow(
			@Import(name = "sales_detail", description = SalesDetailFromCsv.class) In<SalesDetail> sales_detail,
			@Import(name = "item_master", description = ItemMasterFromCsv.class) In<ItemMaster> item_master,
			@Export(name = "output_sales", description = OutputSalesToCsv.class) Out<OutputSales> output_sales) {
		this.sales_detail = sales_detail;
		this.item_master = item_master;
		this.output_sales = output_sales;
	}

	@Override
	public void describe() {
		MainOperatorFactory mainOperator = new MainOperatorFactory();
		CoreOperatorFactory core = new CoreOperatorFactory();

		// マスター結合演算子
		JoinedSales joinedSales = mainOperator.joinedSales(this.item_master, this.sales_detail);
		// 停止演算子
		core.stop(joinedSales.missed);
		// 拡張演算子
		Extend<OutputSales> extend = core.extend(joinedSales.joined, OutputSales.class);
		// 更新演算子
		Updated updated = mainOperator.updated(extend.out);

		this.output_sales.add(updated.out);
	}
}
