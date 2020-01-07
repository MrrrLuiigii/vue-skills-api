package com.nicky.vueskills.websocketserver.Collection;

import com.nicky.vueskills.models.User;
import org.eclipse.jetty.websocket.api.Session;
import java.util.ArrayList;
import java.util.List;

public class UserCollection
{
    private static List<User> connectedUsers = new ArrayList<>();



    public static List<User> getConnectedUsers()
    {
        return connectedUsers;
    }

    public static void setConnectedUsers(List<User> connectedUsers)
    {
        UserCollection.connectedUsers = connectedUsers;
    }



    public static boolean CheckNotRegistered(User user)
    {
        for (User u : connectedUsers)
        {
            if(u.getName().equals(user.getName()))
            {
                return false;
            }
        }

        return true;
    }

    public static User getUserBySession(Session session)
    {
        for (User user : connectedUsers)
        {
            if (user.getSession() == session)
            {
                return user;
            }
        }

        return null;
    }

    public static void updateSession(User user, Session session)
    {
        for (User u : connectedUsers)
        {
            if (user.getName() == u.getName())
            {
                u.setSession(session);
            }
        }
    }
}
