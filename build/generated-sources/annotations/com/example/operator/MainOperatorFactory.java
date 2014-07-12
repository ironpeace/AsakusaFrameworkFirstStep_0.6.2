package com.example.operator;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowBoundary;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.flow.graph.ShuffleKey;
import com.asakusafw.vocabulary.operator.KeyInfo;
import com.asakusafw.vocabulary.operator.MasterJoin;
import com.asakusafw.vocabulary.operator.OperatorFactory;
import com.asakusafw.vocabulary.operator.OperatorInfo;
import com.asakusafw.vocabulary.operator.Update;
import com.example.modelgen.dmdl.model.ItemMaster;
import com.example.modelgen.dmdl.model.OutputSales;
import com.example.modelgen.dmdl.model.SalesDetail;
import java.util.Arrays;
import javax.annotation.Generated;
/**
 * {@link MainOperator}?????????????????
 * @see MainOperator
 */
@Generated("OperatorFactoryClassGenerator:0.0.1")@OperatorFactory(MainOperator.class) public class MainOperatorFactory {
    /**
     * ?????
     */
    public static final class Updated implements Operator {
        private final FlowElementResolver $;
        /**
         * ??
         */
        public final Source<OutputSales> out;
        Updated(Source<OutputSales> in) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(Update.class);
            builder.declare(MainOperator.class, MainOperatorImpl.class, "updated");
            builder.declareParameter(OutputSales.class);
            builder.addInput("in", in);
            builder.addOutput("out", in);
            builder.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder.toResolver();
            this.$.resolveInput("in", in);
            this.out = this.$.resolveOutput("out");
        }
        /**
         * ??????????????
         * @param newName ??????
         * @return ??????????? (this)
         * @throws IllegalArgumentException ???{@code null}????????
         */
        public MainOperatorFactory.Updated as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * ?????
     * @param in   ??
     * @return ?????????????
     * @see MainOperator#updated(OutputSales)
     */
    @OperatorInfo(kind = Update.class, input = {@OperatorInfo.Input(name = "in", type = OutputSales.class, position = 0)
            }, output = {@OperatorInfo.Output(name = "out", type = OutputSales.class)}, parameter = {}) public 
            MainOperatorFactory.Updated updated(Source<OutputSales> in) {
        return new MainOperatorFactory.Updated(in);
    }
    /**
     * ?????????
     */
    public static final class JoinedSales implements Operator {
        private final FlowElementResolver $;
        /**
         *   ???
         */
        public final Source<com.example.modelgen.dmdl.model.JoinedSales> joined;
        /**
         * ??????????
         */
        public final Source<SalesDetail> missed;
        JoinedSales(Source<ItemMaster> master, Source<SalesDetail> tx) {
            OperatorDescription.Builder builder0 = new OperatorDescription.Builder(MasterJoin.class);
            builder0.declare(MainOperator.class, MainOperatorImpl.class, "joinedSales");
            builder0.declareParameter(ItemMaster.class);
            builder0.declareParameter(SalesDetail.class);
            builder0.addInput("master", master, new ShuffleKey(Arrays.asList(new String[]{"itemId"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addInput("tx", tx, new ShuffleKey(Arrays.asList(new String[]{"itemId"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addOutput("joined", com.example.modelgen.dmdl.model.JoinedSales.class);
            builder0.addOutput("missed", tx);
            builder0.addAttribute(FlowBoundary.SHUFFLE);
            builder0.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder0.toResolver();
            this.$.resolveInput("master", master);
            this.$.resolveInput("tx", tx);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * ??????????????
         * @param newName0 ??????
         * @return ??????????? (this)
         * @throws IllegalArgumentException ???{@code null}????????
         */
        public MainOperatorFactory.JoinedSales as(String newName0) {
            this.$.setName(newName0);
            return this;
        }
    }
    /**
     * ?????????
     * @param master   ????
     * @param tx   ????????
     * @return ?????????????
     * @see MainOperator#joinedSales(ItemMaster, SalesDetail)
     */
    @OperatorInfo(kind = MasterJoin.class, input = {@OperatorInfo.Input(name = "master", type = ItemMaster.class, 
                position = 0),@OperatorInfo.Input(name = "tx", type = SalesDetail.class, position = 1)}, output = {@
                OperatorInfo.Output(name = "joined", type = com.example.modelgen.dmdl.model.JoinedSales.class),@
                OperatorInfo.Output(name = "missed", type = SalesDetail.class)}, parameter = {}) public 
            MainOperatorFactory.JoinedSales joinedSales(@KeyInfo(group = {@KeyInfo.Group(expression = "itemId")}, order 
            = {}) Source<ItemMaster> master,@KeyInfo(group = {@KeyInfo.Group(expression = "itemId")}, order = {}) Source
            <SalesDetail> tx) {
        return new MainOperatorFactory.JoinedSales(master, tx);
    }
}