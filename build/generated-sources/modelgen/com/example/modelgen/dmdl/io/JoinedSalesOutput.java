package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import com.example.modelgen.dmdl.model.JoinedSales;
import java.io.IOException;
/**
 * <code>joined_sales</code>をTSVなどのレコード形式で出力する。
 */
public final class JoinedSalesOutput implements ModelOutput<JoinedSales> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public JoinedSalesOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(JoinedSales model) throws IOException {
        emitter.emit(model.getItemIdOption());
        emitter.emit(model.getItemNameOption());
        emitter.emit(model.getSalesIdOption());
        emitter.emit(model.getCountOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}