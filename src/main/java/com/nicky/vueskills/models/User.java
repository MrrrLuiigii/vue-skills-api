package com.nicky.vueskills.models;

import org.eclipse.jetty.websocket.api.Session;

public class User
{
    private int id;
    private String name;
    private String email;
    private Session session;


    public User(){}

    public User(int id, String name, String email, Session session)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.session = session;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Session getSession()
    {
        return session;
    }

    public void setSession(Session session)
    {
        this.session = session;
    }
}
