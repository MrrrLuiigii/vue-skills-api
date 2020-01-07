package com.nicky.vueskills.websocketserver;

import com.nicky.vueskills.websocketserver.executors.RegisterExecutor;
import com.nicky.vueskills.websocketserver.executors.SkillExecutor;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageHandler
{
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void handleMessage(Session session, JSONObject message)
    {
        switch (message.getString("Action"))
        {
            case "Add":
                executorService.submit(new SkillExecutor(ActionType.Add, message, session));
                break;
            case "Delete":
                executorService.submit(new SkillExecutor(ActionType.Delete, message, session));
                break;
            case "Get":
                executorService.submit(new SkillExecutor(ActionType.Get, message, session));
                break;
            case "GetById":
                executorService.submit(new SkillExecutor(ActionType.GetById, message, session));
                break;
            case "Register":
                executorService.submit(new RegisterExecutor(null, message, session));
                break;
        }

        System.out.println(message);
    }
}
