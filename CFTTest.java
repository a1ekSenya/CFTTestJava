import java.io.*;
public class CFTTest {
    public static void main(String[] args)
    {
        InsertionSort.Order order = null;
        try {
            if (args[3].equals("-a"))
                order = InsertionSort.Order.ORDER_ASC;
            if (args[3].equals("-d"))
                order = InsertionSort.Order.ORDER_DESC;
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            String fileLine;
            switch (args[2]) {
                case "-i": {
                    int[] initialIntArray = new int[100];
                    int j = 0;
                    while ((fileLine = reader.readLine()) != null) {
                        initialIntArray[j++] = Integer.parseInt(fileLine);
                    }
                    int intArray[] = new int[j];
                    System.arraycopy(initialIntArray, 0, intArray, 0, j);
                    if (order != null) {
                        fileWrite(args[1], InsertionSort.sortInsertion(intArray, order));
                    } else {
                        System.out.println("Неверно указан параметр сортировки! (замените " + args[3] + " на -a/-d)");
                    }
                    break;
                }
                case "-s": {
                    String[] initialStrArray = new String[100];
                    int j = 0;
                    while ((fileLine = reader.readLine()) != null) {
                        initialStrArray[j++] = fileLine;
                    }
                    String strArray[] = new String[j];
                    System.arraycopy(initialStrArray, 0, strArray, 0, j);
                    if (order != null) {
                        fileWrite(args[1], InsertionSort.sortInsertion(strArray, order));
                    } else {
                        System.out.println("Неверно указан параметр сортировки! (замените " + args[3] + " на -a/-d)");
                    }
                    break;
                }
                default:
                    System.out.println("Неверно указан параметр формата данных в файле! (замените " + args[2] + " на -i/-s)");
                    break;
            }
            reader.close();
        }
        catch (NumberFormatException e) {
            System.out.println("Как минимум одна строка в файле не является целым числом!");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файла указанного в первом параметре не существует! Создайте его или укажите другой файл.");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вы не ввели как минимум один из параметров запуска программы!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void fileWrite(String fileName, String[] text) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                for (String aText : text) out.println(aText);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            System.out.println("Невозможно создать файл, в который вы хотите записать результаты выполнения программы!");
        }
    }
}