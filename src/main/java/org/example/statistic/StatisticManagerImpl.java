package org.example.statistic;

import org.example.statistic.model.Statistic;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StatisticManagerImpl implements StatisticManager {

    @Override
    public Statistic findChanges(Map<String, String> yesterdayCondition,
                                  Map<String, String> todayCondition){

        Set<String> updatedUrls = new HashSet<>();
        Set<String> addedUrls = new HashSet<>();
        Set<String> removedUrls = new HashSet<>();

        todayCondition.forEach((key, value) -> {
            if(yesterdayCondition.containsKey(key) && !yesterdayCondition.get(key).equals(value)) {
                updatedUrls.add(key);
            }
            if(!yesterdayCondition.containsKey(key)) {
                addedUrls.add(key);
            }
        });

        yesterdayCondition.forEach((key, value) -> {
            if(!todayCondition.containsKey(key)) {
                removedUrls.add(key);
            }
        });

        return new Statistic(addedUrls, removedUrls, updatedUrls);
    }
}
