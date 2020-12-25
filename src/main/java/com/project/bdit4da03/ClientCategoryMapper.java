package com.project.bdit4da03;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ClientCategoryMapper extends Mapper<Object, Text, ClientCategory, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text id = new Text();
    private IntWritable simCount = new IntWritable();
    private IntWritable deviceType = new IntWritable();
    private IntWritable osCategory = new IntWritable();
    private IntWritable manufactureCategory = new IntWritable();
    private ClientCategory clientCategory = new ClientCategory();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split(",");

//        System.out.printf("Words[0] - %s, Words[1] - %s, Words[2] - %s, length - %d", words[0], words[1], words[2], words.length);

        id.set(words[0]);
        simCount.set(Integer.parseInt(words[4]));
        deviceType.set(Integer.parseInt(words[1]));
        osCategory.set(Integer.parseInt(words[3]));
        manufactureCategory.set(Integer.parseInt(words[2]));

        clientCategory.set(id, simCount, deviceType, osCategory, manufactureCategory);

        context.write(clientCategory, one);
    }
}