package com.code.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;


/**
 * 教程
 * https://blog.csdn.net/weixin_43006131/article/details/103092166
 */
public class MaxWrod extends Configured implements Tool {
    public static class MaxMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
        private Text outkey = new Text();
        private DoubleWritable outval = new DoubleWritable();
        private Double maxval = 0D;
        private String maxkey = "";
        String[] star = null;

        @Override
        protected void map(LongWritable key, Text value,
                           Mapper<LongWritable, Text, Text, DoubleWritable>.Context context)
                throws IOException, InterruptedException {
            // 数据 T2018-01-01 001616528 236701 强力VC银翘片 6.0 82.8 69.0
            // 按照\t分割
            star = value.toString().split("\t");
            // 每行正确的数据数组的长度为7 并且部位null
            if (star.length == 7 && null != star) {
                // maxkey 如果小于数组第六为也就是实收金额 那么就maxval就等于这个数
                if (maxval < Double.parseDouble(star[6])) {
                    maxval = Double.parseDouble(star[6]);
                    // 这时候maxkey就等于数组的第三位也就是药品名称
                    maxkey = star[3];
                }
            }

        }

        @Override
        protected void cleanup(Mapper<LongWritable, Text, Text, DoubleWritable>.Context context)
                throws IOException, InterruptedException {
            // 这里为什么要用cleanup，因为cleanup只执行一次，而且是最后一次执行。因为要释放资源
            // 输出最后最大值
            outkey.set(maxkey);
            outval.set(maxval);
            context.write(outkey, outval);

        }
    }

    public static class MaxReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
        private Text outkey = new Text();
        private DoubleWritable outval = new DoubleWritable();
        private Double maxval = 0D;
        private String maxkey = "";

        @Override
        protected void reduce(Text key, Iterable<DoubleWritable> values,
                              Reducer<Text, DoubleWritable, Text, DoubleWritable>.Context context)
                throws IOException, InterruptedException {
            // 迭代器遍历所有的实收金额
            DoubleWritable value = values.iterator().next();
            // 最后进行判断 将多个map的最大值进行比较、
            if (maxval < value.get()) {
                maxval = value.get();
                maxkey = key.toString();
            }

        }

        @Override
        protected void cleanup(Reducer<Text, DoubleWritable, Text, DoubleWritable>.Context context)
                throws IOException, InterruptedException {
            // TODO Auto-generated method stub
            outkey.set(maxkey);
            outval.set(maxval);
            context.write(outkey, outval);

        }
    }

    @Override
    public int run(String[] args) throws Exception {
        //1 获取Job
        Configuration conf = new Configuration();
        conf.set("fs.default.name", "hdfs://" + HadoopUtils.Hadoop_IP + ":9000", "root");
        conf.set("yarn.resoucemanager.hostname", "hadoop2313");
        Job job = Job.getInstance(conf);
        job.setJarByClass(MaxWrod.class);
        // map reduce类
        job.setMapperClass(MaxMapper.class);
        job.setReducerClass(MaxReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(DoubleWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        // 设置文件路径
        Path in = new Path("/flow/input2");
        Path out = new Path("/flow/output2");

        //Path in = new Path(args[0]);
        //Path out = new Path(args[1]);
        // 设置hdfs操作对象
        FileSystem fs = FileSystem.get(conf);
        // 绑定文件输出输入目录
        FileInputFormat.addInputPath(job, in);
        FileOutputFormat.setOutputPath(job, out);
        // 自动删除
        if (fs.exists(out)) {
            fs.delete(out, true);
            // 提示
            System.out.println(job.getJobName() + "'s Path Output is deleted");
        }
        // 执行
        boolean con = job.waitForCompletion(true);
        if (con) {
            System.out.println("ok");
        } else {
            System.out.println("file");
        }
        // FileInputFormat.addInputPath(job, path);
        return 0;
    }

    public int runBackup(String[] args) throws Exception {
        //1 获取Job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setJarByClass(MaxWrod.class);
        // map reduce类
        job.setMapperClass(MaxMapper.class);
        job.setReducerClass(MaxReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(DoubleWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        // 设置文件路径
        Path in = new Path("E:\\hadooptest\\input\\input2");
        Path out = new Path("E:\\hadooptest222\\output4444\\input1278987833555559");

        //Path in = new Path(args[0]);
        //Path out = new Path(args[1]);
        // 设置hdfs操作对象
        FileSystem fs = FileSystem.get(conf);
        // 绑定文件输出输入目录
        FileInputFormat.addInputPath(job, in);
        FileOutputFormat.setOutputPath(job, out);
        // 自动删除
        if (fs.exists(out)) {
            fs.delete(out, true);
            // 提示
            System.out.println(job.getJobName() + "'s Path Output is deleted");
        }
        // 执行
        boolean con = job.waitForCompletion(true);
        if (con) {
            System.out.println("ok");
        } else {
            System.out.println("file");
        }
        // FileInputFormat.addInputPath(job, path);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        System.exit(ToolRunner.run(new MaxWrod(), args));
    }
}
