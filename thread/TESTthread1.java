package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TESTthread1 extends Thread{
    private String url;//网络图片地址
    private String name;//保存的文件名

    public TESTthread1(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        Webdownloader webdownloader = new Webdownloader();
        webdownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TESTthread1 t1 = new TESTthread1("https://i0.hdslb.com/bfs/sycp/creative_img/202006/dfbce82630b964c553937f303f0477b0.jpg","tupian1.jpg");
        t1.start();
    }
}
class Webdownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}