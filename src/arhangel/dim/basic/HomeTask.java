package arhangel.dim.basic;

public class HomeTask {

    public static String intToIp(int ip) {
        StringBuilder builder = new StringBuilder(); // Используем StringBuilder а не "+"

        for (int i = 0; i < 4; i++) {
            builder.append((ip >> (i * 8)) & 0xff); // сдвигаем на 8, 16, 24 и берем маску 0xff=11111111
            if (i != 3) {
                builder.append("."); // Правильно расставляем точки между группами
            }
        }
        return builder.toString();
    }

    public static String decToHex(int number) {
        StringBuilder stringBuilder = new StringBuilder("0x"); // 0x префикс означает, что число в 16ричной системе
        int[] groups = new int[8]; // разбиваем число на группы по 4 бита (в 4 бита можно закодировать числа 0-15 = 0x0-0xf)
        boolean isValuable = false; // не хотим показывать лидирующие нули, то есть 0x00ef -> 0xef
        for (int i = 7; i >= 0; i--) {
            groups[i] = ((number >>> (i * 4)) & 0xf); // получаем группу
            if (groups[i] != 0) // проверяем на лид. нули
                isValuable = true;
            if (isValuable || i == 0) {
                char current;
                if (groups[i] < 10)
                    current = (char) (groups[i] + '0');
                else
                    current = (char) (groups[i] - 10 + 'A');
                stringBuilder.append(current);
            }
        }
        return stringBuilder.toString();
    }

    // печать числа в бинарном виде
    static String toBinaryString(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            builder.append((n >> i) & 0x1);
        }
        return builder.toString();
    }

}