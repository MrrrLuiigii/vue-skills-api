package com.nicky.vueskills.models;

import java.util.ArrayList;
import java.util.List;

public class SkillCollection
{
    private List<Skill> skills;

    public SkillCollection()
    {
        this.skills = new ArrayList<>();
    }

    public List<Skill> getSkills()
    {
        return skills;
    }

    public void AddSkill(Skill skill)
    {
        this.skills.add(skill);
    }
}
