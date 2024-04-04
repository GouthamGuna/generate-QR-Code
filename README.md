# QR Code Generate-and-validate

 Generate - QR (Recommended)

 Query param using generate QR - Code.

 * `GET`  - URL = http://localhost:8081/QR_Generate/api/v1/create-qr-code/get-qr?data=https://gouthamguna.github.io/in/

## Request Body Needed! (Generate - QR)

 * `POST` - URL = http://localhost:8081/QR_Generate/api/v1/create-qr-code/qr-code

    {
        "qrString": "Hello Lunar 🌙"
    }

## Validate - QR Code

 * `PostMapping` - URL = http://localhost:8081/QR_Generate/api/v1/create-qr-code/qr-decode?qrCode=response.jpg