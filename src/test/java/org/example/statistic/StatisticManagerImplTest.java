package org.example.statistic;

import org.example.statistic.model.Statistic;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StatisticManagerImplTest {

    Map<String, String> yesterdayCondition;
    Map<String, String> todayCondition;
    StatisticManagerImpl manager;
    @Before
    public void setUp(){
        this.yesterdayCondition = new HashMap<>();
        this.todayCondition = new HashMap<>();
        this.manager=new StatisticManagerImpl();
    }

    @Test
    public void checkIfAddDiffWorks(){
        yesterdayCondition.put("/api","<HTML code>");
        todayCondition.put("/api1","<HTML code>");
        Statistic statistic = manager.getStatistics(yesterdayCondition,todayCondition);
        String joined = String.join(",",statistic.getAdded());
        assertEquals("/api1", joined);
    }

    @Test
    public void checkIfChangeDiffWorks(){
        yesterdayCondition.put("/api","<HTML code>");
        todayCondition.put("/api","<HTML code123>");
        Statistic statistic = manager.getStatistics(yesterdayCondition,todayCondition);
        String joined = String.join(",",statistic.getChanged());
        assertEquals("/api", joined);
    }

    @Test
    public void checkIfRemoveDiffWorks(){
        yesterdayCondition.put("/api","<HTML code>");
        todayCondition.put("/api1","<HTML code>");
        Statistic statistic = manager.getStatistics(yesterdayCondition,todayCondition);
        String joined = String.join(",",statistic.getRemoved());
        assertEquals("/api", joined);
    }
}