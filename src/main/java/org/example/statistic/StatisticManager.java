package org.example.statistic;

import org.example.statistic.model.Statistic;

import java.util.Map;

public interface StatisticManager {
    Statistic findChanges(Map<String,String> yesterdayCondition, Map<String,String> todayCondition);
}
