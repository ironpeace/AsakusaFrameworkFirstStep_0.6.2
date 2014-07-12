package com.example.batch;

import com.asakusafw.vocabulary.batch.Batch;
import com.asakusafw.vocabulary.batch.BatchDescription;
import com.example.jobflow.MainJobFlow;

/**
 * DemoBatch
 */
@Batch(name = "DemoBatch")
public class DemoBatch extends BatchDescription {
	@Override
	public void describe() {
		// MainJobFlow	MainJobFlow
		run(MainJobFlow.class).soon();
	}
}
