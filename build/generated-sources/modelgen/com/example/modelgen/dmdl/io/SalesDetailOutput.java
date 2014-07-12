package com.example.modelgen.dmdl.io;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.RecordEmitter;
import com.example.modelgen.dmdl.model.SalesDetail;
import java.io.IOException;
/**
 * <code>sales_detail</code>をTSVなどのレコード形式で出力する。
 */
public final class SalesDetailOutput implements ModelOutput<SalesDetail> {
    private final RecordEmitter emitter;
    /**
     * インスタンスを生成する。
     * @param emitter 利用するエミッター
     * @throws IllegalArgumentException 引数にnullが指定された場合
     */
    public SalesDetailOutput(RecordEmitter emitter) {
        if(emitter == null) {
            throw new IllegalArgumentException();
        }
        this.emitter = emitter;
    }
    @Override public void write(SalesDetail model) throws IOException {
        emitter.emit(model.getSalesIdOption());
        emitter.emit(model.getItemIdOption());
        emitter.emit(model.getCountOption());
        emitter.endRecord();
    }
    @Override public void close() throws IOException {
        emitter.close();
    }
}