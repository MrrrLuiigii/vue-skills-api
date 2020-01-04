package com.nicky.vueskills.dal;

import com.nicky.vueskills.models.Skill;
import com.nicky.vueskills.models.SkillCollection;
import java.sql.*;

public class SkillContextMySQL
{
    private DatabaseConnection dbc = new DatabaseConnection();



    public Skill AddSkill(Skill skill)
    {
        try (Connection conn = dbc.getDatabaseConnection())
        {
            String query = "{call AddSkill(?)};";

            try (CallableStatement cst = conn.prepareCall(query))
            {
                cst.setString(1, skill.getName());

                try (ResultSet rs = cst.executeQuery())
                {
                    while (rs.next())
                    {
                        skill.setId(rs.getInt("id"));
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return skill;
    }

    public boolean DeleteSkill(Skill skill)
    {
        try (Connection conn = dbc.getDatabaseConnection())
        {
            String query = "delete from `skill` where `id` = ?;";

            try (PreparedStatement pst = conn.prepareStatement(query))
            {
                pst.setInt(1, skill.getId());
                pst.executeUpdate();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public Skill GetSkillById(int id)
    {
        Skill skill = new Skill();

        try (Connection conn = dbc.getDatabaseConnection())
        {
            String query = "select `id`, `name` " +
                    "from `skill` " +
                    "where `id` = ?;";

            try (PreparedStatement pst = conn.prepareStatement(query))
            {
                pst.setInt(1, id);

                try (ResultSet rs = pst.executeQuery())
                {
                    while (rs.next())
                    {
                        skill.setId(rs.getInt("id"));
                        skill.setName(rs.getString("name"));
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return skill;
    }

    public SkillCollection GetSkills()
    {
        SkillCollection skillCollection = new SkillCollection();

        try (Connection conn = dbc.getDatabaseConnection())
        {
            String query = "select `id`, `name` " +
                    "from `skill`;";

            try (Statement st = conn.createStatement())
            {
                try (ResultSet rs = st.executeQuery(query))
                {
                    while (rs.next())
                    {
                        Skill skill = new Skill();
                        skill.setId(rs.getInt("id"));
                        skill.setName(rs.getString("name"));
                        skillCollection.AddSkill(skill);
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return skillCollection;
    }
}
