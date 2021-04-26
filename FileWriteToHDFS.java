package com.example.writeintohdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;


public class FileWriteToHDFS {

    public void putFileInToHDFS(String fileData) throws Exception{
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
//        configuration.addResource(new Path("/HADOOP_HOME/conf/core-site.xml"));
//        configuration.addResource(new Path("/HADOOP_HOME/conf/hdfs-site.xml"));
        FileSystem fileSystem = FileSystem.get(configuration);
        //Create a path
        String fileName = "input.txt";
        Path hdfsWritePath = new Path("/user/" + fileName);
        FSDataOutputStream fsDataOutputStream = fileSystem.create(hdfsWritePath,true);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream,StandardCharsets.UTF_8));
        bufferedWriter.write(fileData);
        bufferedWriter.close();
        fileSystem.close();




    }

    public static void main(String args[]) throws Exception {

        FileWriteToHDFS fileWriteToHDFS = new FileWriteToHDFS();
        String x = "hi zakwan";
        fileWriteToHDFS.putFileInToHDFS(x);

    }
}
