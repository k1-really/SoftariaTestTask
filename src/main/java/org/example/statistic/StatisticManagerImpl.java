package org.example.statistic;

import org.example.statistic.model.Statistic;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StatisticManagerImpl implements StatisticManager {

    private Set<String> getRemovedUrls(Map<String, String> yesterdayCondition,
                                       Map<String, String> todayCondition) {
        Set<String> disappearedUrls = new HashSet<>();
        yesterdayCondition.forEach((key, value) -> {
            if(!todayCondition.containsKey(key)) {
                disappearedUrls.add(key);
            }
        });
        return disappearedUrls;
    }

    private Set<String> getAddedUrls(Map<String, String> yesterdayCondition,
                                     Map<String, String> todayCondition) {
        Set<String> addedUrls = new HashSet<>();
        todayCondition.forEach((key, value) -> {
            if(!yesterdayCondition.containsKey(key)) {
                addedUrls.add(key);
            }
        });
        return addedUrls;
    }

    private Set<String> getChangedUrls(Map<String, String> yesterdayCondition,
                                       Map<String, String> todayCondition) {
        Set<String> changedUrls = new HashSet<>();
        todayCondition.forEach((key, value) -> {
            if(yesterdayCondition.containsKey(key) && !yesterdayCondition.get(key).equals(value)) {
                changedUrls.add(key);
            }
        });
        return changedUrls;
    }

    @Override
    public Statistic getStatistics(Map<String, String> yesterdayCondition, Map<String, String> todayCondition){
        Set<String> addedUrls = getAddedUrls(yesterdayCondition,todayCondition);
        Set<String> removedUrls = getRemovedUrls(yesterdayCondition,todayCondition);
        Set<String> changedUrls = getChangedUrls(yesterdayCondition,todayCondition);
        return new Statistic(addedUrls, removedUrls, changedUrls);
    }
}
