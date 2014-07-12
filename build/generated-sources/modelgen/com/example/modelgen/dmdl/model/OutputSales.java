package com.example.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.IntOption;
import com.asakusafw.runtime.value.StringOption;
import com.example.modelgen.dmdl.io.OutputSalesInput;
import com.example.modelgen.dmdl.io.OutputSalesOutput;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * 出力明細を表すデータモデルクラス。
 */
@DataModelKind("DMDL")@ModelInputLocation(OutputSalesInput.class)@ModelOutputLocation(OutputSalesOutput.class)@
        PropertyOrder({"item_id", "item_name", "sales_id", "count", "flg"}) public class OutputSales implements 
        DataModel<OutputSales>, Writable {
    private final IntOption itemId = new IntOption();
    private final StringOption itemName = new StringOption();
    private final IntOption salesId = new IntOption();
    private final IntOption count = new IntOption();
    private final StringOption flg = new StringOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.itemId.setNull();
        this.itemName.setNull();
        this.salesId.setNull();
        this.count.setNull();
        this.flg.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(OutputSales other) {
        this.itemId.copyFrom(other.itemId);
        this.itemName.copyFrom(other.itemName);
        this.salesId.copyFrom(other.salesId);
        this.count.copyFrom(other.count);
        this.flg.copyFrom(other.flg);
    }
    /**
     * 商品IDを返す。
     * @return 商品ID
     * @throws NullPointerException 商品IDの値が<code>null</code>である場合
     */
    public int getItemId() {
        return this.itemId.get();
    }
    /**
     * 商品IDを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemId(int value) {
        this.itemId.modify(value);
    }
    /**
     * <code>null</code>を許す商品IDを返す。
     * @return 商品ID
     */
    public IntOption getItemIdOption() {
        return this.itemId;
    }
    /**
     * 商品IDを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setItemIdOption(IntOption option) {
        this.itemId.copyFrom(option);
    }
    /**
     * 商品名を返す。
     * @return 商品名
     * @throws NullPointerException 商品名の値が<code>null</code>である場合
     */
    public Text getItemName() {
        return this.itemName.get();
    }
    /**
     * 商品名を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemName(Text value) {
        this.itemName.modify(value);
    }
    /**
     * <code>null</code>を許す商品名を返す。
     * @return 商品名
     */
    public StringOption getItemNameOption() {
        return this.itemName;
    }
    /**
     * 商品名を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setItemNameOption(StringOption option) {
        this.itemName.copyFrom(option);
    }
    /**
     * 明細IDを返す。
     * @return 明細ID
     * @throws NullPointerException 明細IDの値が<code>null</code>である場合
     */
    public int getSalesId() {
        return this.salesId.get();
    }
    /**
     * 明細IDを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setSalesId(int value) {
        this.salesId.modify(value);
    }
    /**
     * <code>null</code>を許す明細IDを返す。
     * @return 明細ID
     */
    public IntOption getSalesIdOption() {
        return this.salesId;
    }
    /**
     * 明細IDを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setSalesIdOption(IntOption option) {
        this.salesId.copyFrom(option);
    }
    /**
     * 売上数を返す。
     * @return 売上数
     * @throws NullPointerException 売上数の値が<code>null</code>である場合
     */
    public int getCount() {
        return this.count.get();
    }
    /**
     * 売上数を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setCount(int value) {
        this.count.modify(value);
    }
    /**
     * <code>null</code>を許す売上数を返す。
     * @return 売上数
     */
    public IntOption getCountOption() {
        return this.count;
    }
    /**
     * 売上数を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setCountOption(IntOption option) {
        this.count.copyFrom(option);
    }
    /**
     * フラグを返す。
     * @return フラグ
     * @throws NullPointerException フラグの値が<code>null</code>である場合
     */
    public Text getFlg() {
        return this.flg.get();
    }
    /**
     * フラグを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setFlg(Text value) {
        this.flg.modify(value);
    }
    /**
     * <code>null</code>を許すフラグを返す。
     * @return フラグ
     */
    public StringOption getFlgOption() {
        return this.flg;
    }
    /**
     * フラグを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setFlgOption(StringOption option) {
        this.flg.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=output_sales");
        result.append(", itemId=");
        result.append(this.itemId);
        result.append(", itemName=");
        result.append(this.itemName);
        result.append(", salesId=");
        result.append(this.salesId);
        result.append(", count=");
        result.append(this.count);
        result.append(", flg=");
        result.append(this.flg);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + itemId.hashCode();
        result = prime * result + itemName.hashCode();
        result = prime * result + salesId.hashCode();
        result = prime * result + count.hashCode();
        result = prime * result + flg.hashCode();
        return result;
    }
    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        OutputSales other = (OutputSales) obj;
        if(this.itemId.equals(other.itemId) == false) {
            return false;
        }
        if(this.itemName.equals(other.itemName) == false) {
            return false;
        }
        if(this.salesId.equals(other.salesId) == false) {
            return false;
        }
        if(this.count.equals(other.count) == false) {
            return false;
        }
        if(this.flg.equals(other.flg) == false) {
            return false;
        }
        return true;
    }
    /**
     * 商品名を返す。
     * @return 商品名
     * @throws NullPointerException 商品名の値が<code>null</code>である場合
     */
    public String getItemNameAsString() {
        return this.itemName.getAsString();
    }
    /**
     * 商品名を設定する。
     * @param itemName0 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemNameAsString(String itemName0) {
        this.itemName.modify(itemName0);
    }
    /**
     * フラグを返す。
     * @return フラグ
     * @throws NullPointerException フラグの値が<code>null</code>である場合
     */
    public String getFlgAsString() {
        return this.flg.getAsString();
    }
    /**
     * フラグを設定する。
     * @param flg0 設定する値
     */
    @SuppressWarnings("deprecation") public void setFlgAsString(String flg0) {
        this.flg.modify(flg0);
    }
    @Override public void write(DataOutput out) throws IOException {
        itemId.write(out);
        itemName.write(out);
        salesId.write(out);
        count.write(out);
        flg.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        itemId.readFields(in);
        itemName.readFields(in);
        salesId.readFields(in);
        count.readFields(in);
        flg.readFields(in);
    }
}