package com.nicky.vueskills.websocketserver.executors;

import com.google.gson.GsonBuilder;
import com.nicky.vueskills.websocketserver.Collection.UserCollection;
import com.nicky.vueskills.models.User;
import com.google.gson.Gson;
import com.nicky.vueskills.websocketserver.ActionType;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

public class RegisterExecutor implements IExecutor
{
    private ActionType actionType;
    private JSONObject message;
    private Session session;



    public RegisterExecutor(ActionType actionType, JSONObject message, Session session)
    {
        this.actionType = actionType;
        this.message = message;
        this.session = session;
    }

    @Override
    public void Execute(ActionType actionType, JSONObject message, Session session)
    {
        GsonBuilder gs = new GsonBuilder();
        gs.serializeNulls();
        Gson gson = gs.create();

        User user = gson.fromJson(message.toString(), User.class);
        user.setSession(session);

        if(UserCollection.CheckNotRegistered(user))
        {
            UserCollection.getConnectedUsers().add(user);
        }
    }

    @Override
    public void run()
    {
        Execute(actionType, message, session);
    }
}
