package in.dev.gmsk.controller;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class QRCodeGeneratorTest {

    @Test
    void generateQRCodeImage() throws Exception {
        BufferedImage helloLunar = QRCodeGenerator.generateQRCodeImage( "Hello Lunar" );
        assertNotNull( helloLunar );
        System.out.println( "helloLunar = " + helloLunar );
    }
}