package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void equals_true_same_object() {
        assert(team.equals(team));
    }

    @Test
    public void equals_false_different_class() {
        assert(!team.equals(team.name));
    }

    @Test
    public void equals_both_name_members() {
        // Both equal
        Team team_a = new Team("test-team");
        Team team_b = new Team("test-team");
        team_a.addMember("test-member1");
        team_a.addMember("test-member2");
        team_b.addMember("test-member1");
        team_b.addMember("test-member2");
        assert(team_a.equals(team_b));

        // Member different only
        team_a.addMember("test-member3");
        team_b.addMember("test-member4");
        assert(!team_a.equals(team_b));

        // Name different only
        Team team_c = new Team("test-team-c");
        Team team_d = new Team("test-team-d");
        team_c.addMember("test-member1");
        team_c.addMember("test-member2");
        team_d.addMember("test-member1");
        team_d.addMember("test-member2");
        assert(!team_c.equals(team_d));

        // Both different
        team_c.addMember("test-member3");
        team_d.addMember("test-member4");
        assert(!team_c.equals(team_d));
    }

    @Test
    public void hashcode_equals_identical_team() {
        Team team_a = new Team("test-team");
        Team team_b = new Team("test-team");
        team_a.addMember("test-member1");
        team_a.addMember("test-member2");
        team_b.addMember("test-member1");
        team_b.addMember("test-member2");
        assertEquals(team_a.hashCode(), team_b.hashCode());
    }

    @Test
    public void hashcode_uses_or() {
        assertEquals(team.hashCode(), -1226298695);   
    }
}
