package cn.ousky.smartcampus.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileUtil {

    // 文件存储位置
    @Value("${file.news.path}")
    private String file_path;

    // 获取目录位置
    public String getPath() {
        return file_path;
    }

    /**
     * 存储文件
     *
     * @param name 文件名
     * @param txt  文件内容
     * @return
     */
    public Boolean saveFile(String txt, String dir, String name) {
        File file = new File(file_path + dir + "/" + name);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(txt);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 读取文件
     *
     * @param name 文件名
     * @return
     */
    public StringBuilder readFile(String dir, String name) {
        File file = new File(file_path + dir + "/" + name);
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb;
    }

    /**
     * 保存二进制文件
     *
     * @param bis 缓冲输入流
     */
    public Boolean save2File(BufferedInputStream bis, String dir, String name) {
        File file = new File(file_path + dir + "/" + name);
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            byte[] bt = new byte[1024];
            while (bis.read(bt) != -1) {
                bos.write(bt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
                if (fos != null)
                    fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 创建文件夹
     *
     * @param name 文件名
     * @return
     */
    public Boolean mkdir(String name) {
        File file = new File(file_path + name);
        if (!file.exists()) {
            return file.mkdir();
        }
        return false;
    }

    /**
     * 删除文件/文件夹
     *
     * @param file 文件
     * @return
     */
    public Boolean delete(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null)
                return false;
            for (File f : files) {
                if (f.isDirectory())
                    delete(f);
                f.delete();
            }
        }
        return file.delete();
    }
}
