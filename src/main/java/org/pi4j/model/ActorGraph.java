package org.pi4j.model;

import java.util.List;

public class ActorGraph extends PeerIndex {
	
	private List<Influential>influences;
	private List<Influential>influenced_by;
	
	public List<Influential> getInfluenced_by() {
		return influenced_by;
	}
	public void setInfluenced_by(List<Influential> influenced_by) {
		this.influenced_by = influenced_by;
	}
	public List<Influential> getInfluences() {
		return influences;
	}
	public void setInfluences(List<Influential> influences) {
		this.influences = influences;
	}

}
