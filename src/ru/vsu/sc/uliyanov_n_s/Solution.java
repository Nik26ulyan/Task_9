package ru.vsu.sc.uliyanov_n_s;

import java.util.*;

public class Solution {
    public List<Integer> createRightList(List<Integer> list) {
        removeDuplicateFromList(list);
        sort(list);
        return findSeqInList(list);
    }

    private void removeDuplicateFromList(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
    }

    private void sort(List<Integer> list) {
        boolean sorted = false;
        int temp;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    temp = list.get(i);
                    list.add(i, list.get(i + 1));
                    list.add(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }

    private List<Integer> findSeqInList(List<Integer> list) {
        int tmpLength = 0;
        int maxLength = 0;
        int firstMemberIndex = -1;
        boolean recSeqVal = false;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 == list.get(i + 1)) {
                tmpLength++;
                recSeqVal = true;
            } else if (tmpLength >= maxLength) {
                maxLength = tmpLength;
                firstMemberIndex = i - tmpLength;
                tmpLength = 0;
                recSeqVal = false;
            }
        }

        if (maxLength - firstMemberIndex < 1) {
            return null;
        } else if (recSeqVal && tmpLength >= maxLength + 1) {
            firstMemberIndex = list.size() - tmpLength - 1;
            maxLength = tmpLength + 1;
        }

        return getSeqFromList(list, firstMemberIndex, maxLength);
    }

    private List<Integer> getSeqFromList(List<Integer> list, int firstMember, int seqLength) {
        List<Integer> newList = new ArrayList<>();
        int temp = 0;
        int flag = 1;

        if (seqLength == list.size())
            flag = 0;

        for (int i = firstMember; i < firstMember + seqLength + flag; i++) {
            newList.add(temp, list.get(i));
            temp++;
        }

        return newList;
    }
}
