public class Message {


    //String[] complimentFirst = new String[11];

    public Message(){
        /*   complimentFirst[0] = "превосходно!\n";
        complimentFirst[1] = "великолепно!\n";
        complimentFirst[2] = "круто!\n";
        complimentFirst[3] = "феерично!\n";
        complimentFirst[4] = "воодушевляюще!\n";
        complimentFirst[5] = "восхитительно!\n";
        complimentFirst[6] = "исключительно!\n";
        complimentFirst[7] = "грандиозно!\n";
        complimentFirst[8] = "легендарно!\n";
        complimentFirst[9] = "эпично!\n";


      */
    }

    public void interestingFact() {
        String[] interestingFact = new String[10];
        interestingFact[0] = "загадка - особый жанр народного творчества \nи с " +
                "давних пор была отражением народной мудрости.\n";
        interestingFact[1] = "изначально загадки \nпередавались из уст в уста.\n";
        interestingFact[2] = "загадка учит думать логически, развивает " +
                "воображение \nи помогает лучше понимать окружающий мир.\n";
        interestingFact[3] = "загадки развивают наблюдательность \nи учат " +
                "воспринимать мир многогранно и образно.\n";
        interestingFact[4] = "загадки помогают развивать такие операции " +
                "\nмышления как: абстрагирование, анализ и синтез, классификацию и обобщение.\n";
        interestingFact[5] = "загадки можно придумывать самостоятельно \nуже в начальных классах, " +
                "что положительно влияет на сплочение коллектива.\n";
        interestingFact[6] = "существует очень много видов загадок.\n";
        interestingFact[7] = "основные виды загадок: фольклорные, " +
                "\nлитературные, лингвистические, логические.\n";
        interestingFact[8] = "у древних греков загадки \nнаходились в связи с " +
                "изречениями оракулов и в основном излагались гекзаметрами.\n";
        interestingFact[9] = "особенно много загадок \nоставил " +
                "древнегреческий философ Клеобул - один из 'семи мудрецов'.\n";
        System.out.println("\nА Вы знаете что " + interestingFact[random()]);
    }

    public String wrongAnswer() {
        String[] wrongAnswer = new String[10];
        wrongAnswer[0] = "Неверно...";
        wrongAnswer[1] = "Неправильно...";
        wrongAnswer[2] = "Холодно...";
        wrongAnswer[3] = "Мимо...";
        wrongAnswer[4] = "Очень холодно...";
        wrongAnswer[5] = "Провально...";
        wrongAnswer[6] = "Незачет...";
        wrongAnswer[7] = "Слабо...";
        wrongAnswer[8] = "Неточно...";
        wrongAnswer[9] = "Ошибочно...";
        return(wrongAnswer[random()]);

        //можно искать синонимы

    }


    public String complimentSecond() {
        String[] complimentSecond = new String[10];
        complimentSecond[0] = "Молодец!";
        complimentSecond[1] = "Агонь!";
        complimentSecond[2] = "Так держать!";
        complimentSecond[3] = "Превосходно!";
        complimentSecond[4] = "Умница!";
        complimentSecond[5] = "Великолепно!";
        complimentSecond[6] = "Восхитительно!";
        complimentSecond[7] = "Феерично!";
        complimentSecond[8] = "Воодушевляюще!";
        complimentSecond[9] = "Круто!";

//круто супер воодушевляюще космос феерично
//ты просто ,космос, - вместо космос подставить слово - т е ето уже фраза
//погуглить: 100 слов похвалы - в вк есть осуждение

        //System.out.println(complimentSecond[random()]);
        return(complimentSecond[random()]);

    }

    public String complimentFirst() {
        String[] complimentFirst = new String[10];
        complimentFirst[0] = "превосходно!";
        complimentFirst[1] = "великолепно!";
        complimentFirst[2] = "круто!";
        complimentFirst[3] = "феерично!";
        complimentFirst[4] = "воодушевляюще!";
        complimentFirst[5] = "восхитительно!";
        complimentFirst[6] = "исключительно!";
        complimentFirst[7] = "грандиозно!";
        complimentFirst[8] = "легендарно!";
        complimentFirst[9] = "эпично!";
        return("Это было " + complimentFirst[random()]);
    }

    public int random() {
//диапазон от и до
        int from = 0;
        int before = 9;
        int random = from + (int) (Math.random() * before);
        return random;
    }


    //сделать промежуточный ответ если написано с ошибкой
    //типпаа вы почти отгадали, почти отгадали. осталось совсем чуть чуть

}


