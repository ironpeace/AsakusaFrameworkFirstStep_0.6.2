package com.example.jobflow;
import org.junit.Test;
import com.asakusafw.testdriver.JobFlowTester;
import com.example.modelgen.dmdl.model.ItemMaster;
import com.example.modelgen.dmdl.model.OutputSales;
import com.example.modelgen.dmdl.model.SalesDetail;

public class MainTest {
	@Test
	public void test(){
		JobFlowTester tester = new JobFlowTester(getClass());
		
		tester.input("item_master", ItemMaster.class)
			.prepare("item_master.xls#input");
		
		tester.input("sales_detail", SalesDetail.class)
			.prepare("sales_detail.xls#input");
		
		tester.output("output_sales", OutputSales.class)
			.verify("output_sales.xls#output", "output_sales.xls#rule");

		tester.runTest(MainJobFlow.class);
	}
}
