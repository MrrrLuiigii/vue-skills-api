package com.nicky.vueskills.websocketserver;

public class WsReturnMessage
{
    private Object Content;
    private String Action;



    public WsReturnMessage(){}



    public Object getContent()
    {
        return Content;
    }

    public void setContent(Object content)
    {
        this.Content = content;
    }

    public String getAction()
    {
        return Action;
    }

    public void setAction(String action)
    {
        this.Action = action;
    }
}
