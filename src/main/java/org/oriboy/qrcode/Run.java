package org.oriboy.qrcode;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * 运行类
 * @author egret
 */
public class Run {
    public static void main(String[] args) throws ChecksumException, NotFoundException, IOException, FormatException {
        String url = "src/main/resources/image";
        File dir = new File(url);
        File[] fileList = dir.listFiles();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if(o1.equals(o2)){
                return 0;
            }
            if(o1.length() < o2.length()){
                return 0;
            }
            return o2.compareTo(o1);
        });
        assert fileList != null;
        for(File f : fileList){
            priorityQueue.add(f.getName());
        }
        System.out.println(QRCodeUtils.read(url + "//" + priorityQueue.peek()));
    }
}
