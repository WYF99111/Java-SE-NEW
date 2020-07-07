package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//创建线程方式2：实现runnable接口，重写run方法，调用start方法
public class TESTthread2 implements Runnable{
    private String url;//网络图片地址
    private String name;//保存的文件名

    public TESTthread2(String url, String name) {
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
        TESTthread2 t2 = new TESTthread2("https://i0.hdslb.com/bfs/sycp/creative_img/202006/dfbce82630b964c553937f303f0477b0.jpg","tupian2.jpg");
        new Thread(t2).start();
    }
}

