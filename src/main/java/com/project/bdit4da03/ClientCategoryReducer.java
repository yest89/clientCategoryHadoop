package com.project.bdit4da03;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Arrays;

public class ClientCategoryReducer extends Reducer<ClientCategory, IntWritable, Text, IntWritable> {

    private IntWritable result = new IntWritable();

    @Override
    protected void reduce(ClientCategory key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int simCount = defineSimCategory(key);
        int deviceType = defineDeviceType(key);
        int osCategory = defineOsCategory(key);
        int manufacturerCategory = defineManufacturerCategory(key);

        MusicCategoryProvider musicCategoryProvider = new MusicCategoryProvider();
        int musicCategory = musicCategoryProvider.provideMusicCategory(simCount, deviceType, osCategory, manufacturerCategory);
        result.set(musicCategory);

        context.write(key.getId(), result);
    }

    private int defineManufacturerCategory(ClientCategory key) {
        if (!Arrays.asList(315, 1514, 626, 404, 973, 728, 812, 592, 896, 745, 69, 1756, 1057)
                .contains(key.getManufacturerCategory())) {
            return 0;
        }
        return key.getManufacturerCategory();
    }

    private int defineOsCategory(ClientCategory key) {
        if (!Arrays.asList(1, 3, 27, 28).contains(key.getOsCategory())) {
            return 0;
        }
        return key.getOsCategory();
    }

    private int defineDeviceType(ClientCategory key) {
        if (!Arrays.asList(1, 4, 7, 8).contains(key.getDeviceType())) {
            return 0;
        }
        return key.getDeviceType();
    }

    private int defineSimCategory(ClientCategory key) {
        if (!Arrays.asList(1, 2).contains(key.getSimCount())) {
            if (key.getSimCount() > 2) {
                return 2;
            } else {
                return 0;
            }
        }
        return key.getSimCount();
    }
}