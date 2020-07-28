package javaTest;

import java.io.*;

public class javaIO {
    //File 操作
    public void stream_file() throws IOException {
        File f = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(f);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        writer.append("中文输入");
        writer.append("\r\n");
        writer.append("English");
        writer.close();
        fop.close();

        FileInputStream fip = new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");

        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        System.out.println(sb.toString());
        reader.close();
        fip.close();

    }

    void stream_file_easy() throws IOException {
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //System.out.println(br.readLine());
        int b = 'A';
        System.out.write(b);
        //InputStream f=new FileInputStream("./");
        byte[] bWiter = {11, 21, 3, 40, 5};
        OutputStream os = new FileOutputStream("test.txt");
        for (int i = 0; i < bWiter.length; i++)
            os.write(bWiter[i]);
        os.close();
        InputStream is = new FileInputStream("test.txt");
        int size = is.available();

        for (int i = 0; i < size; i++) {
            System.out.print((char) is.read() + " ");

        }
        is.close();
    }

    void stream_bytearrayOutputStream() throws IOException {
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);
        while (bOutput.size() != 10)
            bOutput.write(System.in.read());

        byte b[] = bOutput.toByteArray();
        System.out.println("Print the count");
        for (int x = 0; x < b.length; x++)
            System.out.print((char) b[x] + " ");
        System.out.println(" ");
        int c;
        ByteArrayInputStream bInput = new ByteArrayInputStream(b);
        System.out.println("Converting characters to Upper case");
        for (int y = 0; y < 1; y++) {
            while ((c = bInput.read()) != -1) {
                System.out.println(Character.toUpperCase((char) c));
            }
            bInput.reset();
        }
    }

    void createDir() {
        String dirName = "/dirTest";
        File d = new File(dirName);
        d.mkdirs();
    }

    static void DirList(String path) {
        File f1 = new File(path);
        if (f1.isDirectory()) {
            System.out.println("目录" + path);
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(path + "/" + s[i]);
                if (f.isDirectory())
                    System.out.println(s[i] + "是一个目录");
                else
                    System.out.println(s[i] + "是一个文件");
            }
        } else
            System.out.println(path + "不是一恶搞目录");

    }

    //序列化
    class se implements Serializable {
        private int x;
        private String y;

        se(int x, String y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public String toString() {
            return "x=" + x + " " + "y=" + y;
        }
    }

    void seriali() throws IOException, ClassNotFoundException {
        se example = new se(123, "asd");
        String obj = "file/a1";
        ObjectOutputStream objOs = new ObjectOutputStream(new FileOutputStream(obj));
        objOs.writeObject(example);
        objOs.close();

        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(obj));
        se a2 = (se) objIn.readObject();
        objIn.close();
        System.out.println(a2);
    }

    public static void main(String[] argc) throws Exception {
        new javaIO().seriali();
        //System.out.println(System.getProperty("file.encoding"));

    }
}
