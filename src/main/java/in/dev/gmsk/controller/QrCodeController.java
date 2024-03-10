package in.dev.gmsk.controller;

import in.dev.gmsk.model.DecodedQrResponse;
import in.dev.gmsk.model.GenerateQrRequest;
import in.dev.gmsk.service.QrCodeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/create-qr-code")
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping(path = "/get-qr", produces = MediaType.IMAGE_JPEG_VALUE)
    public void generateQr(@RequestParam String data, HttpServletResponse response) {
        try {
            if (data == null || data.trim().isEmpty()) {
                throw new MissingRequestValueException( "QR String is required" );
            }
            qrCodeService.generateQr( data, response.getOutputStream() );
            response.getOutputStream().flush();
        } catch (Throwable e) {
            throw new RuntimeException( e.getMessage() );
        }
    }

    @PostMapping(path = "/qr-code", produces = MediaType.IMAGE_JPEG_VALUE)
    public void generateQRCode(@RequestBody GenerateQrRequest request, HttpServletResponse response) {
        try {
            if (request == null || request.getQrString() == null || request.getQrString().trim().isEmpty()) {
                throw new MissingRequestValueException( "QR String is required" );
            }
            qrCodeService.generateQr( request.getQrString(), response.getOutputStream() );
            response.getOutputStream().flush();
        } catch (Throwable e) {
            throw new RuntimeException( e.getMessage() );
        }
    }

    @PostMapping(path = "/qr-decode")
    public DecodedQrResponse decodeQr(@RequestParam("qrCode") MultipartFile qrCode) {
        try {
            String qrCodeString = qrCodeService.decodeQr( qrCode.getBytes() );
            return new DecodedQrResponse( qrCodeString );
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage() );
        }
    }
}
