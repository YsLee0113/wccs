package com.code.utils;


import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;

public class SumValue {

    public static class SumValueMapper extends Mapper<LongWritable, Text, IntWritable, NullWritable> {

        private int sumValue = 0;

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            if (StringUtils.isBlank(value.toString())) {
                System.out.println("空白行");
                return;
            }

            int v = Integer.parseInt(value.toString().trim());

            sumValue = sumValue + v;
        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            context.write(new IntWritable(sumValue), NullWritable.get());
        }
    }


    public static class SumValueReducer extends Reducer<IntWritable, NullWritable, IntWritable, NullWritable> {

        private int sumValue = 0;

        @Override
        protected void reduce(IntWritable key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {

            int v = key.get();
            sumValue = sumValue + v;

        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            context.write(new IntWritable(sumValue), NullWritable.get());
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        String uri = "hdfs://" + HadoopUtils.Hadoop_IP + ":9000";
        String input = "/flow/input";
        String output = "/flow/output999";
        Configuration conf = new Configuration();
        if (System.getProperty("os.name").toLowerCase().contains("win"))
            conf.set("mapreduce.app-submission.cross-platform", "true");

        FileSystem fileSystem = FileSystem.get(URI.create(uri), conf);
        Path path = new Path(output);
        fileSystem.delete(path, true);

        Job job = new Job(conf, "SumValue");
        job.setJarByClass(SumValue.class);
        job.setMapperClass(SumValueMapper.class);
        job.setReducerClass(SumValueReducer.class);
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(NullWritable.class);
        FileInputFormat.addInputPaths(job, uri + input);
        FileOutputFormat.setOutputPath(job, new Path(uri + output));


        boolean ret = job.waitForCompletion(true);
        System.out.println(job.getJobName() + "-----" + ret);
    }
}
