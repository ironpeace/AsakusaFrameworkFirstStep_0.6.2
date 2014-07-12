package com.example.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.ModelInputLocation;
import com.asakusafw.runtime.model.ModelOutputLocation;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.IntOption;
import com.asakusafw.runtime.value.StringOption;
import com.asakusafw.vocabulary.model.Joined;
import com.asakusafw.vocabulary.model.Key;
import com.example.modelgen.dmdl.io.JoinedSalesInput;
import com.example.modelgen.dmdl.io.JoinedSalesOutput;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * 結合明細を表すデータモデルクラス。
 */
@DataModelKind("DMDL")@Joined(terms = {@Joined.Term(source = ItemMaster.class, mappings = {@Joined.Mapping(source = 
                "itemId", destination = "itemId"),@Joined.Mapping(source = "itemName", destination = "itemName")}, 
            shuffle = @Key(group = {"itemId"})),@Joined.Term(source = SalesDetail.class, mappings = {@Joined.Mapping(
                source = "salesId", destination = "salesId"),@Joined.Mapping(source = "itemId", destination = "itemId"),
                @Joined.Mapping(source = "count", destination = "count")}, shuffle = @Key(group = {"itemId"}))})@
        ModelInputLocation(JoinedSalesInput.class)@ModelOutputLocation(JoinedSalesOutput.class)@PropertyOrder({"item_id"
            , "item_name", "sales_id", "count"}) public class JoinedSales implements DataModel<JoinedSales>, Writable {
    private final IntOption itemId = new IntOption();
    private final StringOption itemName = new StringOption();
    private final IntOption salesId = new IntOption();
    private final IntOption count = new IntOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.itemId.setNull();
        this.itemName.setNull();
        this.salesId.setNull();
        this.count.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(JoinedSales other) {
        this.itemId.copyFrom(other.itemId);
        this.itemName.copyFrom(other.itemName);
        this.salesId.copyFrom(other.salesId);
        this.count.copyFrom(other.count);
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
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=joined_sales");
        result.append(", itemId=");
        result.append(this.itemId);
        result.append(", itemName=");
        result.append(this.itemName);
        result.append(", salesId=");
        result.append(this.salesId);
        result.append(", count=");
        result.append(this.count);
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
        JoinedSales other = (JoinedSales) obj;
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
    @Override public void write(DataOutput out) throws IOException {
        itemId.write(out);
        itemName.write(out);
        salesId.write(out);
        count.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        itemId.readFields(in);
        itemName.readFields(in);
        salesId.readFields(in);
        count.readFields(in);
    }
}