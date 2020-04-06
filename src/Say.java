public class Say {

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

    public void wrongAnswer() {
        String[] wrongAnswer = new String[10];
        wrongAnswer[0] = "";
        wrongAnswer[1] = "";
        wrongAnswer[2] = "";
        wrongAnswer[3] = "";
        wrongAnswer[4] = "";
        wrongAnswer[5] = "";
        wrongAnswer[6] = "";
        wrongAnswer[7] = "";
        wrongAnswer[8] = "";
        wrongAnswer[9] = "";

    }


    public void complimentSecond() {
        String[] complimentSecond = new String[10];
        complimentSecond[0] = "\nМолодец!\n";
        complimentSecond[1] = "\nАгонь!\n";
        complimentSecond[2] = "\nТак держать!\n";
        complimentSecond[3] = "\nПревосходно!\n";
        complimentSecond[4] = "\nУмница!\n";
        complimentSecond[5] = "\nВеликолепно!\n";
        complimentSecond[6] = "\nВосхитительно!\n";
        complimentSecond[7] = "\nФеерично!\n";
        complimentSecond[8] = "\nВоодушевляюще!\n";
        complimentSecond[9] = "\nКруто!\n";

//круто супер воодушевляюще космос феерично
//ты просто ,космос, - вместо космос подставить слово - т е ето уже фраза
//погуглить: 100 слов похвалы - в вк есть осуждение

        System.out.println(complimentSecond[random()]);

    }

    public void complimentFirst() {

        String[] complimentFirst = new String[10];
        complimentFirst[0] = "превосходно!\n";
        complimentFirst[1] = "великолепно!\n";
        complimentFirst[2] = "круто!\n";
        complimentFirst[3] = "феерично!\n";
        complimentFirst[4] = "воодушевляюще!\n";
        complimentFirst[5] = "восхитительно!\n";
        complimentFirst[6] = "исключительно!\n";
        complimentFirst[7] = "грандиозно!\n";
        complimentFirst[8] = "легендарно!\n";
        complimentFirst[9] = "эпично!\n";

        System.out.println("\nЭто было " + complimentFirst[random()]);


    }

    public int random() {
//диапазон от и до
        int from = 0;
        int before = 9;
        int random = from + (int) (Math.random() * before);
        return random;
    }
}
