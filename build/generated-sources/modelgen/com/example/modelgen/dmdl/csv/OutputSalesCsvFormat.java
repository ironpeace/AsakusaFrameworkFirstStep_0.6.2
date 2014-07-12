package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.BinaryStreamFormat;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.csv.CsvConfiguration;
import com.asakusafw.runtime.io.csv.CsvEmitter;
import com.asakusafw.runtime.io.csv.CsvParser;
import com.example.modelgen.dmdl.model.OutputSales;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.util.ReflectionUtils;
/**
 * CSV format for {@link OutputSales}.
 */
public final class OutputSalesCsvFormat extends BinaryStreamFormat<OutputSales> {
    /**
     * Returns this CSV format configuration.
     * @param head whether configure for head of file or not
     * @return CSV format configuration
     */
    protected CsvConfiguration getConfiguration(boolean head) {
        CsvConfiguration config = new CsvConfiguration(Charset.forName("UTF-8"), CsvConfiguration.DEFAULT_HEADER_CELLS, 
                "true", "false", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss");
        config.setLineBreakInValue(false);
        return config;
    }
    @Override public Class<OutputSales> getSupportedType() {
        return OutputSales.class;
    }
    @Override public long getPreferredFragmentSize() {
        return -1L;
    }
    @Override public long getMinimumFragmentSize() {
        return -1;
    }
    @Override public ModelInput<OutputSales> createInput(Class<? extends OutputSales> dataType, String path, InputStream 
            stream, long offset, long fragmentSize) throws IOException {
        if(dataType == null) {
            throw new IllegalArgumentException("dataType must not be null");
        }
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        if(offset > 0L) {
            throw new IllegalArgumentException(
                    "com.example.modelgen.dmdl.csv.OutputSalesCsvFormat does not support fragmentation.");
        }
        InputStream fragmentInput;
        fragmentInput = ReflectionUtils.newInstance(GzipCodec.class, new Configuration(false)).createInputStream(stream)
                ;
        CsvParser parser = new CsvParser(fragmentInput, path, this.getConfiguration(offset == 0L));
        return new Reader(parser);
    }
    @Override public ModelOutput<OutputSales> createOutput(Class<? extends OutputSales> dataType, String path, 
            OutputStream stream) throws IOException {
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        CsvEmitter emitter = new CsvEmitter(ReflectionUtils.newInstance(GzipCodec.class, new Configuration(false)).
                createOutputStream(stream), path, this.getConfiguration(true));
        return new Writer(emitter);
    }
    private static final class Reader implements ModelInput<OutputSales> {
        private final CsvParser parser;
        Reader(CsvParser parser) {
            this.parser = parser;
        }
        @Override public boolean readTo(OutputSales object) throws IOException {
            if(parser.next() == false) {
                return false;
            }
            parser.fill(object.getItemIdOption());
            parser.fill(object.getItemNameOption());
            parser.fill(object.getSalesIdOption());
            parser.fill(object.getCountOption());
            parser.fill(object.getFlgOption());
            parser.endRecord();
            return true;
        }
        @Override public void close() throws IOException {
            parser.close();
        }
    }
    private static final class Writer implements ModelOutput<OutputSales> {
        private final CsvEmitter emitter;
        Writer(CsvEmitter emitter) {
            this.emitter = emitter;
        }
        @Override public void write(OutputSales object) throws IOException {
            emitter.emit(object.getItemIdOption());
            emitter.emit(object.getItemNameOption());
            emitter.emit(object.getSalesIdOption());
            emitter.emit(object.getCountOption());
            emitter.emit(object.getFlgOption());
            emitter.endRecord();
        }
        @Override public void close() throws IOException {
            emitter.close();
        }
    }
}