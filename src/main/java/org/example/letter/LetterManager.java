package org.example.letter;

import org.example.Initials;
import org.example.statistic.model.Statistic;

public interface LetterManager {
    String createLetter(Initials initials, Statistic statistic);
}
