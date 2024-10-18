package top_150_interview;
import java.util.*;

public class ZG_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mapNote = new HashMap<>();
        Map<Character, Integer> mapMagazine = new HashMap<>();
        int lenNote = ransomNote.length();
        int lenMagazine = magazine.length();

        Character c;
        for (int i = 0; i < lenNote; i++) {
            c = ransomNote.charAt(i);
            if (mapNote.containsKey(c)) {
                mapNote.put(c, mapNote.get(c)+1);
            } else {
                mapNote.put(c, 1);
            }
        }

        for (int i = 0; i < lenMagazine; i++) {
            c = magazine.charAt(i);
            if (mapMagazine.containsKey(c)) {
                mapMagazine.put(c, mapMagazine.get(c)+1);
            } else {
                mapMagazine.put(c, 1);
            }
        }

        Integer num;
        for (Map.Entry<Character, Integer> entry : mapNote.entrySet()) {
            c = entry.getKey();
            num = entry.getValue();

            if (!mapMagazine.containsKey(c)) {
                return false;
            } else {
                if (mapMagazine.get(c) < num) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canConstructV2(String ransomNote, String magazine) {
        Map<Character, Integer> mapMagazine = new HashMap<>();
        int lenNote = ransomNote.length();
        int lenMagazine = magazine.length();

        Character c;
        for (int i = 0; i < lenMagazine; i++) {
            c = magazine.charAt(i);
            if (mapMagazine.containsKey(c)) {
                mapMagazine.put(c, mapMagazine.get(c)+1);
            } else {
                mapMagazine.put(c, 1);
            }
        }

        Integer num;
        for (int i = 0; i < lenNote; i++) {
            c = ransomNote.charAt(i);
            if (!mapMagazine.containsKey(c)) {
                return false;
            } else {
                num = mapMagazine.get(c);
                if (num == 1) {
                    mapMagazine.remove(c);
                } else {
                    num--;
                    mapMagazine.put(c, num);
                }
            }
        }
        return true;
    }

    public boolean canConstructV3(String ransomNote, String magazine) {
        int lenNote = ransomNote.length();
        int lenMagazine = magazine.length();

        char c;
        int[] alphabet = new int[26];

        for (int i = 0; i < lenMagazine; i++) {
            alphabet[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < lenNote; i++) {
            c = ransomNote.charAt(i);
            if (alphabet[c - 'a'] == 0) {
                return false;
            } else {
                alphabet[c - 'a']--;
            }
        }
        return true;
    }
}
