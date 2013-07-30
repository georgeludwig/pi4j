package org.pi4j.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.map.ObjectMapper;
import org.pi4j.exception.PiException;
import org.pi4j.model.ActorBasic;
import org.pi4j.model.ActorExtended;
import org.pi4j.model.ActorGraph;
import org.pi4j.model.ActorTopic;
import org.pi4j.service.Pi;
import org.pi4j.service.PiParam;
import org.pi4j.service.RequestType;

/**
 * A connection class that will retrieve a information
 * from PeerIndex.
 *
 */
public class PiImpl implements Pi {

    public static final String USERAGENT = "pi4j/1.0.0";

    private Logger logger = Logger.getLogger(getClass().getName());
    private ObjectMapper mapper = new ObjectMapper();
    
    /**
     * Empty constructor. You will need to set the API key before using.
     */
    public PiImpl() {
    }

    /**
     * Constructor with API Key.
     *
     * @param apiKey API Key for Pi
     */
    public PiImpl(String apiKey) {
        setApiKey(apiKey);
    }

    private String apiKey;

    /**
     * Sets the API Key
     *
     * @param apiKey API Key for Pi
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    private String rootUrl = "https://api.peerindex.com/1/";

    /**
     * Returns the root URL of the Pi API
     *
     * @return Root URL
     */
    public String getRootUrl() {
        return rootUrl;
    }

    /**
     * Sets the root URL of the Pi API. Changing root URL is allowed
     * in case Pi changes it, Klout4J is still usable until it gets updated.
     *
     * @param rootUrl Root URL
     */
    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    private int connectTimeout = -1;

    /**
     * Returns the connectiom timeout for accessing the Pi API. The default
     * is no timeout.
     *
     * @return Timeout
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Sets the connection timeout for accessing the Pi API.
     *
     * @param connectTimeout Timeout
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    private int readTimeout = -1;

    /**
     * Returns the read timeout for accessing the Pi API. The default is no
     * timeout.
     *
     * @return int
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * Sets the read timeout for accessing the Pi API.
     *
     * @param readTimeout Read Timeout
     */
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public ActorBasic getActorBasic(PiParam piParam) throws PiException {
    	InputStream is=null;
    	try {
	    	is = callJSON(getRequestString(RequestType.actorBasic, piParam));
	    	ActorBasic ret=mapper.readValue(is, ActorBasic.class);
	        return ret;
    	} catch(Exception e) {
    		throw new PiException("getActorBasic error",e);
    	} finally {
    		if(is!=null)
    			try {
    				is.close();
    			} catch(IOException ioe) {
    				 logger.log(Level.SEVERE,
                             "Failed to close HTTP InputStream", ioe);
    			}
    	}
    }

    public ActorExtended getActorExtended(PiParam piParam) throws PiException {
    	InputStream is=null;
    	try {
	    	is = callJSON(getRequestString(RequestType.actorExtended, piParam));
	    	ActorExtended ret=mapper.readValue(is, ActorExtended.class);
	        return ret;
    	} catch(Exception e) {
    		throw new PiException("getActorExtended error",e);
    	} finally {
    		if(is!=null)
    			try {
    				is.close();
    			} catch(IOException ioe) {
    				 logger.log(Level.SEVERE,
                             "Failed to close HTTP InputStream", ioe);
    			}
    	}
    }

    public ActorTopic getActorTopic(PiParam piParam) throws PiException {
    	InputStream is=null;
    	try {
	    	is = callJSON(getRequestString(RequestType.actorTopic, piParam));
	    	ActorTopic ret=mapper.readValue(is, ActorTopic.class);
	        return ret;
    	} catch(Exception e) {
    		throw new PiException("getActorTopic error",e);
    	} finally {
    		if(is!=null)
    			try {
    				is.close();
    			} catch(IOException ioe) {
    				 logger.log(Level.SEVERE,
                             "Failed to close HTTP InputStream", ioe);
    			}
    	}
    }

    public ActorGraph getActorGraph(PiParam piParam) throws PiException {
    	InputStream is=null;
    	try {
	    	is = callJSON(getRequestString(RequestType.actorGraph, piParam));
	    	ActorGraph ret=mapper.readValue(is, ActorGraph.class);
	        return ret;
    	} catch(Exception e) {
    		throw new PiException("getActorGraph error",e);
    	} finally {
    		if(is!=null)
    			try {
    				is.close();
    			} catch(IOException ioe) {
    				 logger.log(Level.SEVERE,
                             "Failed to close HTTP InputStream", ioe);
    			}
    	}
    }

    private InputStream callJSON(String request) throws PiException {
        URL url;
        try {
            url = new URL(request);
        } catch (java.net.MalformedURLException e) {
            throw new PiException("Failed to construct URL", e);
        }
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("Hitting URL: " + request);
        }
        HttpURLConnection conn;
        try {
            conn = getHttpURLConnection(url, "GET", null, false);
            if (conn.getResponseCode() != 200) {
                throw new PiException("Failed to get request \""
                        + request + "\", HTTP status: "
                        + conn.getResponseCode() + " "
                        + conn.getResponseMessage());
            }
        } catch (java.io.IOException e) {
            throw new PiException("Failed to open connection", e);
        }

        InputStream inputStream = null;
        try {
            inputStream = conn.getInputStream();
            return inputStream;
        } catch (Exception e) {
            throw new PiException("Failed to read/parse response", e);
        }
    }
    
    protected String getRequestString(RequestType requestType, PiParam piParam) throws PiException {
    	if(piParam.peerindex_id!=null)
    		return getRequestStringByPeerIndexId(requestType,piParam.peerindex_id);
    	if(piParam.twitter_screen_name!=null)
    		return getRequestStringByScreenName(requestType,piParam.twitter_screen_name);
    	if(piParam.twitter_id>0)
    		return getRequestStringByTwitterId(requestType,piParam.twitter_id);
    	throw new PiException("empty parameter");
    	
    }

    protected String getRequestStringByPeerIndexId(RequestType requestType, String id) {
        StringBuilder sb = new StringBuilder(rootUrl);
        String request = requestType.getPathByPeerIndexId(id);
        sb.append(request);
        sb.append("&api_key=").append(apiKey);
        return sb.toString();
    }

    protected String getRequestStringByTwitterId(RequestType requestType, Long id) {
        StringBuilder sb = new StringBuilder(rootUrl);
        String request = requestType.getPathByTwitterId(id);
        sb.append(request);
        sb.append("&api_key=").append(apiKey);
        return sb.toString();
    }
    
    protected String getRequestStringByScreenName(RequestType requestType, String id) {
		StringBuilder sb = new StringBuilder(rootUrl);
		String request = requestType.getPathByScreenName(id);
		sb.append(request);
		sb.append("&api_key=").append(apiKey);
		return sb.toString();
	}


    private HttpURLConnection getHttpURLConnection(URL url,
                                                   String requestMethod, Map<String, String> headers, boolean doOutput)
            throws java.io.IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if (connectTimeout != -1) {
            conn.setConnectTimeout(connectTimeout);
        }
        if (readTimeout != -1) {
            conn.setReadTimeout(readTimeout);
        }
        conn.setAllowUserInteraction(false);
        conn.setRequestMethod(requestMethod);
        conn.setDoInput(true);
        conn.setDoOutput(doOutput);
        conn.setRequestProperty("Connection", "close");
        conn.setRequestProperty("User-Agent", USERAGENT);
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                conn.setRequestProperty(header.getKey(), header.getValue());
            }
        }
        return conn;
    }
}
