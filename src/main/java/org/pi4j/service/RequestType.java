package org.pi4j.service;

/**
 *
 */
public enum RequestType {
	
    actorBasic("actor/basic/?"),
    actorExtended("actor/extended/?"),
    actorTopic("actor/topic/?"),
    actorGraph("actor/graph/?");

    private String path;

    private RequestType(String path) {
        this.path = path;
    }

    public String getPathByPeerIndexId(String peerindexId) {
        return path+"peerindex_id="+peerindexId;
    }
    
    public String getPathByTwitterId(Long twitterId) {
        return path+"twitter_id="+twitterId;
    }
    
    public String getPathByScreenName(String screenName) {
        return path+"twitter_screen_name="+screenName;
    }

}
