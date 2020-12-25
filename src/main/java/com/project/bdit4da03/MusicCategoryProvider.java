package com.project.bdit4da03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MusicCategoryProvider {

    private Set<Integer> matchedManufacturerCategories = new HashSet<>(Arrays.asList(626, 973));
    private Set<Integer> matchedDevTypeCategories = new HashSet<>(Arrays.asList(7, 8));
    private Set<Integer> matchedOsCategories = new HashSet<>(Arrays.asList(1, 28));

    private static final int LEVEL_0 = 0;
    private static final int LEVEL_1 = 1;
    private static final int LEVEL_2 = 2;
    private static final int LEVEL_3 = 3;

    public int provideMusicCategory(int simCount, int deviceType, int osCategory, int manufacturerCategory) {

        //TODO magic numbers =)
        if (osCategory == 27) {
            return LEVEL_0;
        }

        if (deviceType == 0) {
            return LEVEL_1;
        }

        if (deviceType == 1) {
            return LEVEL_2;
        }

        if (matchedManufacturerCategories.contains(manufacturerCategory)) {
            if (matchedDevTypeCategories.contains(deviceType)) {
                return LEVEL_3;
            } else {
                return LEVEL_2;
            }
        }

        if (simCount == 2) {
            if (deviceType == 4) {
                if (manufacturerCategory == 0) {
                    return LEVEL_2;
                }
                if (matchedOsCategories.contains(osCategory)) {
                    if (manufacturerCategory == 404) {
                        return LEVEL_1;
                    } else {
                        return LEVEL_2;
                    }
                }
            } else {
                return LEVEL_1;
            }

            if (Arrays.asList(404, 315).contains(manufacturerCategory)) {
                return LEVEL_3;
            } else {
                return LEVEL_2;
            }
        }

        if (deviceType == 7) {
            if (Arrays.asList(592, 745, 812, 1514, 1756).contains(manufacturerCategory)) {
                return LEVEL_2;
            } else {
                return LEVEL_3;
            }
        }

        if (osCategory == 3) {
            if (manufacturerCategory == 745) {
                return LEVEL_2;
            }
            else {
                return LEVEL_3;
            }
        }

        if (osCategory == 28) {
            return LEVEL_2;
        }

        if (simCount == 0) {
            return LEVEL_2;
        }

        return LEVEL_1;
    }
}
