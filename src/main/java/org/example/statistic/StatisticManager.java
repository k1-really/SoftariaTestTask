package org.example.statistic;

import org.example.statistic.model.Statistic;

import java.util.Map;

public interface StatisticManager {
    Statistic getStatistics(Map<String,String> yesterdayCondition, Map<String,String> todayCondition);
}
