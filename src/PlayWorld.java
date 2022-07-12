import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayWorld {
    public static void main(String[] args) {
        //Инициализируем BufferedReader
        Realm.br = new BufferedReader(new InputStreamReader(System.in));
        //Инициализируем класс для боя
        Realm.battle = new Battle();
        //Первое, что нужно сделать при запуске игры, это создать персонажа, поэтому мы предлагаем ввести его имя
        System.out.println("Введите имя персонажа:");
        //Далее ждем ввод от пользователя
        try {
            command(Realm.br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void command(String string) throws IOException {
        //Если это первый запуск, то мы должны создать игрока, именем будет служить первая введенная строка из консоли
        if (Realm.player == null) {
            Realm.player = new Player(
                    string,
                    100,
                    20,
                    20,
                    0,
                    0
            );
            System.out.println(String.format("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!", Realm.player.getName()));
            //Метод для вывода меню
            printNavigation();
        }
        //Варианты для команд
        switch (string) {
            case "1": {
                System.out.println("Торговец еще не приехал");
                command(Realm.br.readLine());
            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(Realm.br.readLine());
            }
        }
        //Снова ждем команды от пользователя
        command(Realm.br.readLine());
    }


    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }

    private static void commitFight() {
        Realm.battle.fight(Realm.player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.", Realm.player.getName(), Realm.player.getPractice(), Realm.player.getGold(), Realm.player.getHealth()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(Realm.br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }

    private static AbstractEntity createMonster() {
        //Рандомайзер
        int random = (int) (Math.random() * 10);
        //С вероятностью 50% создается или скелет, или гоблин
        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                100,
                20
        );
        else return new Sceleton(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }

}