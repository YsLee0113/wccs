package com.code.utils;

import com.code.entity.Scoreinfo;
import com.code.entity.Scoreinfo2;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * hadoop 工具类
 * <p>
 * 上传文件-----------upload(String ip,String srcPath,String desPath)
 * <p>
 * 下载文件-----------download(String ip,String srcPath,String desPath )
 * <p>
 * 遍历文件-----------list(String ip,String path)
 * <p>
 * 删除文件-----------delete(String ip,String path,boolean boStr)
 * <p>
 * 创建文件夹----------mkdir(String ip,String path)
 * <p>
 * 创建并写入文件-------write(String txt,String ip,String path)
 * <p>
 * 重命名文件----------rename(String ip,String path,String oldName,String newName)
 * <p>
 * 判断文件是否存在------exists(String ip,String pathAndName);
 * <p>
 * 查看文件在集群中的位置--fileLoc(String ip,String filePath)
 * <p>
 * 文件最后一次修改时间---getTime(String ip,String path)
 * <p>
 * 读取文件内容---read(String ip,String filePath)
 * <p>
 * hadoop 管理地址
 * http://localhost:8088
 * <p>
 * hsfs访问地址
 * http://localhost:9870/
 */
@Component
public class HadoopUtils {

    // 静态常量
    public static String Hadoop_IP = "192.168.1.6";  //hadoopip地址
    @Value("${hadoop.hadoop02:192.168.1.8}")
    private String hadoop_IP02;  //hadoopip地址
    @Value("${hadoop.hadoop02:192.168.1.9}")
    private String hadoop_IP03;  //hadoopip地址

    public static final String Hadoop_BASE_PATH = "/";  //存储父路径

    private static FileSystem fs;

    /**
     * @return
     * @throws Exception
     */
    public static List<Scoreinfo2> getHiveDataScoreinfo() throws Exception {

        Statement stmt = HiveJDBCUtils.getConnStatement();
        /******删除表******/
        String sqldropTable = "drop table scoreinfo";
        stmt.execute(sqldropTable);
        /******创建表******/
        String sqlcreate = "create table scoreinfo (uid string ,tid string,score string) row format delimited fields terminated by  ',' ";
        stmt.execute(sqlcreate);
        /******hdfs导入数据到hive******/
        String hsfsFileName = "scoreinfo.txt";
        String filePath = hsfsFileName;
        //String sqlload = "load data  inpath 'hdfs://192.168.1.6:9000/scoreinfo.txt' overwrite into table scoreinfo";
        String sqlload = "load data  inpath 'hdfs://" + HadoopUtils.Hadoop_IP + ":9000/" + filePath + "' overwrite into table scoreinfo";
        System.out.println("sqlload = " + sqlload);
        stmt.execute(sqlload);
        /******查询hive中的数据******/
        String sqlSelect = "select * from scoreinfo";
        ResultSet rs = stmt.executeQuery(sqlSelect);
        List<Scoreinfo2> scoreinfoList = new ArrayList<Scoreinfo2>();
        int id = 1;
        while (rs.next()) {
            String uid = rs.getString(1);
            String tid = rs.getString(2);
            String score = rs.getString(3);
            Scoreinfo2 scoreinfo = new Scoreinfo2();
            scoreinfo.setId(id);
            scoreinfo.setUid(uid);
            scoreinfo.setTid(tid);
            scoreinfo.setScore(score);
            id++;
            scoreinfoList.add(scoreinfo);
        }
        HadoopUtils.writeScoreinfoHDFS(scoreinfoList);//重新恢复hdfs
        return scoreinfoList;
    }


    /**
     * 写入hdfs方法
     */
    public static void writeScoreinfoHDFS(List<Scoreinfo2> scoreinfoList) {
        String content = "";
        for (Scoreinfo2 scoreinfo : scoreinfoList) {
            String msg = String.format("%s,%s,%s\n", scoreinfo.getUid(), scoreinfo.getTid(), scoreinfo.getScore());
            content = content + msg;
        }
        //测试写入
        HadoopUtils hadoopUtils = new HadoopUtils();
        //String content = "id,张三,5.5";
        String hsfsFileName = "/scoreinfo.txt";
        String hdfsFile = HadoopUtils.Hadoop_BASE_PATH + hsfsFileName;
        try {
            if (hadoopUtils.exists(HadoopUtils.Hadoop_IP, hdfsFile)) {
                hadoopUtils.delete(HadoopUtils.Hadoop_IP, hdfsFile, true); //先删除文件
            }
        } catch (Exception e) {
            System.out.println("删除HDFS文件异常");
        } finally {
            hadoopUtils.write(content, HadoopUtils.Hadoop_IP, hdfsFile); //写入内容
        }

    }


