package com.project.bdit4da03;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class ClientCategory implements WritableComparable<ClientCategory> {
    private Text id;
    private IntWritable simCount;
    private IntWritable deviceType;
    private IntWritable osCategory;
    private IntWritable manufacturerCategory;

    public ClientCategory() {
        this.id = new Text();
        this.simCount = new IntWritable();
        this.deviceType = new IntWritable();
        this.osCategory = new IntWritable();
        this.manufacturerCategory = new IntWritable();
    }

    public ClientCategory(
            Text id,
            IntWritable simCount,
            IntWritable deviceType,
            IntWritable osCategory,
            IntWritable manufacturerCategory) {
        this.id = id;
        this.simCount = simCount;
        this.deviceType = deviceType;
        this.osCategory = osCategory;
        this.manufacturerCategory = manufacturerCategory;
    }

    public void set(Text id,
                    IntWritable simCount,
                    IntWritable deviceType,
                    IntWritable osCategory,
                    IntWritable manufacturerCategory) {
        this.id = id;
        this.simCount = simCount;
        this.deviceType = deviceType;
        this.osCategory = osCategory;
        this.manufacturerCategory = manufacturerCategory;
    }

    public Text getId() {
        return id;
    }

    public Integer getSimCount() {
        return simCount.get();
    }

    public Integer getDeviceType() {
        return deviceType.get();
    }

    public Integer getOsCategory() {
        return osCategory.get();
    }

    public Integer getManufacturerCategory() {
        return manufacturerCategory.get();
    }

    @Override
    //overriding default readFields method.
    //It de-serializes the byte stream data
    public void readFields(DataInput in) throws IOException {
        id.readFields(in);
        simCount.readFields(in);
        deviceType.readFields(in);
        osCategory.readFields(in);
        manufacturerCategory.readFields(in);
    }

    @Override
    //It serializes object data into byte stream data
    public void write(DataOutput out) throws IOException {
        id.write(out);
        simCount.write(out);
        deviceType.write(out);
        osCategory.write(out);
        manufacturerCategory.write(out);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientCategory that = (ClientCategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(simCount, that.simCount) &&
                Objects.equals(deviceType, that.deviceType) &&
                Objects.equals(osCategory, that.osCategory) &&
                Objects.equals(manufacturerCategory, that.manufacturerCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, simCount, deviceType, osCategory, manufacturerCategory);
    }

    @Override
    public int compareTo(ClientCategory o) {
        if (id.compareTo(o.id) == 0) {
            return (simCount.compareTo(o.simCount));
        } else return (id.compareTo(o.id));
    }
}
