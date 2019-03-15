package com.qrcodeproject.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ReadQRCode {
    public static void main(String[] args) {
        try {
            MultiFormatReader reader = new MultiFormatReader();

            File file = new File("D:/img.png");

            BufferedImage image = ImageIO.read(file);

            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

            //定义二维码的参数
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

            Result result = reader.decode(binaryBitmap, hints);

            System.out.println(result.toString());
        }catch (NotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
