package org.pi4j.service.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.pi4j.model.ActorGraph;
import org.pi4j.model.ActorTopic;
import org.pi4j.model.Influential;
import org.pi4j.model.Topic;
import org.pi4j.service.PiParam;


public class TestPiImpl {
	
	public static final String API_KEY="ryspmehfb862eg7t3ubhfecf"; // 6b prod api key!!

    private PiImpl pimpl = new PiImpl(API_KEY);
    private static String screenName="georgeludwig";
    private static String peerindex_id="87c1e7dd-e6e5-3b0a-b997-85f5bd5555e0";
    private static long twitter_id=12552352l;
    

    @Before
    public void setUp() throws Exception {
        pimpl.setApiKey(API_KEY);
    }

    @Test
    public void testGetActorBasic() throws Exception {
//    	PiParam piParam=new PiParam();
//    	piParam.twitter_screen_name=screenName;
//    	ActorBasic result = pimpl.getActorBasic(piParam);
//        Assert.assertTrue(result.getTwitter().getId()==twitter_id);
//        
//        piParam=new PiParam();
//    	piParam.peerindex_id=peerindex_id;
//    	result = pimpl.getActorBasic(piParam);
//        Assert.assertTrue(result.getTwitter().getId()==twitter_id);
//        
//        piParam=new PiParam();
//    	piParam.twitter_id=twitter_id;
//    	result = pimpl.getActorBasic(piParam);
//        Assert.assertTrue(result.getPeerindex_id().equals(peerindex_id));
    }
    
    @Test
    public void testGetActorExtended() throws Exception {
//    	PiParam piParam=new PiParam();
//    	piParam.twitter_screen_name=screenName;
//    	ActorBasic result = pimpl.getActorExtended(piParam);
//        Assert.assertTrue(result.getTwitter().getId()==twitter_id);
//        
//        piParam=new PiParam();
//    	piParam.peerindex_id=peerindex_id;
//    	result = pimpl.getActorExtended(piParam);
//        Assert.assertTrue(result.getTwitter().getId()==twitter_id);
//        
//        piParam=new PiParam();
//    	piParam.twitter_id=twitter_id;
//    	result = pimpl.getActorExtended(piParam);
//        Assert.assertTrue(result.getPeerindex_id().equals(peerindex_id));
    }
    
    @Test
    public void testGetActorTopic() throws Exception {
    	PiParam piParam=new PiParam();
    	piParam.twitter_screen_name=screenName;
    	ActorTopic result = pimpl.getActorTopic(piParam);
        Assert.assertTrue(result.getPeerindex_id().equals(peerindex_id));
        
        List<Topic>topicList=result.getTopics();
        
        piParam=new PiParam();
    	piParam.peerindex_id=peerindex_id;
    	result = pimpl.getActorTopic(piParam);
    	int a=result.getTopics().size();
    	int b=topicList.size();
//        Assert.assertTrue(result.getTopics().size()==topicList.size());
//        Assert.assertTrue(result.getTopics().get(0).equals(topicList.get(0)));
        
        piParam=new PiParam();
    	piParam.twitter_id=twitter_id;
    	result = pimpl.getActorTopic(piParam);   
//    	Assert.assertTrue(result.getTopics().size()==topicList.size());
//    	Assert.assertTrue(result.getTopics().get(0).equals(topicList.get(0)));
    	 
    }
    
    @Test
    public void testGetActorGraph() throws Exception {
    	
    	PiParam piParam=new PiParam();
    	piParam.twitter_screen_name=screenName;
    	ActorGraph result = pimpl.getActorGraph(piParam);
        Assert.assertTrue(result.getPeerindex_id().equals(peerindex_id));
        List<Influential>infBy=result.getInfluenced_by();
        List<Influential>inf=result.getInfluences();
        
        piParam.peerindex_id=peerindex_id;
    	result = pimpl.getActorGraph(piParam);
        Assert.assertTrue(result.getPeerindex_id().equals(peerindex_id));
        infBy=result.getInfluenced_by();
        inf=result.getInfluences();
        
        piParam.twitter_id=twitter_id;
    	result = pimpl.getActorGraph(piParam);
        Assert.assertTrue(result.getPeerindex_id().equals(peerindex_id));
        infBy=result.getInfluenced_by();
        inf=result.getInfluences();
        
    }
    
}
