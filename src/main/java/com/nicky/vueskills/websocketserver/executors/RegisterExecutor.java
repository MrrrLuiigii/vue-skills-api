package com.nicky.vueskills.websocketserver.executors;

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

    private Gson gson = new Gson();

    @Override
    public void Execute(ActionType actionType, JSONObject message, Session session)
    {
//        String json = message.getJSONObject("Content").toString();
        User user = gson.fromJson(message.toString(), User.class);
        user.setSession(session);

        if(UserCollection.CheckNotRegistered(user))
        {
            UserCollection.getConnectedUsers().add(user);
            System.out.println(UserCollection.getConnectedUsers().size());
        }
    }

    @Override
    public void run()
    {
        Execute(actionType, message, session);
    }
}
