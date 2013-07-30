package org.pi4j.model;

import java.util.List;

public class ActorTopic extends PeerIndex {

	private List<Topic>topics;
	private List<Topic>benchmark_topics;

	public List<Topic> getBenchmark_topics() {
		return benchmark_topics;
	}

	public void setBenchmark_topics(List<Topic> benchmark_topics) {
		this.benchmark_topics = benchmark_topics;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
}
