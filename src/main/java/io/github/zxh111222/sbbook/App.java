package io.github.zxh111222.sbbook;

import com.fazecast.jSerialComm.*;

import io.github.zxh111222.sbbook.pojo.Book2;
import io.github.zxh111222.sbbook.parser.Parser;
import io.github.zxh111222.sbbook.parser.ZhuashuParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class App {



    public static void main(String[] args) {
//        String receivedData = readFromSerialPort();
//        System.out.println("接收的数据: " + receivedData);
//        String bookInfo = getBookInfoByISBNForApi(receivedData);
//        System.out.println("书籍信息: " + bookInfo);
//        String bookInfo = getBookInfoByISBNForApi("9787521308716");
//        System.out.println("书籍信息: " + bookInfo);
        Book2 bookInfoByISBNForSpiders = getBookInfoByISBNForSpiders("9787521308716");
    }

    public static String readFromSerialPort() {
        // 获取串口列表
        SerialPort[] availablePorts = SerialPort.getCommPorts();
        if (availablePorts.length == 0) {
            System.out.println("未找到可用的串行端口。");
            return null;
        }

        // 选择第一个可用的串口
        SerialPort comPort = availablePorts[0];
        System.out.println("使用的端口: " + comPort.getSystemPortName());

        // 打开串口
        comPort.openPort();
        comPort.setBaudRate(115200); // 设置波特率
        comPort.setNumDataBits(8); // 设置数据位
        comPort.setNumStopBits(SerialPort.ONE_STOP_BIT); // 设置停止位
        comPort.setParity(SerialPort.NO_PARITY); // 设置校验位

        // StringBuilder 用于拼接接收到的数据
        StringBuilder dataBuilder = new StringBuilder();

        // 设置串口监听
        comPort.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                // 返回你想要监听的事件类型
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                    try {
                        // 读取串口数据
                        byte[] readBuffer = new byte[comPort.bytesAvailable()];
                        comPort.readBytes(readBuffer, readBuffer.length);
                        String data = new String(readBuffer);
                        dataBuilder.append(data); // 将接收到的数据添加到 StringBuilder
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 保持程序运行，以便监听事件
        try {
            // 设定时间以便接收数据，实际应用中可以根据需要调整
            Thread.sleep(5000); // 等待 5 秒钟以接收数据
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 关闭串口
            comPort.closePort();
        }

        return dataBuilder.toString(); // 返回接收到的数据
    }

    public static String extractISBN(String data) {
        // 简单提取 ISBN 的示例（假设 ISBN 是以 "ISBN:" 开头的）
        String prefix = "ISBN:";
        int startIndex = data.indexOf(prefix);
        if (startIndex != -1) {
            startIndex += prefix.length();
            int endIndex = data.indexOf('\n', startIndex); // 假设 ISBN 后跟换行符
            if (endIndex == -1) {
                endIndex = data.length(); // 如果没有找到换行符，直到字符串结束
            }
            return data.substring(startIndex, endIndex).trim();
        }
        return null;
    }

//    // api 方式
//    public static String getBookInfoByISBNForApi(String isbn) {
//        String appKey = "ae1718d4587744b0b79f940fbef69e77";
//        String apiUrl = "https://data.isbn.work/openApi/getInfoByIsbn?isbn=";
//        StringBuilder url = new StringBuilder();
//        url.append(apiUrl).append(isbn).append("&appKey=").append(appKey);
//        System.out.println(url);
//
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpGet request = new HttpGet(url.toString());
//            try (CloseableHttpResponse response = httpClient.execute(request)) {
//                String jsonResponse = EntityUtils.toString(response.getEntity());
//                JSONObject jsonObject = new JSONObject(jsonResponse);
//
//                // 检查 API 响应状态
//                if (jsonObject.has("data")) {
//                    return jsonObject.getJSONObject("data").toString(2); // 返回书籍信息
//                } else {
//                    return "未找到书籍信息。";
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "获取书籍信息时出错。";
//        }
//    }

    // 爬虫方式
    public static Book2 getBookInfoByISBNForSpiders(String isbn) {
//        String url = "https://isbnsearch.org/isbn/" + isbn;
        String url = "http://www.zhuashu.cn/isbn/" + isbn;
//        Parser parser = new IsbnSearchParser();
        Parser parser = new ZhuashuParser();
        Book2 isbnInfoList = parser.parse(url);
//        System.out.println(isbnInfoList);


        return isbnInfoList;
    }

}
