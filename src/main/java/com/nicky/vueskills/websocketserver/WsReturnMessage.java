package com.nicky.vueskills.websocketserver;

public class WsReturnMessage
{
    private Object content;
    private String action;



    public WsReturnMessage(){}



    public Object getContent()
    {
        return content;
    }

    public void setContent(Object content)
    {
        this.content = content;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }
}
