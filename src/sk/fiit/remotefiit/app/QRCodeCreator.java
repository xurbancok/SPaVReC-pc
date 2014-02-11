package sk.fiit.remotefiit.app;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import javax.swing.ImageIcon;

import sk.fiit.remotefiit.interfaces.QRCode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//zdroj: http://crunchify.com/java-simple-qr-code-generator-example/

public class QRCodeCreator implements QRCode{

	@Override
	public ImageIcon getQRCode(String input){
	        int size = 125;
	        BufferedImage image = null;
	        ImageIcon result = null;
	        try {
	            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
	            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	            QRCodeWriter qrCodeWriter = new QRCodeWriter();
	            BitMatrix byteMatrix = qrCodeWriter.encode(input,BarcodeFormat.QR_CODE, size, size, hintMap);
	            int CrunchifyWidth = byteMatrix.getWidth();
	            image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
	                    BufferedImage.TYPE_INT_RGB);
	            image.createGraphics();
	 
	            Graphics2D graphics = (Graphics2D) image.getGraphics();
	            graphics.setColor(Color.WHITE);
	            graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
	            graphics.setColor(Color.BLACK);
	 
	            for (int i = 0; i < CrunchifyWidth; i++) {
	                for (int j = 0; j < CrunchifyWidth; j++) {
	                    if (byteMatrix.get(i, j)) {
	                        graphics.fillRect(i, j, 1, 1);
	                    }
	                }
	            }
	            result = new ImageIcon(image);
	        } catch (WriterException e) {
	            e.printStackTrace();
	        }
			return result;
	}
}
