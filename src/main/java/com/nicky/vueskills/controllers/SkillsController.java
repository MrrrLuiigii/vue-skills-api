package com.nicky.vueskills.controllers;

import com.nicky.vueskills.dal.SkillContextMySQL;
import com.nicky.vueskills.models.Skill;
import com.nicky.vueskills.models.SkillCollection;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/public/skills")
public class SkillsController
{
    private SkillContextMySQL skillContextMySQL = new SkillContextMySQL();

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Skill AddSkill(@RequestBody Skill skill)
    {
        return skillContextMySQL.AddSkill(skill);
    }

    @PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public boolean DeleteSkill(@RequestBody Skill skill)
    {
        return skillContextMySQL.DeleteSkill(skill);
    }

    @GetMapping(value = "/get")
    public SkillCollection GetSkills()
    {
        return skillContextMySQL.GetSkills();
    }

    @GetMapping(value = "/get/{id}")
    public Skill GetSkillsById(@PathVariable("id") int id)
    {
        return skillContextMySQL.GetSkillById(id);
    }
}
