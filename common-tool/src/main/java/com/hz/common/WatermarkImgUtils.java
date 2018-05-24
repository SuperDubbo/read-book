package com.hz.common;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author HuangZhu
 * @version V1.0
 * @Description: 文字生成水印图片并45度倾斜铺满图片
 */
public class WatermarkImgUtils {

    public static void main(String[] args) {
        System.out.println("开始水印：");
        new WatermarkImgUtils().addWatermark("D:\\Users\\001302\\桌面\\2\\1\\123.jpg", "D:\\Users\\001302\\桌面\\2\\1\\456.jpg", "仅供蛋壳租赁合同使用，他用无效！", "jpg");
        System.out.println("水印完成。");
    }

    public void addWatermark(String sourceImgPath,String tarImgPath,String waterMarkContent,String fileExt){
        //水印字体大小
        Font font=new Font("宋体",Font.BOLD,36);
        //水印颜色
        Color markContentColor=Color.gray;
        //设置水印文字的旋转角度
        Integer degree=45;
        //设置水印透明度
        float alpha=0.5f;
        OutputStream outputStream=null;
        try{
            //获得源文件
            File srcImgFile=new File(sourceImgPath);
            //文件转化为图片
            Image srcImg=ImageIO.read(srcImgFile);
            //获得图片的宽
            int srcImgWidth=((BufferedImage) srcImg).getWidth();
            //获得图片的高
            int srcImgHeight=((BufferedImage) srcImg).getHeight();
            //加水印
            BufferedImage bufImg=new BufferedImage(srcImgWidth,srcImgHeight,BufferedImage.TYPE_INT_RGB);
            //得到画笔
            Graphics2D graphics2D=bufImg.createGraphics();
            graphics2D.drawImage(srcImg,0,0,srcImgWidth,srcImgHeight,null);
            //设置水印颜色
            graphics2D.setColor(markContentColor);
            //设置字体
            graphics2D.setFont(font);
            //设置水印文字透明度
            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));
            if(null!=degree){
                //设置水印旋转
                graphics2D.rotate(degree);
            }
            JLabel label=new JLabel(waterMarkContent);
            FontMetrics metrics=label.getFontMetrics(font);
            //文字水印的宽
            int width=metrics.stringWidth(label.getText());
            //图片的高除以文字水印的宽----->>>打印的行数(以文字水印的宽为间隔)
            int rowsNumber=srcImgHeight/width;
            //图片的宽除以文字水印的宽----->>>每行打印的列数(以文字水印的宽慰间隔)
            int columnsNumber=srcImgWidth/width;
            //防止图片太小而文字水印太长，所以至少打印一次
            if(rowsNumber<1){
                rowsNumber=1;
            }
            if(columnsNumber<1){
                columnsNumber=1;
            }
            for (int j=0;j<rowsNumber;j++){
                for(int i=0;i<columnsNumber;i++){
                    //画出水印，并设置水印位置
                    graphics2D.drawString(waterMarkContent,i*width+j*width,-i*width+j*width);
                }
            }
            //释放资源
            graphics2D.dispose();
            //输出图片
            outputStream=new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg,fileExt,outputStream);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }finally {
            try {
                if(outputStream!=null){
                    outputStream.flush();
                    outputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
                e.getMessage();
            }
        }
    }
}
































