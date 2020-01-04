package com.nicky.vueskills.websocketserver.executors;

import com.nicky.vueskills.websocketserver.ActionType;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

import java.io.IOException;

public interface IExecutor extends Runnable
{
    void Execute(ActionType actionType, JSONObject message, Session session) throws IOException;
}
