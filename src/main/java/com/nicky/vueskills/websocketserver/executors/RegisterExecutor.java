package com.nicky.vueskills.websocketserver.executors;

import com.nicky.vueskills.websocketserver.Collection.UserCollection;
import com.nicky.vueskills.models.User;
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
        JSONObject content = message.getJSONObject("Content");
        String name = content.getString("name");

        User user = new User();
        user.setName(name);
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
