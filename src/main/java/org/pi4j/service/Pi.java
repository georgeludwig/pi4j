package org.pi4j.service;

import org.pi4j.exception.PiException;
import org.pi4j.model.ActorBasic;
import org.pi4j.model.ActorExtended;
import org.pi4j.model.ActorGraph;
import org.pi4j.model.ActorTopic;

/**
 * 
 */
public interface Pi {

	 public ActorBasic getActorBasic(PiParam piParam) throws PiException;

	 public ActorExtended getActorExtended(PiParam piParam) throws PiException;
	 
	 public ActorTopic getActorTopic(PiParam piParam) throws PiException;
	 
	 public ActorGraph getActorGraph(PiParam piParam) throws PiException;
	 
	 
}