package com.nicky.vueskills.websocketserver.executors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicky.vueskills.dal.SkillContextMySQL;
import com.nicky.vueskills.models.Skill;
import com.nicky.vueskills.models.SkillCollection;
import com.nicky.vueskills.models.User;
import com.nicky.vueskills.websocketserver.ActionType;
import com.nicky.vueskills.websocketserver.Collection.UserCollection;
import com.nicky.vueskills.websocketserver.WsReturnMessage;
import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;
import java.io.IOException;

public class SkillExecutor implements IExecutor
{
    private SkillContextMySQL skillContextMySQL = new SkillContextMySQL();

    private ActionType actionType;
    private JSONObject message;
    private Session session;

    private Skill skill;
    private SkillCollection skillCollection;
    private WsReturnMessage wsReturnMessage = new WsReturnMessage();



    public SkillExecutor(ActionType actionType, JSONObject message, Session session)
    {
        this.actionType = actionType;
        this.message = message;
        this.session = session;
    }



    @Override
    public void Execute(ActionType actionType, JSONObject message, Session session) throws IOException
    {
        GsonBuilder gs = new GsonBuilder();
        gs.serializeNulls();
        Gson gson = gs.create();

        switch (actionType)
        {
            case Add:
                skill = gson.fromJson(message.getJSONObject("Skill").toString(), Skill.class);
                skillContextMySQL.AddSkill(skill);
                break;
            case Delete:
                skill = gson.fromJson(message.getJSONObject("Skill").toString(), Skill.class);
                skillContextMySQL.DeleteSkill(skill);
                break;
            case GetById:
                skill = gson.fromJson(message.getJSONObject("Skill").toString(), Skill.class);
                skillContextMySQL.GetSkillById(skill.getId());
                break;
            default:
                break;
        }

        skillCollection = skillContextMySQL.GetSkills();
        wsReturnMessage.setAction("Get");
        wsReturnMessage.setContent(skillCollection);

        for (User user : UserCollection.getConnectedUsers())
        {
            user.getSession().getRemote().sendString(gson.toJson(wsReturnMessage));
        }
    }

    @Override
    public void run()
    {
        try
        {
            Execute(actionType, message, session);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