    public void upload(String ip, String srcPath, String desPath) {
        //创建一个Configuration
        Configuration conf = new Configuration();
        conf.setBoolean("dfs.support.append", true);
        conf.set("dfs.client.block.write.replace-datanode-on-failure.policy", "NEVER");
        conf.set("fe.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        conf.setBoolean("dfs.client.block.write.replace-datanode-on-failure.enable", true);
        // 定义统一资源标识符（uri: uniform resource identifier）
        System.out.println("运行较慢,请耐心等待...");
        //创建FileSystem对象
        try {
            //fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        //把本地磁盘中的文件上传到hdfs的某个目录下
        try {
            fs.copyFromLocalFile(false, new Path(srcPath), new Path(desPath));
            System.out.println("运行结果 : 上传成功");
            //关闭
            fs.close();
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public void download(String ip, String srcPath, String desPath) {
        Configuration conf = new Configuration();
        System.out.println("运行较慢,请耐心等待...");
        try {
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            fs.copyToLocalFile(false, new Path(srcPath), new Path(desPath), true);
            fs.close();
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public void list(String ip, String path) {
        Configuration conf = new Configuration();
        FileStatus[] status = null;
        System.out.println("运行结果 : 运行较慢,请耐心等待...");
        try {
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            status = fs.listStatus(new Path(path));
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < status.length; i++) {
            if (status[i].isFile()) {
                System.out.println("文件:" + status[i].getPath().toString());
            } else if (status[i].isDirectory()) {
                System.out.println("目录:" + status[i].getPath().toString());
            }
        }
    }

    public void delete(String ip, String path, boolean boStr) {
        Configuration conf = new Configuration();
        System.out.println("运行较慢,请耐心等待...");
        try {
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            Path deleteFile = new Path("hdfs://" + ip + ":9000" + path);
            fs.delete(deleteFile, boStr);
            System.out.println("删除成功!");
            fs.close();
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public void mkdir(String ip, String path) {
        Configuration conf = new Configuration();
        System.out.println("运行较慢,请耐心等待...");
        try {
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            fs.mkdirs(new Path(path));
            System.out.println("运行结果 : 创建目录成功");
            fs.close();
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String txt, String ip, String path) {
        Configuration conf = new Configuration();
        System.out.println("运行较慢,请耐心等待...");
        byte[] buff = txt.getBytes();
        try {
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        Path dfs = new Path("hdfs://" + ip + ":9000" + path);
        FSDataOutputStream outputStream;
        try {
            outputStream = fs.create(dfs);
            outputStream.write(buff, 0, buff.length);
            System.out.println("运行结果 : 写入文件成功");
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rename(String ip, String pathNoName, String oldName, String newName) {
        Configuration conf = new Configuration();
        System.out.println("运行较慢,请耐心等待...");
        try {
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        Path frPath = new Path("hdfs://" + ip + ":9000" + pathNoName + "/" + oldName);
        Path toPath = new Path("hdfs://" + ip + ":9000" + pathNoName + "/" + newName);
        try {
            boolean isRenameFile = fs.rename(frPath, toPath);
            if (isRenameFile) {
                System.out.println("运行结果 : 重命名成功");
            } else {
                System.out.println("运行结果 : 重命名失败");
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean exists(String ip, String path) {
        Configuration conf = new Configuration();
        System.out.println("运行较慢,请耐心等待...");
        try {
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        Path findfile = new Path("hdfs://" + ip + ":9000" + path);
        boolean isExists;
        try {
            isExists = fs.exists(findfile);
            if (isExists) {
                System.out.println("运行结果 : 文件存在");
                return true;
            } else {
                System.out.println("运行结果 : 文件不存在");
            }
            fs.close();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void fileLoc(String ip, String Path) {
        Configuration conf = new Configuration();
        System.out.println("运行较慢,请耐心等待...");
        FileStatus filestatus = null;
        try {
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        Path fpath = new Path("hdfs://" + ip + ":9000" + Path);
        try {
            filestatus = fs.getFileStatus(fpath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BlockLocation[] blkLocations;
        try {
            blkLocations = fs.getFileBlockLocations(filestatus, 0, filestatus.getLen());
            int blockLen = blkLocations.length;
            System.out.println("block数量:" + blockLen);
            for (int i = 0; i < blockLen; i++) {
                String[] hosts = blkLocations[i].getHosts();
                System.out.println("文件在HDFS集群中的位置 : block " + i + " ,location:" + hosts[i]);
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTime(String ip, String path) {
        Configuration conf = new Configuration();
        System.out.println("运行较慢,请耐心等待...");
        try {
            fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        Path fpath = new Path("hdfs://" + ip + ":9000" + path);
        FileStatus fileStatus;
        try {
            fileStatus = fs.getFileStatus(fpath);
            long modificationTime = fileStatus.getModificationTime();
            Date date = new Date(modificationTime);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time = sdf.format(date);
            System.out.println("文件最后一次的修改时间: " + time);
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String read(String ip, String filePath) throws Exception {
        byte[] result = null;
        if (filePath == null || filePath.trim().length() == 0) {
            throw new Exception("文件路径不对" + filePath + "，请检查");
        }
        FSDataInputStream hdfsIS = null;
        ByteArrayOutputStream baos = null;
        try {
            Configuration conf = new Configuration();
            System.out.println("运行较慢,请耐心等待...");
            try {
                fs = FileSystem.get(new URI("hdfs://" + ip + ":9000"), conf, "root");
            } catch (IOException | InterruptedException | URISyntaxException e) {
                e.printStackTrace();
            }
            Path hdfsPath = new Path("hdfs://" + ip + ":9000" + filePath);
            System.out.println(hdfsPath.getName());
            hdfsIS = fs.open(hdfsPath);
            byte[] b = new byte[65536];
            baos = new ByteArrayOutputStream();
            int flag = -1;
            while ((flag = hdfsIS.read(b)) != -1) {
                baos.write(b);
                // baos.write(flag);//不成功
                b = new byte[65536];
            }
            result = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            hdfsIS.close();
            baos.close();
        }

        return new String(result, "utf-8");
    }

    public static String getHadoop_IP() {
        return Hadoop_IP;
    }

    public static void setHadoop_IP(String hadoop_IP) {
        Hadoop_IP = hadoop_IP;
    }

    public String getHadoop_IP02() {
        return hadoop_IP02;
    }

    public void setHadoop_IP02(String hadoop_IP02) {
        this.hadoop_IP02 = hadoop_IP02;
    }

    public String getHadoop_IP03() {
        return hadoop_IP03;
    }

    public void setHadoop_IP03(String hadoop_IP03) {
        this.hadoop_IP03 = hadoop_IP03;
    }

    public static String getHadoop_BASE_PATH() {
        return Hadoop_BASE_PATH;
    }

    public static FileSystem getFs() {
        return fs;
    }

    public static void setFs(FileSystem fs) {
        HadoopUtils.fs = fs;
    }

    public static void main(String[] args) throws Exception {
        HadoopUtils hadoopUtils = new HadoopUtils();
       /* System.out.println("HadoopUtils.HadoopUtils = " + HadoopUtils.Hadoop_IP);
        System.out.println("Hadoop_IP02 = " + new HadoopUtils().getHadoop_IP02());
        //测试写入

        String content = "id,张三,5.5";
        String hdfsFile = HadoopUtils.Hadoop_BASE_PATH + System.currentTimeMillis() + ".txt";
        hadoopUtils.write(content, HadoopUtils.Hadoop_IP, hdfsFile);*/

        //测试读取
        // hdfs://192.168.1.7:9000/user/root/scoreinfo.txt
        String read = hadoopUtils.read(HadoopUtils.Hadoop_IP, "/scoreinfo.txt");
        System.out.println("read = " + read);


    }

}
