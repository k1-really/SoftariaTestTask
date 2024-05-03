package org.example.letter;

import org.example.Initials;
import org.example.statistic.model.Statistic;

import java.util.Set;

public class LetterManagerImpl implements LetterManager {

    @Override
    public String createLetter(Initials initials, Statistic statistic) {
        String intro = "Здравствуйте, дорогой(ая) " + initials.getName() + " " + initials.getPatronymic()+"!"+"\n";
        String outro = "С уважением,\n" +
                "автоматизированная система\n" +
                "мониторинга.";
        if(convertToString(statistic.getRemoved()).isEmpty()
                && convertToString(statistic.getChanged()).isEmpty()
                && convertToString(statistic.getAdded()).isEmpty()){
            String nothingChanged = "Изменений не произошло!\n";
            return intro+nothingChanged+outro;
        }
        else{
            String changed = "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n";
            String removedChanges = "Исчезли следующие страницы:\n" + convertToString(statistic.getRemoved()) + "\n";
            String addedChanges = "Появились следующие новые страницы:\n" + convertToString(statistic.getAdded()) + "\n";
            String updatedChanges = "Изменились следующие страницы:\n" + convertToString(statistic.getChanged()) + "\n";
            return intro+ changed + removedChanges + addedChanges + updatedChanges + outro;
        }
    }

    private String convertToString(Set<String> urls){
        StringBuilder sb = new StringBuilder();
        urls.forEach((url) -> {sb.append(url).append("\n");});
        return sb.toString();
    }
}
