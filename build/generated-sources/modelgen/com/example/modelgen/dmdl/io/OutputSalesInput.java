package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import com.example.modelgen.dmdl.model.OutputSales;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>output_sales</code>を読み出す
 */
public final class OutputSalesInput implements ModelInput<OutputSales> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public OutputSalesInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(OutputSales model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getItemIdOption());
        parser.fill(model.getItemNameOption());
        parser.fill(model.getSalesIdOption());
        parser.fill(model.getCountOption());
        parser.fill(model.getFlgOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}