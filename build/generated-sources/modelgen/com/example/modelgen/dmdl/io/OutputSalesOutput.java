package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import com.example.modelgen.dmdl.model.OutputSales;
import java.io.IOException;
/**
 * <code>output_sales</code>をTSVなどのレコード形式で出力する。
 */
public final class OutputSalesOutput implements ModelOutput<OutputSales> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public OutputSalesOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(OutputSales model) throws IOException {
        emitter.emit(model.getItemIdOption());
        emitter.emit(model.getItemNameOption());
        emitter.emit(model.getSalesIdOption());
        emitter.emit(model.getCountOption());
        emitter.emit(model.getFlgOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}