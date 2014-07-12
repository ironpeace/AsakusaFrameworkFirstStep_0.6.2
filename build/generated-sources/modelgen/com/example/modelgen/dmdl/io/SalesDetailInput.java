package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.RecordParser;
import com.example.modelgen.dmdl.model.SalesDetail;
import java.io.IOException;
/**
 * TSVファイルなどのレコードを表すファイルを入力として<code>sales_detail</code>を読み出す
 */
public final class SalesDetailInput implements ModelInput<SalesDetail> {
    private final RecordParser parser;
    /**
     * インスタンスを生成する。
     * @param parser 利用するパーサー
     * @throws IllegalArgumentException 引数に<code>null</code>が指定された場合
     */
    public SalesDetailInput(RecordParser parser) {
        if(parser == null) {
            throw new IllegalArgumentException("parser");
        }
        this.parser = parser;
    }
    @Override public boolean readTo(SalesDetail model) throws IOException {
        if(parser.next() == false) {
            return false;
        }
        parser.fill(model.getSalesIdOption());
        parser.fill(model.getItemIdOption());
        parser.fill(model.getCountOption());
        parser.endRecord();
        return true;
    }
    @Override public void close() throws IOException {
        parser.close();
    }
}