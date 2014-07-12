package com.example.operator;

import com.asakusafw.vocabulary.operator.MasterJoin;
import com.asakusafw.vocabulary.operator.Update;
import com.example.modelgen.dmdl.model.ItemMaster;
import com.example.modelgen.dmdl.model.JoinedSales;
import com.example.modelgen.dmdl.model.OutputSales;
import com.example.modelgen.dmdl.model.SalesDetail;

public abstract class MainOperator {

	/**
	 * マスター結合演算子
	 * @param master  マスター
	 * @param tx  トランザクション
	 * @return  結合済
	 */
	@MasterJoin
	public abstract JoinedSales joinedSales(ItemMaster master, SalesDetail tx);

	/**
	 * 更新演算子
	 * @param in  入力
	 */
	@Update
	public void updated(OutputSales in) {
		if(in.getCount() > 100){
			in.setFlgAsString("over100");
		}else{
			in.setFlgAsString("under100");
		}
	}
}
